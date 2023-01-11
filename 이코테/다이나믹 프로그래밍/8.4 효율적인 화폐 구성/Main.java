import java.util.*;
import java.io.*;

class Main {

  public int[] dp = new int[10001];
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 정수 N, M을 입력받기
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // N개의 화폐 단위 정보를 입력받기
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    
    // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
    int[] dp = new int[m + 1];
    Arrays.fill(dp, 10001);

    // 다이나믹 프로그래밍(Dynamic Programming) 진행(바텀업)
    dp[0] = 0;
    for (int i = 0; i < n; i++) {
      for (int j = arr[i]; j <= m; j++) {
        // k : 화폐 단위 정보
        // (i - k)원을 만드는 방법이 존재하는 경우
        if (d[j - arr[i]] != 10001) {
          dp[j] = Math.min(d[j], d[j - arr[i]]);
        }
      }
    }

    // 계산된 결과 출력
    if (dp[m] == 10001) System.out.println(-1);  // 최종적으로 M원을 만드는 방법이 없는 경우
    else System.out.println(dp[m]);
  }
}