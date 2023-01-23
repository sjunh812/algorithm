import java.util.*;
import java.io.*;

class Main2 {

  public static final int INF = (int) 1e9;  // 무한을 의미하는 값으로 10억을 설정

  int n;  // 노드의 개수
  int m;  // 간선의 개수
  int start;  // 시작노드 번호

  ArrayList<ArrayList<Node>> graph = new ArrayList<>();  // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배
  int[] dp = new int[30001];  // 최단거리 테이블
  
  public static void main(String[] args) throws Exception {
    new Main2().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    start = Integer.parseInt(st.nextToken());

    // 그래프 초기화
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Node>());
    }

    // 모든 간선 정보를 입력받기
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int z = Integer.parseInt(st.nextToken());
      // x번 노드에서 y번 노드로 가는 비용이 z라는 의미
      graph.get(x).add(new Node(y, z));
    }

    // 최단거리 테이블을 모두 무한으로 초기화
    Arrays.fill(dp, INF);

    // 다익스트라 알고리즘 수행
    dijkstra(start);

    int count = 0;  // 도달할 수 있는 노드의 개수
    int maxDistance = 0;  // 도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단거리
    for (int i = 1; i <= n; i++) {
      if (dp[i] != INF) {
        count++;
        maxDistance = Math.max(maxDistance, dp[i]);
      }
    }

    // 시작노드를 제외해야 하므로 count - 1을 출력
    System.out.println((count - 1) + " " + maxDistance);
  }

  public void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    // 시작노드로 가기 위한 최단경로는 0으로 설정하여 큐에 삽입
    pq.offer(new Node(start, 0));
    dp[start] = 0;

    while (!pq.isEmpty()) {
      // 가장 최단거리가 짧은 노드에 대한 정보 꺼내기
      Node node = pq.poll();
      int now = node.getIndex();  // 현재노드
      int dist = node.getDistance();  // 현재 노드까지의 최단거리(비용)

      // 현재노드가 이미 처리된 적이 있는 노드라면 무시
      if (dp[now] < dist) continue;

      // 현재노드와 연결된 다른 인접한 노드들을 확인
      for (int i = 0; i < graph.get(now).size(); i++) {
        int cost = dp[now] + graph.get(now).get(i).getDistance();

        // 현재노드를 거쳐서 다른노드로 이동하는 거리가 더 짧은 경우
        if (cost < dp[graph.get(now).get(i).getIndex()]) {
          pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
          dp[graph.get(now).get(i).getIndex()] = cost;
        }
      }
    }
  }
}