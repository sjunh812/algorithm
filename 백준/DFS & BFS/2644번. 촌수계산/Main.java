import java.util.*;
import java.io.*;

class Main {

  int n, m, x, y;
  int[][] dp = new int[101][101];
  static final int INF = (int) 1e9;
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    n = Integer.parseInt(br.readLine());  // 전체 사람의 수
    
    // 촌수를 계산할 두 사람
    st = new StringTokenizer(br.readLine());
    x = Integer.parseInt(st.nextToken());  
    y = Integer.parseInt(st.nextToken());  

    m = Integer.parseInt(br.readLine());  // 관계의 수

    for (int i = 1; i <= n; i++) {
      Arrays.fill(dp[i], INF);
      dp[i][i] = 0;
    }
    
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());  // 부모
      int y = Integer.parseInt(st.nextToken());  // 자식
      dp[x][y] = 1;
      dp[y][x] = 1;
    }

    // 플로이드-워셜
    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
           dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
        }
      }
    }

    int answer = dp[x][y];
    if (answer == INF) System.out.println(-1);
    else System.out.println(answer);
  }
}