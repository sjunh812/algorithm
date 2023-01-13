import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());  // 계단의 개수

    // 계단 정보 입력
    int[] arr = new int[n];  
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    // 다이나믹 프로그래밍을 위한 2차원 DP 테이블
    int[][] dp = new int[n + 1][2]; 
    dp[1][0] = arr[0];
    dp[1][1] = arr[0];

    for (int i = 2; i <= n; i++) {
      dp[i][0] = arr[i - 1] + dp[i - 1][1];
      dp[i][1] = arr[i - 1] + Math.max(dp[i - 2][0], dp[i - 2][1]);
    }

    System.out.println();
    for (int i = 0; i <= n; i++) {
      System.out.println(dp[i][0] + ", " + dp[i][1]);
    }
    System.out.println();

    System.out.println(Math.max(dp[n][0], dp[n][1]));
  }
}