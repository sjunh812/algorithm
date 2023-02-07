import java.util.*;
import java.io.*;

class Main {

  int n, m;
  int[][] arr = new int[301][301];
  boolean[][] visited;

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int count;
    int time = 0;
    
    while (true) {
      int[][] nextArr = new int[301][301];
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
          nextArr[i][j] = arr[i][j];
        }
      }

      count = 0;
      visited = new boolean[301][301];
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
          if (!visited[i][j] && arr[i][j] != 0) {
            bfs(i, j, nextArr);
            count++;
          }
        }
      }

      if (count >= 2 || count == 0) break;
      arr = nextArr;
      time++;
    }

    if (count >= 2) System.out.println(time);
    else System.out.println(0);
  }

  public void bfs(int x, int y, int[][] nextArr) {
    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(x, y, arr[x][y]));
    visited[x][y] = true;

    while (!q.isEmpty()) {
      Node node = q.poll();
      x = node.getX();
      y = node.getY();
      int dist = node.getDistance();

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx > 0 && nx <= n && ny > 0 && ny <= m) {
          if (arr[nx][ny] == 0 && nextArr[x][y] != 0) nextArr[x][y]--;
          
          if (!visited[nx][ny] && arr[nx][ny] != 0) {
            q.offer(new Node(nx, ny, arr[nx][ny]));
            visited[nx][ny] = true;
          }
        }
      }
    }
  }
}

class Node {

  private int x;
  private int y;
  private int distance;

  public Node(int x, int y, int distance) {
    this.x = x;
    this.y = y;
    this.distance = distance;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public int getDistance() {
    return this.distance;
  }
}