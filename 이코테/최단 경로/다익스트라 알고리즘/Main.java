import java.util.*;
import java.io.*;

class Main {

  int n;  // 노드의 개수
  int m;  // 간선의 개수
  int start;  // 시작점

  ArrayList<ArrayList<Node>> graph = new ArrayList<>();  // 노드의 정보를 담은 배열
  int[] dp = new int[100001];  // 최단거리 테이블
  boolean[] visited = new boolean[100001];  // 방문처리를 위한 배열

  public static final int INF = (int) 1e9;  // 무한을 의미하는 값으로 10억을 설정
  
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

    // 모든 간선 정보를 입력받기
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());  // 간선의 시작점
      int b = Integer.parseInt(st.nextToken());  // 간선의 끝점
      int c = Integer.parseInt(st.nextToken());  // 간선의 비용
      // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
      graph.get(a).add(new Node(b, c));
    }

    // 최단거리 테이블을 모두 무한으로 초기화
    Arrays.fill(dp, INF);

    // 다익스트라 알고리즘 수행
    dijkstra(start);

    // 모든노드로 가기 위한 최단거리 출력
    for (int i = 1; i <= n; i++) {
      // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
      if (dp[i] == INF) System.out.println("INFINITY");
      else System.out.println(dp[i]);
    }
  }

  public void dijkstra(int start) {
    // 시작노드에 대해서 초기화
    dp[start] = 0;
    visited[start] = true;
    for (int i = 0; i < graph.get(start).size(); i++) {
      Node node = graph.get(start).get(i);
      dp[node.getIndex()] = node.getDistance();
    }

    // 시작노드를 제외한 n-1개의 노드에 대해 반복
    for (int i = 0; i < n - 1; i++) {
      // 현재 최단거리가 가장 짧은 노드를 꺼내서, 방문처리
      int now = getSmallestNode();
      visited[now] = true;
    
      // 현재노드와 연결된 다른 노드를 확인
      for (int j = 0; j < graph.get(now).size(); j++) {
        int cost = dp[now] + graph.get(now).get(j).getDistance();
        if (cost < dp[graph.get(now).get(j).getIndex()]) {
          dp[graph.get(now).get(j).getIndex()] = cost;
        }
      }
    }
  }

  // 방문하지 않은 노드 중에서 가장 최단거리가 짧은 노드의 번호를 반환
  public int getSmallestNode() {
    int minValue = INF;
    int index = 0;  // 가장 최단거리가 짧은 노드(인덱스)

    for (int i = 1; i <= n; i++) {
      if (dp[i] < minValue && !visited[i]) {
        minValue = dp[i];
        index = i;
      }
    }

    return index;
  }
}

class Node {

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
}