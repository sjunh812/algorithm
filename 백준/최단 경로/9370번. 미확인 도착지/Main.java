import java.util.*;
import java.io.*;

class Main {

  public static int INF = (int) 1e9;  // 무한으로 10억을 설정
  
  int n;
  int m;
  int t;
  int s;
  int g;
  int h;
  ArrayList<ArrayList<Node>> graph;  // 도로 정보를 담은 그래프(리스트)
  ArrayList<Integer> candidate;  // 목적지 후보
  int[] dp = new int[2001];  // 최단 경로 테이블
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());  // 테스트 케이스의 개수

    for (int tc = 0; tc < T; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      t = Integer.parseInt(st.nextToken());
      
      st = new StringTokenizer(br.readLine());
      s = Integer.parseInt(st.nextToken());
      g = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      // 그래프 초기화
      graph = new ArrayList<ArrayList<Node>>();
      for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<Node>());
      }

      // 도로(간선)의 정보 입력받기
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());                
        int d = Integer.parseInt(st.nextToken());
        // 도로는 양방향!
        graph.get(a).add(new Node(b, d));
        graph.get(b).add(new Node(a, d)); 
      }

      // 목적지 후보 입력받기
      candidate = new ArrayList<Integer>();
      for (int i = 0; i < t; i++) {
        candidate.add(Integer.parseInt(br.readLine()));
      }

      // 목적지 후보 오름차순 정렬
      Collections.sort(candidate);

      // 최단 거리 테이블을 모두 무한으로 초기화
      Arrays.fill(dp, INF);

      // 다익스트라 알고리즘 수행
      dijkstra(s);

      // 모든 목적지 후보들에 대하여 BFS 탐색을 수행, 주어진 교차로를 지나는지 판별
      for (int i = 0; i < candidate.size(); i++) {
        if (bfs(candidate.get(i))) bw.write(String.valueOf(candidate.get(i)) + " ");
      }
      bw.write("\n");
    }

    bw.flush();
    bw.close();
  }

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
        int next = graph.get(now).get(i).getIndex();
        int cost = dist + graph.get(now).get(i).getDistance();

        if (cost < dp[next]) {
          pq.offer(new Node(next, cost));
          dp[next] = cost;
        }
      }
    }
  }

  public boolean bfs(int start) {
    int[][] check = new int[2001][2001];
    Queue<Integer> q = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    
    q.offer(start);
    q2.offer(0);
    
    while (!q.isEmpty()) {
      int now = q.poll();
      int dist = q2.poll();

      for (int i = 0; i < graph.get(now).size(); i++) {
        int next = graph.get(now).get(i).getIndex();
        int cost = dist + graph.get(now).get(i).getDistance();

        if (check[next][now] == 0 && check[now][next] == 0 && dp[next] + cost == dp[start]) {
          q.offer(next);
          q2.offer(cost);
          check[next][now] = 1;
          check[now][next] = 1;
          
          if (next == h && now == g || now == h && next == g) return true;
        }
      }
    }

    return false;
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