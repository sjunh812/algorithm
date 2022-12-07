import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution2();
  } 

  private void solution2() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] houses = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      houses[i] = Integer.parseInt(st.nextToken());  
    }

    Arrays.sort(houses);

    int result = 0;
    
    if (houses.length % 2 == 0) result = houses[houses.length / 2 - 1];
    else result = houses[houses.length / 2];

    System.out.println(result);
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] houses = new int[n];
    long sumA = 0;
    long cntA = 0;
    long sumB = 0;
    long cntB = 0;
    long interval = -1;
    int result = 0;
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      houses[i] = Integer.parseInt(st.nextToken());  
      sumB += houses[i];
    }

    Arrays.sort(houses);
    cntB = houses.length;

    for (int i = 0; i < houses.length; i++) {
      int house = houses[i];
      
      sumB -= house;
      cntB--;

      long totalSum = (house * cntA + sumA) + (-house * cntB + sumB);
      if (interval == -1 || interval > totalSum) {
        interval = totalSum;
        result = house;
      }

      sumA -= house;
      cntA++;
    }

    System.out.println(result);
  }
}