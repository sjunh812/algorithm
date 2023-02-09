import java.util.*;
import java.io.*;

class Main {

  int k, w, h;
  int[][] arr;
  int[][][] visited;

  static int[] dx = {-1, 1, 0, 0, -2, -1, 2, 1, 2, 1, -2, -1};
  static int[] dy = {0, 0, -1, 1, -1, -2, 1, 2, -1, -2, 1, 2};
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    k = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    w = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    arr = new int[h][w];
    visited = new int[h][w][k + 1];

    for (int i = 0; i < h; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < w; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    bfs(0, 0, k);

    int answer = Integer.MAX_VALUE;
    for (int i = 0; i <= k; i++) {
      if (visited[h - 1][w - 1][i] != 0) answer = Math.min(answer, visited[h - 1][w - 1][i]);
    }
    
    if (w == 1 && h == 1) System.out.println(0);
    else if (answer == Integer.MAX_VALUE) System.out.println(-1);
    else System.out.println(answer);
  }

  public void bfs(int x, int y, int k) {
    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(x, y, k, 0));
    visited[x][y][k] = 0;

    while (!q.isEmpty()) { 
      Node node = q.poll();
      x = node.getX();
      y = node.getY();
      k = node.getK();
      int dist = node.getDistance();

      for (int i = 0; i < 12; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && nx < h && ny >= 0 && ny < w && arr[nx][ny] == 0) {
          if (i > 3 && k < 1) break;
          
          if (i > 3) {
            if (visited[nx][ny][k - 1] == 0) {
              q.offer(new Node(nx, ny, k - 1, dist + 1));
              visited[nx][ny][k - 1] = dist + 1;
            }
          } else {
            if (visited[nx][ny][k] == 0) {
              q.offer(new Node(nx, ny, k, dist + 1));
              visited[nx][ny][k] = dist + 1;
            }
          }
        }
      }
    }
  }
}

class Node {

  private int x;
  private int y;
  private int k;
  private int distance;

  public Node(int x, int y, int k, int distance) {
    this.x = x;
    this.y = y;
    this.k = k;
    this.distance = distance;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public int getK() {
    return this.k;
  }

  public int getDistance() {
    return this.distance;
  }
}