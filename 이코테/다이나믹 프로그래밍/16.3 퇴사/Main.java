import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] t = new int[n];
    int[] p = new int[n];
    
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      t[i] = Integer.parseInt(st.nextToken());
      p[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[n + 2];
    int max = 0;
    
    for (int i = 0; i <= n; i++) {
      dp[i] = Math.max(max, dp[i]);
      max = dp[i];
      if (i < n && i + t[i] <= n + 1) dp[i + t[i]] = Math.max(max + p[i], dp[i + t[i]]);
    }
    
    System.out.println(dp[n]);
  }
}