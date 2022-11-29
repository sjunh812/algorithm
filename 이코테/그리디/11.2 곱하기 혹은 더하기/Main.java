import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    // 첫 번째 문자를 숫자로 변경한 값을 대입
    long result = str.charAt(0) - '0';

    for (int i = 1; i < str.length(); i++) {
      // 두 중에서 하나라도 '0' 혹은 '1'인 경우, 곱하기보다는 더하기 수행
      int num = str.charAt(i) - '0';

      if (num <= 1 || result <= 1) {
        result += num;
      } else {
        result *= num;
      }
    }

    System.out.println(result);
  }
  
  private void mySolution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int result = Character.getNumericValue(s.charAt(0));

    for (int i = 1; i < s.length(); i++) {
      int n = Character.getNumericValue(s.charAt(i));

      if (result + n > result * n) result += n;
      else result *= n;
    }

    System.out.println(result);
  }
}