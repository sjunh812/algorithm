import java.util.*;
import java.io.*;

class Main {

  int m;  // 상자의 열
  int n;  // 상자의 행
  int h;  // 상자의 높이
  int[][][] graph;  // 상자

  // 토마토의 이동 거리(상, 하, 좌, 우, 위, 아래)
  int[] dx = {-1, 1, 0, 0, 0, 0};
  int[] dy = {0, 0, -1, 1, 0, 0};
  int[] dz = {0, 0, 0, 0, -1, 1};
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    // 상자 그리기
    graph = new int[n][m][h];
    ArrayList<Node> ripeTomatos = new ArrayList<>();  // 익은 토마토 리스트
    for (int k = 0; k < h; k++) {
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
          graph[i][j][k] = Integer.parseInt(st.nextToken());
          if (graph[i][j][k] == 1) ripeTomatos.add(new Node(i, j, k, 0));
        }
      }
    }

    int result = bfs(ripeTomatos);
    
    if (ripeAll()) System.out.println(result);
    else System.out.println(-1);
  }

  // 너비 우선 탐색(BFS)
  public int bfs(ArrayList<Node> ripe) {
    int result = 0;  // 탐색에 걸리는 최소 시간

    // 처음에 큐에 익은 토마토의 위치 정보를 삽입
    Queue<Node> q = new LinkedList<>();
    for (Node node : ripe) {
      q.offer(node);
    }

    while (!q.isEmpty()) {
      Node node = q.poll();
      int x = node.getX();
      int y = node.getY();
      int z = node.getZ();
      int time = node.getTime();

      result = Math.max(result, time);
      
      for (int i = 0; i < 6; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        int nz = z + dz[i];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h) {      
          if (graph[nx][ny][nz] == 0) {
            q.offer(new Node(nx, ny, nz, time + 1));
            graph[nx][ny][nz] = 1;
          }
        }
      }
    }

    return result;
  }

  // 상자에 있는 토마토들이 모두 익었는지 확인
  public boolean ripeAll() {
    for (int k = 0; k < h; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (graph[i][j][k] == 0) return false;
        }
      }
    }

    return true;
  }
}

class Node {

  private int x;
  private int y;
  private int z;
  private int time;

  public Node(int x, int y, int z, int time) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.time = time;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public int getZ() {
    return this.z;
  }

  public int getTime() {
    return this.time;
  }
}