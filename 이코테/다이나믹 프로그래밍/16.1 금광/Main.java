import java.util.*;
import java.io.*;

class Main {

  public int t, n, m;
  public int[][] arr = new int[20][20];
  public int[][] dp = new int[20][20];

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 테스트 케이스 입력
    t = Integer.parseInt(br.readLine());

    for (int tc = 0; tc < t; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      // 금광 정보 입력
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
          dp[i][j] = arr[i][j];  // 다이나믹 프로그래핑을 위한 2차원 DP 테이블 초기화
        }
      }

      // 다이나믹 프로그래밍 진행
      for (int j = 1; j < m; j++) {
        for (int i = 0; i < n; i++) {
          int leftUp, left, leftDown;

          // 왼쪽 위에서
          if (i == 0) leftUp = 0;
          else leftUp = dp[i - 1][j - 1];

          // 왼쪽에서
          left = dp[i][j - 1];

          // 왼쪽 아래에서
          if (i == n - 1) leftDown = 0;
          else leftDown = dp[i + 1][j - 1];

          dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(left, leftDown));
        }
      }

      int result = 0;
      for (int i = 0; i < n; i++) {
        result = Math.max(result, dp[i][m - 1]);
      }

      System.out.println(result);
    }
  }
}