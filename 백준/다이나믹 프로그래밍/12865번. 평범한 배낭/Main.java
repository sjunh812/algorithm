import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[][] arr = new int[n][2];
    int[] dp = new int[k + 1];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      int w = arr[i][0];
      int v = arr[i][1];

      for (int j = k; j >= w; j--) {
        dp[j] = Math.max(dp[j], dp[j - w] + v);
      }
    }

    System.out.println(dp[k]);
  }
}