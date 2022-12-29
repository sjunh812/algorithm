import java.util.*;
import java.io.*;

class Main {

  int k;  // 테스트 케이스의 개수
  int v;  // 정점의 개수
  int e;  // 간선의 개수

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    k = Integer.parseInt(br.readLine());

    for (int i = 0; i < k; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      v = Integer.parseInt(st.nextToken());
      e = Integer.parseInt(st.nextToken());

      // 그래프 그리기
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for (int j = 0; j <= v; j++) {
        graph.add(new ArrayList<Integer>());
      } 
      for (int j = 0; j < e; j++) {
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
      }

      int[] visited = new int[v + 1];  // 방문 노드(방문 처리 : 홀수깊이 : 1, 짝수깊이 : -1)
      // 깊이 우선 탐색(DFS)를 이용해 가능한 모든 방문 처리
      for (int j = 1; j <= v; j++) {
        if (visited[j] == 0) dfs(graph, visited, j, 1);
      }

      if (checkDivision(graph, visited)) System.out.println("YES");
      else System.out.println("NO");
    }
  }

  public void dfs(ArrayList<ArrayList<Integer>> graph, int[] visited, int v, int visit) {
    visited[v] = visit;  

    for (int i = 0; i < graph.get(v).size(); i++) {
      int v2 = graph.get(v).get(i);
      if (visited[v2] == 0) dfs(graph, visited, v2, visit * -1);
    }
  }

  public boolean checkDivision(ArrayList<ArrayList<Integer>> graph, int[] visited) {
    for (int i = 1; i <= v; i++) {
      int visit1 = visited[i];
      
      for (int j = 0; j < graph.get(i).size(); j++) {
        int visit2 = visited[graph.get(i).get(j)];
        if (visit1 == visit2) return false;
      }
    }

    return true;
  }
}