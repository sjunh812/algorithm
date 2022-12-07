import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
  
class Main {  
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }
  
  private boolean check(int h, int m, int s) {
    if (h % 10 == 3 || m % 10 == 3 || m / 10 == 3 || s % 10 == 3 || s / 10 == 3) return true;
    return false;
  }
  
  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int result = 0;

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= 59; j++) {
        for (int k = 0; k <= 59; k++) {
            if (check(i, j, k)) result++;
        }
      }
    }

    System.out.println(result);
  }
  
  private void mySolution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int result = 0;

    // 00분 00초 ~ 59분 59초 전체 경우의 수: 3600가지
    // 00분 00초 ~ 59분 59초 중 숫자 3을 하나이상 포함하는 경우의 수: 1575가지
    if (n == 23) {  // n = 23, 13, 3 포함
      result = 3 * 3600 + (n - 2) * 1575;
    } else if (n >= 13) {  // n = 13, 3 포함
      result = 2 * 3600 + (n - 1) * 1575;
    } else if (n >= 3) {  // n = 3 포함
      result = 1 * 3600 + n * 1575;
    } else {  // 3을 포함하는 n이 없음
      result = 0 * 3600 + (n + 1) * 1575;
    }

    System.out.println(result);
  }
}