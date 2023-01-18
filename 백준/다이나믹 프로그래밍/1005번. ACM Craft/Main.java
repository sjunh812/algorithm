import java.util.*;
import java.io.*;

class Main {

  int t;  // 테스트 케이스 개수
  int n;  // 건물의 개수
  int k;  // 건물간의 건설순서 규칙의 개수(간선의 개수)
  int w;  // 승리를 위해 건설해야 할 건물의 번호
  int[] delay;   // 건물당 건설에 걸리는 시간
  int[] dp;  // 다이나믹 프로그래밍을 위한 DP 테이블
  
  ArrayList<ArrayList<Integer>> graph = new ArrayList<>();  // 건물별 건설 순서를 담은 그래프

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    t = Integer.parseInt(br.readLine()); 

    for (int tc = 0; tc < t; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      n = Integer.parseInt(st.nextToken()); 
      k = Integer.parseInt(st.nextToken());  

      delay = new int[n + 1];  
      graph = new ArrayList<>();  
      
      // 건물당 건설에 걸리는 시간 입력받기
      st = new StringTokenizer(br.readLine());
      graph.add(new ArrayList<Integer>());
      for (int i = 1; i <= n; i++) {
        delay[i] = Integer.parseInt(st.nextToken());
        graph.add(new ArrayList<Integer>());
      }

      // 건물별 건설순서 규칙 입력받기
      for (int i = 0; i < k; i++) {
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        graph.get(v2).add(v1);  // 역순으로 DFS를 수행하기 위해 시작점과 끝점을 바꿈.
      }
 
      w = Integer.parseInt(br.readLine());
      dp = new int[n + 1];

      // DFS(깊이 우선 탐색) 수행
      dfs(new int[n + 1], w);

      System.out.println(dp[w]);
    }
  }

  public void dfs(int[] visited, int start) {
    if (visited[start] == 1) return;
    visited[start] = 1;

    int max = 0;  // 현재 깊이에서의 DP 최댓값(건물의 건설 시간)
    
    for (int i = 0; i < graph.get(start).size(); i++) {
      int v = graph.get(start).get(i);
      if (visited[v] == 0) dfs(visited, v);
      max = Math.max(max, dp[v]);
    }

    dp[start] = max + delay[start];  // 현재 깊이의 최댓값을 이전 순서 건물의 DP 값으로 갱신
  }
}