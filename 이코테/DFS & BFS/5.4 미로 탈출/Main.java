import java.util.*;
import java.io.*;

class Main {

  int n;  // 미로의 행
  int m;  // 미로의 열
  int[][] miro;  // 미로

  // 이동 방향(상하좌우)
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};

  int result = 0;  // 최소 이동 칸의 개수
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    miro = new int[n][m];

    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        miro[i][j] = line.charAt(j) - '0';
      }
    }

    System.out.println(bfs(0, 0));
  }

  private int bfs(int startX, int startY) {
    Queue<ArrayList<Integer>> q = new LinkedList<>();
    ArrayList<Integer> start = new ArrayList<>();
    start.add(startX);
    start.add(startY);
    q.offer(start);

    while (!q.isEmpty()) {
      int x = q.peek().get(0);
      int y = q.poll().get(1);

      // 이동 방향에 따라 방문 처리
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        
        // 미로 범위 내에서
        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
          if (miro[nx][ny] == 1) {  // 괴물이 없는 위치
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add(nx);
            pos.add(ny);
            q.offer(pos);  // 큐 삽입
            miro[nx][ny] = miro[x][y] + 1;  // 방문 처리(거리의 합으로 표시)        
          }
        }
      }
    }

    return miro[n - 1][m - 1];
  }
}