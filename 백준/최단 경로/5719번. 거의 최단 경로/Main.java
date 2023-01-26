import java.util.*;
import java.io.*;

class Main {

  public static final int INF = (int) 1e9;  // 무한을 10억으로 설정
  
  int n;  // 장소의 수
  int m;  // 도로의 수
  int s;  // 시작점
  int d;  // 도착점
  ArrayList<ArrayList<Node>> list;  // 간선의 정보를 담은 최초의 그래프
  ArrayList<ArrayList<Node>> reverseList;  // 역방향 간선의 정보를 담은 최초의 그래프
  int[][] arr = new int[500][500];  // 간선의 정보를 담은 그래프 → 간선 제거에 따른 변경이 이루어짐
  int[] dp = new int[500];  // 최단 거리 테이블
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());  
      m = Integer.parseInt(st.nextToken());  

      if (n == 0 && m == 0) break;  // 테스트 케이스 종료조건
  
      st = new StringTokenizer(br.readLine());
      s = Integer.parseInt(st.nextToken()); 
      d = Integer.parseInt(st.nextToken());  
  
      // 그래프 초기화
      list = new ArrayList<ArrayList<Node>>();
      reverseList = new ArrayList<ArrayList<Node>>();
      for (int i = 0; i < n; i++) {
        list.add(new ArrayList<Node>());
        reverseList.add(new ArrayList<Node>());
      }
  
      // 도로의 정보 입력받기
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        list.get(u).add(new Node(v, p));
        reverseList.get(v).add(new Node(u, p));
        arr[u][v] = p;
      }

      // 다익스트라 알고리즘 수행(1)
      Arrays.fill(dp, INF);
      dijkstra(s);

      // 간선 제거
      bfs(d);
      
      // 다익스트라 알고리즘 수행(2)
      Arrays.fill(dp, INF);
      dijkstra(s);

      // 결과 값 출력
      if (dp[d] == INF) bw.write("-1");
      else bw.write(String.valueOf(dp[d]));
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

      for (int i = 0; i < list.get(now).size(); i++) {
        int next = list.get(now).get(i).getIndex();
        int cost = dist + list.get(now).get(i).getDistance();

        if (arr[now][next] != 0) {
          if (cost < dp[next]) {
            pq.offer(new Node(next, cost));
            dp[next] = cost;
          }
        }
      }
    }
  }

  public void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    q.offer(start);
    q2.offer(0);
    
    while (!q.isEmpty()) {
      int now = q.poll();
      int dist = q2.poll();

      for (int i = 0; i < reverseList.get(now).size(); i++) {
        int next = reverseList.get(now).get(i).getIndex();
        int nextDist = dist + reverseList.get(now).get(i).getDistance();

        if (arr[next][now] != 0 && dp[next] + nextDist == dp[start]) {
          q.offer(next);
          q2.offer(nextDist);
          arr[next][now] = 0;
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