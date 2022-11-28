public class Main {
  
  public static void main(String[] args) {
    // 거스름돈 동전 종류 : 500원, 100원, 50원, 10원
    // N = 1260원
    int n = 1260;
    int result = 0;
    int[] coins = {500, 100, 50, 10};

    for(int i = 0; i < 4; i++) {
      int coin = coins[i];

      result += n / coin;
      n %= coin;
    }

    System.out.println(result);
  }
}