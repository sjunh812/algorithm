import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    System.out.println(isPrimeNumber(n));
  }

  public boolean isPrimeNumber(int x) {
    // 2부터 x의 제곱근까지의 모든 수를 확인
    for (int i = 2; i <= Math.sqrt(x); i++) {
      if (x % i == 0) return false;  // 소수가 아님
    }
    return true;  // 소수
  }
}