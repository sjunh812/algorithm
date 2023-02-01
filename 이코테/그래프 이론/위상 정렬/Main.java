import java.util.*;
import java.io.*;

class Main {

  int v;  // 노드의 개수
  int e;  // 간선의 개수
  int[] indegree = new int[100001];  // 진입차수
  ArrayList<ArrayList<Integer>> graph = new ArrayList<>();  // 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    v = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());

    // 그래프 초기화
    for (int i = 0; i <= v; i++) {
      graph.add(new ArrayList<Integer>());
    }

    // 방향 그래프의 모든 간선의 정보를 입력 받기
    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
      indegree[b]++;  // 진입 차수를 1 증가
    }

    topologySort();
  }

  // 위상 정렬
  public void topologySort() {
    ArrayList<Integer> result = new ArrayList<>();  // 알고리즘 수행 결과를 담을 리스트
    Queue<Integer> q = new LinkedList<>();

    // 처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
    for (int i = 1; i <= v; i++) {
      if (indegree[i] == 0) q.offer(i);
    }

    // 큐가 빌때까지 반복
    while (!q.isEmpty()) {
      int now = q.poll();
      result.add(now);

      // 해당 원소와 연결된 노드들의 진입 차수를 1 감소(간선 제거)
      for (int i = 0; i < graph.get(now).size(); i++) {
        indegree[graph.get(now).get(i)]--;
        // 새롭게 진입 차수가 0이 되는 노드를 큐에 삽입
        if (indegree[graph.get(now).get(i)] == 0) q.offer(graph.get(now).get(i));
      }
    }

    // 위상 정렬을 수행한 결과 출력
    for (int i = 0; i < result.size(); i++) {
      System.out.print(result.get(i) + " ");
    }
    System.out.println();
  }
}