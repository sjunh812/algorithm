import java.util.*;
import java.io.*;

class Main {

  public static final int INF = (int) 1e9;  // 무한을 의미하는 값으로 10억을 설정
  
  int n;  // 노드의 개수
  int m;  // 간선의 개수
  int start;  // 시작점

  ArrayList<ArrayList<Node>> graph = new ArrayList<>();  // 간선의 정보를 담은 그래프
  int[] dp = new int[100001];  // 최단거리 배열
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    start = Integer.parseInt(br.readLine());

    // 그래프 초기화
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Node>());
    }

    // 모든 간선의 정보 입력받기
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());  // 시작점
      int b = Integer.parseInt(st.nextToken());  // 끝점
      int c = Integer.parseInt(st.nextToken());  // 비용
      // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
      graph.get(a).add(new Node(b, c));
    }

    // 최단거리 테이블을 모두 무한으로 초기화
    Arrays.fill(dp, INF);

    // 다익스트라 알고리즘 수행
    dijkstra(start);

    // 모든노드로 가기 위한 최단거리 출력
    for (int i = 1; i <= n; i++) {
      if (dp[i] == INF) System.out.println("INFINITY");
      else System.out.println(dp[i]);
    }
  }

  public void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();  
    
    // 시작노드로 가기 위한 최단거리는 0으로 설정하여 큐에 삽입
    pq.offer(new Node(start, 0));
    dp[start] = 0;

    while (!pq.isEmpty()) {
      // 가장 최단거리가 짧은 노드에 대한 정보 꺼내기
      Node node = pq.poll();
      int now = node.getIndex();  // 현재 노드
      int dist = node.getDistance();  // 현재 노드까지의 비용

      // 현재노드가 이미 처리된 적이 있는 노드라면 무시
      if (dp[now] < dist) continue;
      // 현재노드와 연결된 다른 인접한 노드들을 확인
      for (int i = 0; i < graph.get(now).size(); i++) {
        int cost = dp[now] + graph.get(now).get(i).getDistance();

        // 현재노드를 거쳐서 다른노드로 이동하는 거리가 더 짧은 경우
        if (cost < dp[graph.get(now).get(i).getIndex()]) {
          dp[graph.get(now).get(i).getIndex()] = cost;
          pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
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