import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    ArrayList<Integer> list = new ArrayList<>();
    int[] dp = new int[n];
    for (int i = 0; i < n; i++) {
      list.add(Integer.parseInt(st.nextToken()));
      dp[i] = 1;  // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
      
    }

    // 순서를 뒤집어 '최장 증가하는 부분 수열' 문제로 변환
    Collections.reverse(list);

    // 가장 긴 증가하는 부분 수열(LIS) 알고리즘 수행
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (list.get(i) > list.get(j)) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    // 열외해야 하는 병사의 최소 수 출력
    int max = 0;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, dp[i]);
    }
    System.out.println(n - max);
  }
}