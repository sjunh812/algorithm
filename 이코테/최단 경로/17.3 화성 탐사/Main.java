import java.util.*;
import java.io.*;

class Main {

  public static final int INF = (int) 1e9;
  public static final int[] dx = {1, -1, 0, 0};
  public static final int[] dy = {0, 0, -1, 1};

  int t;  // 테스트 케이스의 개수
  int n;  // 탐사 공간의 크기(N X N)
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    t = Integer.parseInt(br.readLine());  

    // 모든 테스트 케이스에 대하여
    for (int tc = 0; tc < t; tc++) {
      n = Integer.parseInt(br.readLine());

      int[][] area = new int[n][n];  // 탐사 공간

      // 탐사 공간의 정보를 입력받기
      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          area[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int[][] dp = new int[n][n];  // 최단거리 2차원 테이블

      // 최단거리 테이블을 모두 무한으로 초기화
      for (int i = 0; i < n; i++) {
        Arrays.fill(dp[i], INF);
      }

      // 다익스트라 알고리즘 수행
      dijkstra(area, dp);

      // 결과 값 출력
      System.out.println(dp[n - 1][n - 1]);
    }
  }

  public void dijkstra(int[][] area, int[][] dp) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(0, 0, area[0][0]));
    dp[0][0] = area[0][0];

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int x = node.getX();
      int y = node.getY();
      int dist = node.getDistance();

      if (dp[x][y] < dist) continue;
      
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
          int nDist = dist + area[nx][ny];
          
          if (nDist < dp[nx][ny]) {
            pq.offer(new Node(nx, ny, nDist));
            dp[nx][ny] = nDist;
          }
        }
      }
    }
  }
}

class Node implements Comparable<Node> {

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

  // 최단거리가 짧은 순
  @Override
  public int compareTo(Node other) {
    return this.distance - other.distance;
  }
}