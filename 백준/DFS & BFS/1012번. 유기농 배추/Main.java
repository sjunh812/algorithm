import java.util.*;
import java.io.*;

class Main {

  int t;  // 테스트 케이스의 개수
  int m;  // 배추밭의 가로길이(열)
  int n;  // 배추밭의 세로길이(행)
  int k;  // 배추가 심어진 위치의 개수
  int[][] graph;  // 밭

  // 배추흰지렁이의 이동 거리
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      graph = new int[n][m];
    
      ArrayList<Node> cabbages = new ArrayList<>();
      for (int j = 0; j < k; j++) {
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph[x][y] = 1;
        cabbages.add(new Node(x, y));
      }

      int count = 0;

      for (int j = 0; j < cabbages.size(); j++) {
        if (bfs(cabbages.get(j))) count++;
      }

      System.out.println(count);
    }
  }

  public boolean bfs(Node start) {
    if (graph[start.getX()][start.getY()] != 1) return false;
    
    Queue<Node> q = new LinkedList<>();
    q.offer(start);
    graph[start.getX()][start.getY()] = -1;

    while (!q.isEmpty()) {
      Node node = q.poll();
      int x = node.getX();
      int y = node.getY();
      
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
          if (graph[nx][ny] == 1) {
            q.offer(new Node(nx, ny));
            graph[nx][ny] = -1;
          }
        }
      }
    }

    return true;
  }
}

class Node {

  private int x;
  private int y;

  public Node(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }
}
