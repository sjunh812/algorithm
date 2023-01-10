import java.util.*;
import java.io.*;

class Main {

  // 앞서 계산된 결과를 저장하기 위한 dp 테이블 초기화
  public static int[] dp = new int[1001];

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    // 다이나믹 프로그래밍(Dynamic Programming) 진행(바텀업)
    dp[1] = 1;
    dp[2] = 3;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[ i - 2] * 2;
    }

    System.out.println(dp[n]);
  }
}