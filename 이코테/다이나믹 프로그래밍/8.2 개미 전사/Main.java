import java.util.*;
import java.io.*;

class Main {

  public static int[] dp = new int[101];

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 다이나믹 프로그래밍(Dynamic Programming) 진행(바텀업)
    dp[0] = arr[0];
    dp[1] = Math.max(arr[0], arr[1]);
    for (int i = 2; i < n; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
    }

    System.out.println(dp[n - 1]);
  }
}