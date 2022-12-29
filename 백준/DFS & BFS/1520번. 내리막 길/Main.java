import java.util.*;
import java.io.*;

class Main {

  int m;  // 세로의 크기(행)
  int n;  // 가로의 크기(열)
  int[][] map;  // 지도
  int[][] dp;  // dp

  // 이동 거리
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};

  int result = 0;  // 내리막길로만 이동에 성공한 횟수
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
      
    map = new int[m][n];
    dp = new int[m][n];

    // 지도 그리기
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {  
        map[i][j] = Integer.parseInt(st.nextToken());
        dp[i][j] = -1;
      }
    }

    System.out.println(dfs(0, 0));
  }

  public int dfs(int x, int y) {
    if (x == m - 1 && y == n - 1) return 1;

    if (dp[x][y] != -1) return dp[x][y];

    dp[x][y] = 0;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
        if (map[x][y] > map[nx][ny]) {
          dp[x][y] += dfs(nx, ny);
        } 
      }
    }

    return dp[x][y];
  }
}