import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int result = 0;
    
    if (n % 5 == 0) {
      result = n / 5;
    } else {
      int fiveMax = n / 5;
      int remain = n - fiveMax * 5;

      if (remain % 2 == 0) {
        int twoMax = remain / 2;
        result = fiveMax + twoMax;
      } else {
        if (fiveMax > 0) {
          fiveMax--;
          int remain2 = n - fiveMax * 5;
          
          if (remain2 % 2 == 0) {
            int twoMax = remain2 / 2;
            result = fiveMax + twoMax;
          } else {
            result = -1;
          }
        } else {
          if (n % 2 == 0) {
            result = n / 2;
          } else {
            result = -1;
          }
        }
      }
    }

    System.out.println(result);
  }
}