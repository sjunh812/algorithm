import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    for (int tc = 0; tc < t; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      long[][] dp = new long[30][30];

      System.out.println(combination(dp, m, n));
    }
  }

  public long combination(long[][] dp, int n, int r) {
    if (r == 1) return n;
    if (n == r) return 1;
    if (dp[n][r] != 0) return dp[n][r];  // 메모이제이션(Memoization)

    dp[n][r] = combination(dp, n - 1, r - 1) + combination(dp, n - 1, r);
    return dp[n][r];
  }
}