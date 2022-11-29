import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] coins = new int[n];
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      coins[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(coins);

    int target = 1;
    for (int i = 0; i < n; i++) {
      // 만들 수 없는 금액을 찾을 때 반복 종료
      if (target < coins[i]) break;

      target += coins[i];
    }

    System.out.println(target);
  }

  private void mySolution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] coins = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      coins[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(coins);
    
    int target = 1;
    int result = 1;
    
    for (int i = 0; i < coins.length; i++) {
      int coin = coins[i];

      if (target >= coin) target += coin;
      else break;
    }

    System.out.println(target);
  }
}