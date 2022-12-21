import java.util.*;
import java.io.*;

class Main {

  int n;  // 도시의 개수
  int m;  // 도로의 개수
  int k;  // 거리 정보
  int x;  // 출발 도시의 번호
  ArrayList<ArrayList<Integer>> graph = new ArrayList<>();  // 그래프
  ArrayList<Integer> result = new ArrayList<>();  // 결과 리스트
  int[] visited;  // 방문 노드
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    visited = new int[n + 1];
    
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      ArrayList<Integer> node = new ArrayList<>();
      node.add(Integer.parseInt(st.nextToken()));
      node.add(Integer.parseInt(st.nextToken()));
      graph.add(node);
    }

    dfs(x, 0);
    
    Collections.sort(result);
    
    if (result.isEmpty()) {
      System.out.println("-1");
    } else {
      for (int i = 0; i < result.size(); i++) {
        if (visited[result.get(i)] == k) System.out.println(result.get(i));
      }
    }
  }

  private void dfs(int x, int depth) { 
    System.out.println(x + " : " + depth);
    visited[x] = depth;
    
    if (depth == k) {
      result.add(x);
      return;
    } 

    for (int i = 0; i < m; i++) {
      int start = graph.get(i).get(0);
      int end = graph.get(i).get(1);

      if (start == x && (visited[end] == 0 || visited[end] > depth + 1)) {
        dfs(end, depth + 1);
      }
    }
  }
}