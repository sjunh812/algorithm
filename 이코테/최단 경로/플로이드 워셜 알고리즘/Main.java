import java.util.*;
import java.io.*;

class Main {

  public static final int INF = (int) 1e9;  // 무한을 의미하는 값으로 10억을 설정
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());  // 노드의 개수
    int m = Integer.parseInt(st.nextToken());  // 간선의 개수

    int[][] dp = new int[501][501];  // 최단거리 2차원 DP 테이블
    // 최단거리 테이블을 모두 무한으로 초기화
    for (int a = 0; a <= n; a++) {
      Arrays.fill(dp[a], INF);
      dp[a][a] = 0;  // 자기 자신에서 자기 자신으로 가는 비용은 모두 0으로 초기화
    }

    // 각 간선의 대한 정보를 입력 받아, 그 값으로 초기화
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      dp[a][b] = c;  // a에서 b로 가는 비용은 c라고 설정
    }

    // 점화식에 따라 플로이드 워셜 알고리즘 수행
    for (int k = 1; k <= n; k++) {
      for (int a = 1; a <= n; a++) {
        for (int b = 1; b <= n; b++) {
          dp[a][b] = Math.min(dp[a][b], dp[a][k] + dp[k][b]);
        }
      }
    }

    // 수행된 결과를 출력
    for (int a = 1; a <= n; a++) {
      for (int b = 1; b <= n; b++) {
        if (dp[a][b] == INF) System.out.print("INFINITY ");
        else System.out.print(dp[a][b] + " ");
      }
      System.out.println();
    }
  }
}