import java.util.*;
import java.io.*;

class Main {

  int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
  int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
  int answer = 0;

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Fish[] fishes = new Fish[17];
    
    for (int i = 0; i < 4; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int j = 0; j < 4; j++) {
        int a = Integer.parseInt(st.nextToken());  // 물고기의 번호
        int b = Integer.parseInt(st.nextToken()) - 1;  // 물고기의 방향(0 ~ 7)
        fishes[a] = new Fish(i, j, b);
      }
    }

    // 완전 탐색(DFS) 수행
    dfs(0, 0, 0, fishes);

    // 결과값을 출력
    System.out.println(answer);
  }

  public void dfs(int x, int y, int sum, Fish[] fishes) {
    // 물고기의 정보를 담은 배열에 대한 깊은 복사
    Fish[] temp = new Fish[17];
    for (int j = 1; j <= 16; j++) {
      if (fishes[j] != null) temp[j] = new Fish(fishes[j].getX(), fishes[j].getY(), fishes[j].getDirection());
    }

    int[][] map = new int[4][4];  // 물고기의 번호 및 상어의 위치를 나타내는 맵
    int direction = 0;  // 상어의 방향

    // 상어가 물고기를 잡아먹는다.
    for (int i = 1; i <= 16; i++) {
      if (temp[i] != null) {  // 잡아먹히지 않은 물고기에 대하여
        if (x == temp[i].getX() && y == temp[i].getY()) {   
          map[temp[i].getX()][temp[i].getY()] = -1;  // 상어의 위치 갱신
          direction = temp[i].getDirection();  // 상어의 방향 갱신
          temp[i] = null;  // 먹힌 물고기는 null
          
          // 정답 갱신
          sum += i;
          answer = Math.max(answer, sum);  
        } else {  // 물고기의 위치를 맵에 그림
          map[temp[i].getX()][temp[i].getY()] = i;
        }
      } 
    }

    // 물고기 이동
    moveFish(map, temp);
    
    for (int i = 1; i < 4; i++) {
      int nx = x + dx[direction] * i;
      int ny = y + dy[direction] * i;

      if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != 0) dfs(nx, ny, sum, temp);
    }
  }

  public void moveFish(int[][] map, Fish[] fishes) {
    for (int i = 1; i <= 16; i++) {
      if (fishes[i] != null) {  // 잡아먹히지 않은 물고기에 대하여
        int x = fishes[i].getX();
        int y = fishes[i].getY();
        
        for (int j = 0; j < 8; j++) {
          int direction = (fishes[i].getDirection() + j) % 8;
          int nx = x + dx[direction];
          int ny = y + dy[direction];
          
          if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != -1) {
            fishes[i].setDirection(direction);  // 물고기의 방향 갱신!!(중요)
            
            if (map[nx][ny] == 0) {  // 빈칸으로 이동
              fishes[i].setXY(nx, ny);
              map[x][y] = 0;
            } else {  // 다른 물고기와 위치 변경
              swap(i, map[nx][ny], fishes);
              map[x][y] = map[nx][ny];
            }

            map[nx][ny] = i;
            
            break;
          }
        }
      }
    }
  }

  // 물고기 이동시, 두 물고기간의 위치 바꾸기
  public void swap(int a, int b, Fish[] fishes) {
    int x1 = fishes[a].getX();
    int y1 = fishes[a].getY();
    int x2 = fishes[b].getX();
    int y2 = fishes[b].getY();
    fishes[a].setXY(x2, y2);
    fishes[b].setXY(x1, y1);
  }
}

class Fish {

  private int x;
  private int y;
  private int direction;

  public Fish(int x, int y, int direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public void setXY(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void setDirection(int direction) {
    this.direction = direction;
  }

  public int getDirection() {
    return this.direction;
  }
}