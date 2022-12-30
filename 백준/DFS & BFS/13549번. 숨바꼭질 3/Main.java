import java.util.*;
import java.io.*;

class Main {

  int n;
  int k;
  int[] visited = new int[100001];

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    System.out.println(bfs());
  }

  public int bfs() {
    Queue<Position> q = new LinkedList<>();
    q.offer(new Position(n, 0));
    visited[n] = 1;

    while (!q.isEmpty()) {
      Position pos = q.poll();
      int x = pos.getX();
      int time = pos.getTime();
      
      if (x == k) return time;

      // 순간이동
      // 간선의 비용이 0이므로 우선적으로 큐에 삽입
      if (k > x) {
        int x2 = x;
        while (x2 > 0 && k > x2) {
          x2 *= 2;
          if (x2 <= 100000) {
            q.offer(new Position(x2, time));
            visited[x2] = 1; 
          }
        }
      }
        
      // 뒤로 걷기
      int nx1 = x - 1;
      if (nx1 >= 0 && nx1 <= 100000 && visited[nx1] == 0) {
        q.offer(new Position(nx1, time + 1));
        visited[nx1] = 1;
      }
      
      // 앞으로 걷기
      int nx2 = x + 1;
      if (nx2 >= 0 && nx2 <= 100000 && visited[nx2] == 0) {
        q.offer(new Position(nx2, time + 1));
        visited[nx2] = 1;
      }
    }

    return -1;
  }
}

class Position {

  private int x;
  private int time;

  public Position(int x, int time) {
    this.x = x;
    this.time = time;
  }

  public int getX() {
    return this.x;
  }

  public int getTime() {
    return this.time;
  }
}