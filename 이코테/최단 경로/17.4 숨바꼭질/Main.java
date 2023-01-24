import java.util.*;
import java.io.*;

class Main {

  public static final int INF = (int) 1e9;  // 무한을 10억으로 설정
  ArrayList<ArrayList<Node>> graph = new ArrayList<>();  // 그래프를 표현한 리스트
  
  public static void main(String[] args) throws Exception {
    new Main().dijkstraSolution();
    // new Main().bfsSolution();
  }
  
  public void dijkstraSolution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());  // 헛간의 개수
    int m = Integer.parseInt(st.nextToken());  // 통로의 개수

    // 그래프 초기화
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Node>());
    }

    // 통로(간선)의 정보 입력받기
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(new Node(b, 1));
      graph.get(b).add(new Node(a, 1));
    }
    
    int[] dp = new int[20001];  // 최단거리 테이블
    // 최단거리 테이블을 모두 무한으로 초기화
    for (int i = 0; i < 20001; i++) {
      dp[i] = INF;
    }

    // 다익스트라 알고리즘 수행
    PriorityQueue<Node> pq = new PriorityQueue<>();
    // 시작점 초기화(1번 헛간부터 시작하며 비용은 0)
    pq.offer(new Node(1, 0));
    dp[1] = 0;

    while (!pq.isEmpty()) {  
      Node node = pq.poll();
      int index = node.getIndex();
      int dist = node.getDistance();

      // 이미 처리한 노드의 경우 무시
      if (dp[index] < dist) continue;
      
      for (int i = 0; i < graph.get(index).size(); i++) {
        int cost = dist + graph.get(index).get(i).getDistance();
        
        if (cost < dp[graph.get(index).get(i).getIndex()]) {  // 그리디
          pq.offer(new Node(graph.get(index).get(i).getIndex(), cost));
          dp[graph.get(index).get(i).getIndex()] = cost;
        }
      }
    }

    int number = 0;  // 숨어야 하는 헛간번호(여러 개인 경우는 제일 작은 번호)
    int distance = 0;  // 숨어야 하는 헛간의 최단거리
    int count = 0;  // 숨어야 하는 헛간의 개수
    
    for (int i = 1; i <= n; i++) {
      if (dp[i] > distance) {
        count = 1;
        number = i;
        distance = dp[i];
      } else if (dp[i] == distance) {
        count++;
      }
    }
    // 결과 값 출력
    System.out.println(number + " " + distance + " " + count);
  }

  public void bfsSolution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());  // 헛간의 개수
    int m = Integer.parseInt(st.nextToken());  // 통로의 개수

    // 그래프 초기화
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Node>());
    }

    // 통로(간선)의 정보 입력받기
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(new Node(b, 1));
      graph.get(b).add(new Node(a, 1));
    }

    int[] visited = new int[n + 1];  // 방문처리 테이블
    // 방문처리 테이블을 모두 -1로 초기화
    Arrays.fill(visited, -1);  
    
    // BFS 수행
    Queue<Node> q = new LinkedList<>();
    // 시작점 초기화(1번 헛간부터 시작하며 비용은 0)
    q.offer(new Node(1, 0));
    visited[1] = 0;

    while (!q.isEmpty()) {
      Node node = q.poll();
      int index = node.getIndex();
      int dist = node.getDistance();

      for (int i = 0; i < graph.get(index).size(); i++) {
        int next = graph.get(index).get(i).getIndex();
        int cost = dist + graph.get(index).get(i).getDistance();

        if (visited[next] == -1) {  // 방문하지 않은 노드에 대해서만 처리
          q.offer(new Node(next, cost));
          visited[next] = cost;
        }
      }
    }

    int number = 0;  // 숨어야 하는 헛간번호(여러 개인 경우는 제일 작은 번호)
    int distance = 0;  // 숨어야 하는 헛간의 최단거리
    int count = 0;  // 숨어야 하는 헛간의 개수
    
    for (int i = 1; i <= n; i++) {
      if (visited[i] > distance) {
        count = 1;
        number = i;
        distance = visited[i];
      } else if (visited[i] == distance) {
        count++;
      }
    }
    // 결과 값 출력
    System.out.println(number + " " + distance + " " + count);
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