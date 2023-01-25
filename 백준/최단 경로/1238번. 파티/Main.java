import java.util.*;
import java.io.*;

class Main {

  public static final int INF = (int) 1e9;  // 무한으로 10억을 설정

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); 
    int m = Integer.parseInt(st.nextToken());  
    int x = Integer.parseInt(st.nextToken()); 

    ArrayList<ArrayList<Node>> graph = new ArrayList<>();  // 정방향 간선 그래프
    ArrayList<ArrayList<Node>> reverseGraph = new ArrayList<>();  // 역방향 간선 그래프
    
    // 그래프 초기화
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Node>());
      reverseGraph.add(new ArrayList<Node>());
    }

    // 간선의 정보 입력받기
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      graph.get(a).add(new Node(b, c));
      reverseGraph.get(b).add(new Node(a, c));  // 간선의 방향 뒤집기
    }

    // 모든 학생의 마을을 시작점으로 X 마을까지의 최단 경로
    // 즉, X 마을을 시작점으로 하는 역방향 간선 그래프를 이용한 다익스트라 알고리즘을 수행!
    int[] reverseDp = new int[1001];  
    Arrays.fill(reverseDp, INF);  // 무한으로 최단 거리 테이블 초기화
    dijkstra(reverseGraph, reverseDp, x);

    // X 마을을 시작점으로 다익스트라 알고리즘 수행(마을로 다시 돌아오는 경우)
    int[] dp = new int[1001]; 
    Arrays.fill(dp, INF);  // 무한으로 최단 거리 테이블 초기화
    dijkstra(graph, dp, x);

    int max = 0;
    for (int i = 1; i <= n; i++) {
      max = Math.max(max, dp[i] + reverseDp[i]);
    }
    System.out.println(max);
  }

  // 다익스트라 알고리즘
  public void dijkstra(ArrayList<ArrayList<Node>> graph, int[] dp, int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0));
    dp[start] = 0;

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int now = node.getIndex();
      int dist = node.getDistance();

      if (dp[now] < dist) continue;

      for (int i = 0 ; i < graph.get(now).size(); i++) {
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

  @Override
  public int compareTo(Node other) {
    return this.distance - other.distance;
  }
}