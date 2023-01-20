import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());  // 수열의 크기
    int[] arr = new int[n];  // 수열

    // 수열 입력받기
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[][] dp = new int[n + 1][n + 1];  // 다이나믹 프로그래밍을 위한 2차원 DP 테이블
    
    // DP 테이블 초기화
    for (int i = 1; i <= n; i++) {
      dp[i][i] = 1;
      if (i + 1 <= n && arr[i - 1] == arr[i]) dp[i][i + 1] = 1;
      if (i + 2 <= n && arr[i - 1] == arr[i + 1]) dp[i][i + 2] = 1;
    }

    // 다이나믹 프로그래밍 수행
    for (int k = 3; k <= n - 1; k++) {
      for (int i = 1; i <= n - k; i++) {
        if (dp[i + 1][i + k - 1] == 1 && arr[i - 1] == arr[i + k - 1]) dp[i][i + k] = 1;
      }
    }
    
    int m = Integer.parseInt(br.readLine());  // 질문의 개수

    // 질문 입력받기
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      bw.write(String.valueOf(Math.max(dp[s][e], dp[e][s])));
      bw.write("\n");
    }

    bw.flush();
    bw.close();
  }
}