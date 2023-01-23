import java.util.*;
import java.io.*;

class Main {

  public static final int INF = (int) 1e9;
  
  int n;  // 도시의 개수
  int m;  // 통로의 개수
  int c;  // 시작 도시

  ArrayList<ArrayList<Node>> graph = new ArrayList<>();  // 도시의 통로 정보를 표현한 그래프
  int[] dp = new int[30001];  // 최단거리 테이블
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    // 그래프 초기화
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Node>());
    }

    // 간선의 정보 입력받기
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());  // 시작 도시
      int b = Integer.parseInt(st.nextToken());  // 끝 도시
      int c = Integer.parseInt(st.nextToken());  // 비용

      graph.get(a).add(new Node(b, c));
    }

    // 최단거리 테이블 모든 값을 무한으로 초기화
    Arrays.fill(dp, INF);

    // 다익스트라 알고리즘 수행
    dijkstra(c);

    // 결과 값을 출력
    int count = 0;
    int max = 0;
    for (int i = 1; i <= n; i++) {
      if (dp[i] != INF) {
        count++;
        max = Math.max(max, dp[i]);
      }
    }
    System.out.println((count - 1) + " " + max);
  }

  public void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();

    // 시작점 초기화
    pq.offer(new Node(start, 0));
    dp[start] = 0;

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int now = node.getIndex();
      int dist = node.getDistance();

      if (dp[now] < dist) continue;

      for (int i = 0; i < graph.get(now).size(); i++) {
        int cost = dp[now] + graph.get(now).get(i).getDistance();

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

  // 최단거리(비용)가 짧은 순
  @Override
  public int compareTo(Node other) {
    return this.distance - other.distance;
  }
}