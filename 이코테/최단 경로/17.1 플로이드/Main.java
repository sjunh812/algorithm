import java.util.*;
import java.io.*;

class Main {

  public static final int INF = (int) 1e9;
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());  // 도시의 개수
    int m = Integer.parseInt(br.readLine());  // 버스의 개수

    int[][] dp = new int[101][101];  // 최단거리를 나타내는 2차원 DP 테이블
    for (int i = 1; i <= n; i++) {  // DP 테이블 초기화(무한)
      Arrays.fill(dp[i], INF);
    }
    
    // 모든 간선의 정보 입력받기
    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());  // 시작 도시
      int b = Integer.parseInt(st.nextToken());  // 도착 도시
      int c = Integer.parseInt(st.nextToken());  // 비용

      dp[a][b] = Math.min(dp[a][b], c);
    }

    // 다이나믹 프로그래밍을 이용해 플로이드 워셜 알고리즘 수행
    for (int k = 1; k <= n; k++) {
      for (int a = 1; a <= n; a++) {
        for (int b = 1; b <= n; b++) {
          if (a != b) dp[a][b] = Math.min(dp[a][b], dp[a][k] + dp[k][b]);
        }
      }
    }

    // 결과 출력
    for (int a = 1; a <= n; a++) {
      for (int b = 1; b <= n; b++) {
        if (dp[a][b] == INF) System.out.print(0 + " ");
        else System.out.print(dp[a][b] + " ");
      }
      System.out.println();
    }
  }
}