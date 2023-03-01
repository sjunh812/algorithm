import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    boolean[] arr = new boolean[n + 1];
    // 처음엔 모든 수가 소수(true)인 것으로 초기화(0과 1은 제외)
    Arrays.fill(arr, true);
    arr[0] = false;
    arr[1] = false;

    // 에라토스테네스의 체
    // 2부터 n의 제곱근까지의 모든 수를 확인
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (arr[i]) {  // i가 소수인 경우(남은 수인 경우)
        // i를 제외한 i의 모든 배수를 지우기
        int j = 2;
        while (i * j <= n) {
          arr[i * j] = false;
          j++;
        }
      }
    }

    // 모든 소수 출력
    for (int i = 2; i <= n; i++) {
      if (arr[i]) System.out.print(i + " ");
    }
  }
}