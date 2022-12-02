import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int g = Integer.parseInt(br.readLine());  // 게이트 수
    int p = Integer.parseInt(br.readLine());  // 비행기 수
    int[] maxGates = new int[p];  // 비행기 별 도킹 가능한 게이트 범위의 최대값
    int[] gates = new int[g + 1];  // 게이트 별 도킹 가능 탐색 횟수
    int result = 0;  // 도킹된 비행기 수
    boolean stop = false;  // 공항이 폐쇠됐는지 여부

    for (int i = 0; i < p; i++) {     
      int max =  Integer.parseInt(br.readLine());

      if (!stop) {
        int j = max;
      
        while (j > 0 && gates[j] > 0) {
          int cnt = gates[j];
          gates[j]++;
          j = j - cnt;
        }
  
        if (j <= 0) {
          stop = true;
        } else {
          gates[j] = 1;
          result++;
        } 
      }

      // boolean flag = false;

      // if (!stop) {
      //   for (int j = max; j >= 1; j--) {  
      //     int cnt = gates[j]++;
             
      //     if (cnt == 0) { 
      //       flag = true;
      //       break;
      //     } else {
      //       j -= (cnt - 1);   
      //     }  
      //   }  

      //   if (flag) result++;
      //   else stop = true;
      // } 
    }

    System.out.println(result);
  }
}