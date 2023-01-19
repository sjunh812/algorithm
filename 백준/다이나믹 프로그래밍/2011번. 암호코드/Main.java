import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String password = br.readLine();
    int n = password.length();
    int mod = 1000000;
    
    long[] dp = new long[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      String sub = password.substring(0, i);
      
      String one = sub.substring(sub.length() - 1);
      if (!one.equals("0")) {
        dp[i] = dp[i - 1] % mod;
      }
      
      if (sub.length() > 1) {
        String two = sub.substring(sub.length() - 2);
        if (two.charAt(0) != '0' && Integer.parseInt(two) <= 26) {
          dp[i] = (dp[i] + dp[i - 2]) % mod;
        }
      }
    }

    if (n == 0) System.out.println(0);
    else System.out.println(dp[n]);
  }
}