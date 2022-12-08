import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int summary = 0;

    // 왼쪽 부분의 자릿수의 합 더하기
    for (int i = 0;  < str.length() / 2; i++) {
      summary += str.charAt(i) - '0';
    }

    // 오른쪽 부분의 자릿수의 합 빼기
    for (int i = str.length() / 2; i < str.length(); i++) {
      summary -= str.charAt(i) - '0';
    }

    // 왼쪽 부분과 오른쪽 부분의 자릿수 합이 동일한지 검사
    if (summary == 0) System.out.println("LUCKY");
    else System.out.println("READY");
  }
                                                           
  private void mySolution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String n = br.readLine();
    String left = n.substring(0, n.length() / 2);
    String right = n.substring(n.length() / 2);
    int leftSum = 0;
    int rightSum = 0;
    String result;

    for (int i = 0; i < n.length() / 2; i++) {
      leftSum += left.charAt(i) - '0';
      rightSum += right.charAt(i) - '0';
    }
    
    if (leftSum == rightSum) result = "LUCKY";
    else result = "READY";

    System.out.println("leftSum : " + leftSum + ", rightSum : " + rightSum + ", result : " + result);
  }
}