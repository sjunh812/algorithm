import java.util.*;
import java.io.*;

class Main {

  int n, m, k;
  Node[][] map = new Node[21][21];
  Node[][] nextMap = new Node[21][21];
  int[] direction = new int[401];
  int[][][] directionPriority = new int[401][5][4];
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    // 맵의 정보 입력받기
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        int number = Integer.parseInt(st.nextToken());
        map[i][j] = new Node(i, j, number, -1);
        nextMap[i][j] = new Node(i, j, number, -1);
      }
    }

    // 상어의 현재위치 입력받기
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= m; i++) {
      direction[i] = Integer.parseInt(st.nextToken());
    }

    // 상어의 방향 우선순위 입력받기
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= 4; j++) {
        st = new StringTokenizer(br.readLine());
        for (int w = 0; w < 4; w++) {
          directionPriority[i][j][w] = Integer.parseInt(st.nextToken());
        }
      }      
    }

    int totalTime = 1;
    
    while (totalTime <= 1000) {
      for (int x = 1; x <= n; x++) {
        for (int y = 1; y <= n; y++) {
          int number = map[x][y].getNumber();
          int time = map[x][y].getTime();

          if (number != 0) {  // 상어? 냄새?
            if (time == -1) {  // 상어
              int dir = direction[number];  // 상어의 방향
              boolean move = false;  // 빈칸으로 이동 여부
              
              // 이동할 위치가 빈칸인지 확인
              for (int next : directionPriority[number][dir]) {
                direction[number] = next;  // 방향갱신
                
                int nx = x + dx[next - 1];
                int ny = y + dy[next - 1];

                if (nx > 0 && nx <= n && ny > 0 && ny <= n && map[nx][ny].getNumber() == 0) {
                  if (nextMap[nx][ny].getNumber() == 0 || nextMap[nx][ny].getNumber() > number) {
                    nextMap[nx][ny] = new Node(nx, ny, number, -1);
                  } 
                  nextMap[x][y] = new Node(x, y, number, k - 1);
                  move = true;
                  
                  break;
                }
              }
              
              if (move) continue;
              
              // 이동할 위치가 자신의 냄새인지 확인
              for (int next : directionPriority[number][dir]) {
                direction[number] = next;  // 방향갱신
                
                int nx = x + dx[next - 1];
                int ny = y + dy[next - 1];

                if (nx > 0 && nx <= n && ny > 0 && ny <= n && map[nx][ny].getNumber() == number) {
                  nextMap[nx][ny] = new Node(nx, ny, number, -1);
                  nextMap[x][y] = new Node(x, y, number, k - 1);
                  break;
                }
              }
            } else if (nextMap[x][y].getTime() != -1) {  // 냄새
              if (time == 1) nextMap[x][y] = new Node(x, y, 0, -1);  
              else nextMap[x][y].downTime();
            }
          }
        }
      }
      
      int count = 0;
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {          
          map[i][j] = nextMap[i][j];
          if (map[i][j].getNumber() != 0 && map[i][j].getTime() == -1) count++;
        }
      }

      if (count == 1) break;
      
      totalTime++;
    }

    if (totalTime > 1000) System.out.println("-1");
    else System.out.println(totalTime);
  }
}

class Node {

  private int x;
  private int y;
  private int number;
  private int time;

  public Node(int x, int y, int number, int time) {
    this.x = x;
    this.y = y;
    this.number = number;
    this.time = time;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public int getNumber() {
    return this.number;
  }

  public int getTime() {
    return this.time;
  }

  public void downTime() {
    time--;
  }
}