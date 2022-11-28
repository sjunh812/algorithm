import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st1 = new StringTokenizer(br.readLine());

    // N, M을 공백을 기준으로 구분하여 입력 받기
    int n = Integer.parseInt(st1.nextToken());
    int m = Integer.parseInt(st1.nextToken());
    int result = 0;

    // 한 줄씩 입력 받아 확인하기
    for(int i = 0; i < n; i++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      int minValue = 10001;  // 현재 줄에서 '가장 작은 수' 찾기
      
      for (int j = 0; j < m; j++) {
        int x = Integer.parseInt(st2.nextToken());

        minValue = Math.min(minValue, x);
      }

      // '가장 작은 수'들 중에서 가장 큰 수 찾기
      result = Math.max(result, minValue);
    }

    System.out.println(result);  // 최종 답안 출력
  }

  public void mySolution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st1.nextToken());
    int m = Integer.parseInt(st1.nextToken());
    int result = 0;

    for(int i = 0; i < n; i++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      int minCol = -1;
      
      for (int j = 0; j < m; j++) {
        int card = Integer.parseInt(st2.nextToken());
        
        if (minCol == -1 || minCol >= card) {
          minCol = card;  
        }

        System.out.println("xxx min column : " + minCol);
      }

      if (minCol >= result) {
        result = minCol;
      }
    }

    System.out.println("xxx result : " + result);
  }
}