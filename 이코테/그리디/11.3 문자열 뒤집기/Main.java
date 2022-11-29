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
    int count0 = 0;  // 전부 0으로 바뀌는 경우
    int count1 = 0;  // 전부 1로 바뀌는 경우

    // 첫 번째 원소에 대해서 처리
    if (str.charAt(0) == '1') count0++;
    else count1++;

    // 두 번째 원소부터 모든 원소를 확인하며
    for (int i = 0; i < str.length() - 1 ; i++) {
      if (str.charAt(i) != str.charAt(i + 1)) {
        // 다음 수에서 0으로 바뀌는 경우
        if (str.charAt(i + 1) == '1') count0++;
        // 다음 수에서 1로 바뀌는 경우
        else count1++;
      }
    }

    System.out.println(Math.min(count0, count1));
  }

  private void mySolution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    int one = 0;
    int zero = 0;
    int current = -1;

    for (int i = 0; i < str.length(); i++) {
      int n = str.charAt(i) - '0';
      
      if (current != n) {
        current = n;
        
        if (n == 0) zero ++;
        else one ++;
      } 
    }
    
    System.out.println("xxx 0 : " + zero + ", 1 : " + one);
    System.out.println(Math.min(one, zero));
  }
}