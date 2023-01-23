import java.util.*;
import java.io.*;

class Main2 {

  public static final int INF = (int) 1e9;  // 무한을 의미하는 값으로 10억을 설정

  int n;  // 도시의 개수
  int m;  // 버스의 개수

  int[][] dp = new int[101][101];  // 2차원 배열(그래프 표현)를 만들기
  
  public static void main(String[] args) throws Exception {
    new Main2().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());  // 도시의 개수
    m = Integer.parseInt(br.readLine());  // 버스의 개수

    // 최단 거리 테이블을 모두 무한으로 초기화
    for (int i = 0; i < 101; i++) { 
      Arrays.fill(dp[i], INF);
    }

    // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
    for (int a = 1; a <= n; a++) {
      dp[a][a] = 0;
    }
    
    // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      // A에서 B로 가는 비용은 C라고 설정
      int a = Integer.parseInt(st.nextToken());  
      int b = Integer.parseInt(st.nextToken());  
      int c = Integer.parseInt(st.nextToken());  
      // 가장 짧은 간선 정보만 저장
      if (c < dp[a][b]) dp[a][b] = c;
    }

    // 점화식에 따라 플로이드 워셜 알고리즘을 수행
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
        if (dp[a][b] == INF) System.out.print(0 + " ");
        else System.out.print(dp[a][b] + " ");
      }
      System.out.println();
    }
  }
}