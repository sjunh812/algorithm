import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void mySolution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int cnt = 0;

    while (n > 1) {
      if (n % k == 0) {
        n /= k;
      } else {
        n -= 1;
      }

      cnt++;
    }

    System.out.println(cnt);
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int result = 0;

    while (true) {
      // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
      int target = (n / k) * k;  // N이 K로 나누어 떨어지는 가장 큰 수
      result += (n - target);  // 1씩 빼줄 횟수
      n = target;

      // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
      if (n < k) break;

      // K로 나누기
      result += 1;
      n /= k;
    }

    // 마지막 남은 수에 대하여 1씩 빼기
    result += (n - 1);
    System.out.println(result);
  }
}