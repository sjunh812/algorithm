import java.util.*;
import java.io.*;

class Main {

  public static final int INF = (int) 1e9;  // 무한을 10억으로 설정

  int n;  // 공항의 수
  int m;  // 총 지원비용
  int k;  // 티켓정보의 수
  ArrayList<ArrayList<Node>> graph;  // 간선의 정보를 담은 그래프
  int[][] dp = new int[101][10001];  // 최단 시간 그래프

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());  // 테스트 케이스의 개수

    for (int tc = 0; tc < t; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      n = Integer.parseInt(st.nextToken());  
      m = Integer.parseInt(st.nextToken()); 
      k = Integer.parseInt(st.nextToken()); 

      // 그래프 초기화
      graph = new ArrayList<ArrayList<Node>>();
      for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<Node>());
      }

      // 티켓정보 입력받기
      for (int i = 0; i < k; i++) {
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());  // 출발공항
        int v = Integer.parseInt(st.nextToken());  // 도착공항
        int c = Integer.parseInt(st.nextToken());  // 비용
        int d = Integer.parseInt(st.nextToken());  // 소요시간
        graph.get(u).add(new Node(v, c, d));
      }

      // 최단 시간 테이블을 무한으로 초기화
      for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= m; j++) {  
          dp[i][j] = INF;
        }
      }

      // 다익스트라 알고리즘 수행
      dijkstra(1);

      // 결과 값 출력
      int answer = INF;
      for (int i = 0; i <= m; i++) {
        answer = Math.min(answer, dp[n][i]);
      }
      if (answer == INF) bw.write("Poor KCM");
      else bw.write(String.valueOf(answer));
      bw.write("\n");
    }

    bw.flush();
    bw.close();
  }

  public void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0, 0));
    dp[start][0] = 0;

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int now = node.getIndex();
      int cost = node.getCost();
      int time = node.getTime();

      if (dp[now][cost] < time) continue;

      for (int i = 0; i < graph.get(now).size(); i++) {
        Node nNode = graph.get(now).get(i);
        int next = nNode.getIndex();
        int nCost = cost + nNode.getCost();
        int nTime = time + nNode.getTime();

        if (nCost <= m && nTime < dp[next][nCost]) {
          pq.offer(new Node(next, nCost, nTime));
          dp[next][nCost] = nTime;
        }
      }
    }
  }
}

class Node implements Comparable<Node> {

  private int index;
  private int cost;
  private int time;

  public Node(int index, int cost, int time) {
    this.index = index;
    this.cost = cost;
    this.time = time;
  }

  public int getIndex() {
    return this.index;
  }

  public int getCost() {
    return this.cost;
  }
  
  public int getTime() {
    return this.time;
  }

  @Override
  public int compareTo(Node other) {
    return this.time - other.time;
  }
}