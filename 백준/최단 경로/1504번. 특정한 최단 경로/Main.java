import java.util.*;
import java.io.*;

class Main {

  public static final int INF = (int) 1e9;  // 무한을 나타내는 값으로 10억을 설정
  ArrayList<ArrayList<Node>> graph = new ArrayList<>();  // 간선의 정보를 나타내는 그래프(리스트)
  int[] dp = new int[801];  // 최단 거리 테이블
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());  // 정점의 개수
    int e = Integer.parseInt(st.nextToken());  // 간선의 개수

    // 그래프 초기화
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Node>());
    }

    // 간선의 정보를 입력받기
    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      // 비용이 c인 양방향 간선
      graph.get(a).add(new Node(b, c));
      graph.get(b).add(new Node(a, c));
    }

    // 반드시 거쳐야하는 두 점 입력받기
    st = new StringTokenizer(br.readLine());
    int v1 = Integer.parseInt(st.nextToken());
    int v2 = Integer.parseInt(st.nextToken());

    long result1 = 0;  // (1 → v1 → v2 → n)을 거치는 최단 경로
    long result2 = 0;  // (1 → v2 → v1 → n)을 거치는 최단 경로

    Arrays.fill(dp, INF);
    dijkstra(1);
    result1 += dp[v1];
    result2 += dp[v2];

    dp = new int[801];  
    Arrays.fill(dp, INF);
    dijkstra(v1);
    result1 += dp[v2];
    result2 += dp[n];

    dp = new int[801];  
    Arrays.fill(dp, INF);
    dijkstra(v2);
    result1 += dp[n];
    result2 += dp[v1];

    int result = Math.min(result1, result2);
    if (result >= INF) System.out.println(-1);
    else System.out.println(result);
  }

  // 다익스트라 알고리즘
  public void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0));
    dp[start] = 0;

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int now = node.getIndex();
      int dist = node.getDistance();

      if (dp[now] < dist) continue;

      for (int i = 0; i < graph.get(now).size(); i++) {
        int cost = dist + graph.get(now).get(i).getDistance();

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

  // 거리(비용)이 낮은 것부터
  @Override
  public int compareTo(Node other) {
    return this.distance - other.distance;
  }
}