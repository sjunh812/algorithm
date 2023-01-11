import java.util.*;
import java.io.*;

class Main2 {
  
  public static void main(String[] args) throws Exception {
    new Main2().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[][] dp = new int[500][500];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      for (int j = 0; j <= i; j++) {
        dp[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 다이나믹 프로그래밍으로 2번째 줄부터 내려가면서 확인
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        int upLeft, up;

        // 왼쪽 위에서
        if (j == 0) upLeft = 0;
        else upLeft = dp[i - 1][j - 1];

        // 위에서
        if (j == i) up = 0;
        else up = dp[i - 1][j];

        // 최대 합
        dp[i][j] = dp[i][j] + Math.max(upLeft, up);
      }
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      result = Math.max(result, dp[n - 1][i]);
    }
    
    System.out.println(result);
  }
}