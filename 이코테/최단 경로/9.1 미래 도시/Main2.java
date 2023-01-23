import java.util.*;
import java.io.*;

class Main2 {

  public static final int INF = (int) 1e9;  // 무한을 의미하는 값으로 10억을 설정

  int n;  // 노드의 개수
  int m;  // 간선의 개수
  int x;  // 최종 목적지 노드
  int k;  // 거쳐 갈 노드

  int[][] dp = new int[101][101];  // 최단거리 2차원 DP 테이블
  
  public static void main(String[] args) throws Exception {
    new Main2().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    // 최단거리 테이블을 무한으로 초기화
    for (int i = 1; i <= n; i++) {
      Arrays.fill(dp[i], INF);
    }

    // 자기자신에서 자기자신으로 가는 비용은 0으로 초기화
    for (int i = 1; i <= n; i++) {
      dp[i][i] = 0;
    }

    // 각 간선에 대한 정보를 입력받아, 그 값으로 초기화
    for (int i = 0; i < m; i++) {
      // a와 b가 서로에게(양방향) 가는 비용은 1이라고 설정
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      dp[a][b] = 1;
      dp[b][a] = 1;
    }

    st = new StringTokenizer(br.readLine());
    x = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    // 점화식에 따라 폴로이드 웨셜 알고리즘 수행
    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
        }
      }
    }

    // 수행된 결과를 출력
    int distance = dp[1][k] + dp[k][x];
    if (distance >= INF) System.out.println(-1);
    else System.out.println(distance);
  }
}