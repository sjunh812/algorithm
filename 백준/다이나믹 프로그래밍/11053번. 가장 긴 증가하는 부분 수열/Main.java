import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());  // 수열 a의 크기
    int[] a = new int[n];  // 수열 a
    int[] dp = new int[n];  // DP 테이블

    // 수열 a 입력 받기
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
      dp[i] = 1;
    }

    // 다이나믹 프로그래밍 
    for (int i = 1; i < n; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (a[j] < a[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
      }
    }

    int max = 0;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }
}