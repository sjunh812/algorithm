import java.util.*;
import java.io.*;

class Main {

  int n;  // 맵의 행
  int m;  // 맵의 열
  int[][] map;  // 맵
  
  // 이동 거리(상, 하, 좌, 우)
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};

  int result = Integer.MAX_VALUE;  // 최단 경로
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    
    // 최초의 맵 그리기
    map = new int[n][m];
    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < m; j++) {
        map[i][j] = str.charAt(j) - '0';
      }
    }
    
    bw.write(String.valueOf(bfs()));
    bw.write("\n");
    bw.flush();
  }

  // 너비 우선 탐색(BFS)
  public int bfs() {
    // 맵 복사
    int[][] notBrokenMap = new int[n][m];  // 벽을 부수지 않고 방문 처리
    int[][] brokenMap = new int[n][m];  // 벽을 하나라도 부술 때의 방문 처리(단, 최적의 해)
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        notBrokenMap[i][j] = map[i][j];
        brokenMap[i][j] = map[i][j];
      }
    }

    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(0, 0, 1, false));
    notBrokenMap[0][0] = 1;

    while (!q.isEmpty()) {
      Node node = q.poll();
      int x = node.getX();
      int y = node.getY();
      int dist = node.getDistance();
      boolean broken = node.getBroken();

      // 최단 거리
      if (x == n - 1 && y == m - 1) return dist;  

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
          // 벽을 부순적 없이 맵에서 벽을 만났을 때
          if (!broken && map[nx][ny] == 1) {
            q.offer(new Node(nx, ny, dist + 1, true));  // 해당 벽을 부숨
          }

          // 벽을 부순적 없이 이동 가능할 때
          if (!broken && notBrokenMap[nx][ny] == 0) {
            q.offer(new Node(nx, ny, dist + 1, broken));
            notBrokenMap[nx][ny] = 1;  // 벽을 부수지않을 때의 방문 처리
          }

          // 벽을 부순적 있이 이동 가능할 때
          if (broken && brokenMap[nx][ny] == 0) {
            q.offer(new Node(nx, ny, dist + 1, broken));
            brokenMap[nx][ny] = 1;  // 벽을 부술 때의 방문 처리
          }
        }
      }
    }

    return -1;
  }
}


class Node {

  private int x;
  private int y;
  private int distance;
  private boolean broken;

  public Node(int x, int y, int distance, boolean broken) {
    this.x = x;
    this.y = y;
    this.distance = distance;
    this.broken = broken;
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

  public boolean getBroken() {
    return this.broken;
  }
}