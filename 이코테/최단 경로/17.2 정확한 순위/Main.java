import java.util.*;
import java.io.*;

class Main {

  public static final int INF = (int) 1e9;
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] dp = new int[501][501];

    for (int i = 0; i < 501; i++) {
      Arrays.fill(dp[i], INF);
      dp[i][i] = 0;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      
      dp[a][b] = 1;
    }

    for (int k = 1; k <= n; k++) {
      for (int a = 1; a <= n; a++) {
        for (int b = 1; b <= n; b++) {
          dp[a][b] = Math.min(dp[a][b], dp[a][k] + dp[k][b]);
        }
      }
    }

    int result = 0;
    for (int a = 1; a <= n; a++) {
      int count = 0;
      for (int b = 1; b <= n; b++) {
        if (a != b && (dp[a][b] != INF || dp[b][a] != INF)) count++;
        if (dp[a][b] == INF) System.out.print(0 + " ");
        else System.out.print(dp[a][b] + " ");
      }
      if (count == n - 1) result++;
      System.out.println();
      
    }
    System.out.println();
    System.out.println(result);
  }
}