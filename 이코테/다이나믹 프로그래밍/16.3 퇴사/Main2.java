import java.util.*;
import java.io.*;

class Main2 {
  
  public static void main(String[] args) throws Exception {
    new Main2().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());  // 전체 상담 개수
    int[] t = new int[15];  // 각 상담을 완료하는데 걸리는 시간
    int[] p = new int[15];  // 각 상담을 완료했 때 받을 수 있는 금액
    int[] dp = new int[16];  // 다이나믹 프로그래을 위한 1차원 DP 테이블
    
    for (int i = 0; i < n; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      t[i] = Integer.parseInt(st.nextToken());
      p[i] = Integer.parseInt(st.nextToken());
    }

    int maxValue = 0;

    // 배열 뒤에서부터 거꾸로 확인
    for (int i = n - 1; i >= 0; i--) {
      int time = t[i] + i;
      
      // 상담이 기간 안에 끝나는 경우
      if (time <= n) {
        // 점화식에 맞게, 현재까지의 최고 이익 계산
        dp[i] = Math.max(p[i] + dp[time], maxValue);
        maxValue = dp[i];
      } 
      // 상담 기간을 벗어나는 경  
      else {
        dp[i] = maxValue;
      }
    } 

    System.out.println(maxValue);
  }
}