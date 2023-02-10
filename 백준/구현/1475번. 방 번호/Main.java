import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String numStr = br.readLine();

    int[] dp = new int[10];
    for (int i = 0; i < numStr.length(); i++) {
      int num = numStr.charAt(i) - '0';

      if (num == 6 || num == 9) {
        if (dp[6] < dp[9]) dp[6]++;
        else if (dp[6] > dp[9]) dp[9]++;
        else dp[num]++;
      } else {
        dp[num]++;
      }
    }

    int answer = 0;
    for (int i = 0; i < 10; i++) {
      answer = Math.max(answer, dp[i]);
    }
    System.out.println(answer);
  }
}