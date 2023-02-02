import java.util.*;
import java.io.*;

class Main {

  int v;  // 강의(노드)의 개수
  int[] indegree = new int[501];  // 모든 강의(노드)에 대한 진입차수
  ArrayList<ArrayList<Integer>> graph = new ArrayList<>();  // 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트
  int[] times = new int[501];  // 각 강의의 시간

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    v = Integer.parseInt(br.readLine());

    // 그래프 초기화
    for (int i = 0; i <= v; i++) {
      graph.add(new ArrayList<Integer>());
    }

    // 방향 그래프의 모든 간선 정보를 입력받기
    for (int i = 1; i <= v; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      // 첫 번째 수는 강의의 시간을 담고있음!
      int time = Integer.parseInt(st.nextToken());
      times[i] = time;

      // 해당 강의를 듣기 위해 들어야하는 선수 강의들의 번호 입력
      while (true) {
        int number = Integer.parseInt(st.nextToken());
        if (number == -1) break;
        indegree[i]++;
        graph.get(number).add(i);
      }
    }

    topologySort();
  }

  // 위상 정렬
  public void topologySort() {
    int[] result = new int[501];
    for (int i = 1; i <= v; i++) {
      result[i] = times[i];
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= v; i++) {
      if (indegree[i] == 0) q.offer(i);
    }

    while (!q.isEmpty()) {
      int now = q.poll();

      // 해당 원소와 연결된 노드들의 진입차수에서 1빼기
      for (int i = 0; i < graph.get(now).size(); i++) {
        int next = graph.get(now).get(i);
        indegree[next]--;
        result[next] = Math.max(result[next], result[now] + times[next]);

        if (indegree[next] == 0) q.offer(next);
      }
    }

    // 위상 정렬을 수행한 결과 출력
    for (int i = 1; i <= v; i++) {
      System.out.println(result[i]);
    }
  }
}