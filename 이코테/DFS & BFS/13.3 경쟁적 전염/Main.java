import java.util.*;
import java.io.*;

class Virus implements Comparable<Virus> {

  private int number;
  private int x;
  private int y;

  public Virus(int number, int x, int y) {
    this.number = number;
    this.x = x;
    this.y = y;
  }

  public int getNumber() {
    return this.number;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  @Override
  public int compareTo(Virus other) {
    return Integer.compare(this.number, other.number);
  }
}

class Main {

  int n;  // 시험관의 크기
  int k;  // 바이러스의 종류
  int s;  // 시간
  int x, y;  // 계산할 바이러스의 좌표
  int[][] arr;  // 시험관
  PriorityQueue<Virus> virusList = new PriorityQueue<>();  // 시험관에 존재하는 바이러스 리스트

  // 바이러스 이동 방향
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    arr = new int[n + 1][n + 1];
    
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      
      for (int j = 1; j <= n; j++) {
        int virus = Integer.parseInt(st.nextToken());
        
        if (virus != 0) {
          virusList.add(new Virus(virus, i, j));
        }
        
        arr[i][j] = virus;
      }
    }

    st = new StringTokenizer(br.readLine());
    s = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    
    for (int i = 0; i < s; i++) {
      if (virusList.isEmpty()) break;

      ArrayList<Virus> tmp = new ArrayList<>();

      while (!virusList.isEmpty()) {
        Virus virus = virusList.poll();
        int number = virus.getNumber();
        int x = virus.getX();
        int y = virus.getY();
        
        for (int k = 0; k < 4; k++) {
          int nx = x + dx[k];
          int ny = y + dy[k];
    
          if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
            if (arr[nx][ny] == 0) {
              arr[nx][ny] = number;
              tmp.add(new Virus(number, nx, ny));
            }
          }
        }
      }

      for (Virus virus : tmp) {
        virusList.add(virus);
      }
    }
    
    System.out.println(arr[x][y]);
  }
}