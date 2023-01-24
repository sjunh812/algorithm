import java.util.*;
import java.io.*;

class Main2 {

  public static final int INF = (int) 1e9;  // 무한을 의미하는 값으로 10억을 설정
  
  public static void main(String[] args) throws Exception {
    new Main2().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());  // 학생의 수
    int m = Integer.parseInt(st.nextToken());  // 두 학생의 성적을 비교한 횟수

    int[][] dp = new int[501][501];  // 다이나믹 프로그래밍을 이용한 최단거리 2차원 DP 테이블

    // 최단거리 테이블을 모두 무한으로 초기화
    for (int i = 0; i < 501; i++) {
      Arrays.fill(dp[i], INF);
    }

    // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
    for (int i = 1; i <= n; i++) {
      dp[i][i] = 0;
    }

    // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
    for (int i = 0; i < m; i++) {
      // a에서 b로 가는 비용을 1로 설정
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      dp[a][b] = 1;
    }

    // 점화식에 따라 플로이드 워셜 알고리즘을 수행
    for (int k = 1; k <= n; k++) {
      for (int a = 1; a <= n; a++) {
        for (int b = 1; b <= n; b++) {
          dp[a][b] = Math.min(dp[a][b], dp[a][k] + dp[k][b]);
        }
      }
    }

    int result = 0;  // 결과 값
    
    // 각 학생을 번호에 따라 한 명씩 확인하며 도달 가능한지 체크
    for (int i = 1; i <= n; i++) {
      int count = 0;

      for (int j = 1; j <= n; j++) {
        if (dp[i][j] != INF && dp[j][i] != INF) count++;
      }

      if (count == n) result++;  // 학생의 순위를 상정할 수 있는 경우(나머지 모든 학생과의 비교가 가능함)
    }

    // 결과 값을 출력
    System.out.println(result);
  }
}
