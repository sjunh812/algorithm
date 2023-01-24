import java.util.*;
import java.io.*;

class Main2 {

  public static final int INF = (int) 1e9;  // 무한을 의미하는 값으로 10억을 설정

  int n;  // 노드의 개수
  int m;  // 간선의 개수
  int start = 1;  // 시작노드를 1번 헛간으로 설정
  ArrayList<ArrayList<Node>> graph = new ArrayList<>();  // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트
  int[] dp = new int[20001];  // 최단거리 테이블
  
  public static void main(String[] args) throws Exception {
    new Main2().solution();
  }

  public void solution() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    // 그래프 초기화
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Node>());
    }

    // 모든 간선 정보르 입력받기
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      // a번 노드와 b번 노드의 이동 비용이 1이라는 의미(+양방향)
      graph.get(a).add(new Node(b, 1));
      graph.get(b).add(new Node(a, 1));
    }

    // 최단거리 테이블을 모두 무한으로 초기화
    Arrays.fill(dp, INF);

    // 다익스트라 알고리즘 수행
    dijkstra(start);

    int maxNode = 0;  // 가장 최단거리가 먼 노드 번호(숨을 헛간의 번호)
    int maxDistance = 0;  // 도달할 수 있는 노드 중에서, 가장 최단거리가 먼 노드와의 최단거리
    ArrayList<Integer> result = new ArrayList<>();  // 가장 최단 거리가 먼 노드와의 최단 거리와 동일한 최단 거리를 가지는 노드들의 리스트

    for (int i = 1; i <= n; i++) {
      if (maxDistance < dp[i]) {
        maxNode = i;
        maxDistance = dp[i];
        result.clear();
        result.add(i);
      } else if (maxDistance == dp[i]) {
        result.add(i);
      }
    }

    System.out.println(maxNode + " " + maxDistance + " " + result.size());
  }

  public void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    // 시작노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
    pq.offer(new Node(start, 0));
    dp[start] = 0;

    while (!pq.isEmpty()) {
      // 가장 최단거리가 짧은 노드에 대한 정보 꺼내기
      Node node = pq.poll();
      int dist = node.getDistance();  // 현재노드까지의 비용
      int now = node.getIndex();  // 현재노드

      // 현재노드가 이미 처리한 적이 있는 노드라면 무시
      if (dp[now] < dist) continue;

      // 현재노드와 연결된 다른 인접한 노드들을 확인
      for (int i = 0; i < graph.get(now).size(); i++) {
        int cost = dist + graph.get(now).get(i).getDistance();
        // 현재노드를 거쳐서, 다른노드로 이동하는 거리가 더 짧은 경우
        if (cost < dp[graph.get(now).get(i).getIndex()]) {
          pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
          dp[graph.get(now).get(i).getIndex()] = cost;
        }
      }
    }
  }
}

class Node implements Comparable<Node> {

  private int index;
  private int distance;

  public Node(int index, int distance) {
    this.index = index;
    this.distance = distance;
  }

  public int getIndex() {
    return this.index;
  }

  public int getDistance() {
    return this.distance;
  }

  // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
  @Override
  public int compareTo(Node other) {
    return this.distance - other.distance;
  }
}
