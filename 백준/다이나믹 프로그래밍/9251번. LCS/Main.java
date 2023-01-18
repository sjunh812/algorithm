import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 두 문자열 입력받기
    String s1 = br.readLine();
    String s2 = br.readLine();

    // 다이나믹 프로그래밍을 위한 2차원 DP 테이블 초기화
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    // 다이나믹 프로그래밍 수행
    for (int i = 1; i <= s1.length(); i++) {
      char c1 = s1.charAt(i - 1);

      for (int j = 1; j <= s2.length(); j++) {
        char c2 = s2.charAt(j - 1);

        if (c1 == c2) dp[i][j] = dp[i - 1][j - 1] + 1;
        else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    // 결과값 출력
    System.out.println(dp[s1.length()][s2.length()]);
  }
}