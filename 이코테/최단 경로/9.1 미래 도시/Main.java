import java.util.*;
import java.io.*;

class Main {

  int n;  
  int m;
  int x;
  int k;

  ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  int[] dp = new int[101];
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Node>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(new Node(b, 1));
      graph.get(b).add(new Node(a, 1));
    }

    st = new StringTokenizer(br.readLine());

    x = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    Arrays.fill(dp, Integer.MAX_VALUE);
    dijkstra(1);
    int first = dp[k];

    Arrays.fill(dp, Integer.MAX_VALUE);
    dijkstra(k);
    int second = dp[x];

    if (first == Integer.MAX_VALUE || second == Integer.MAX_VALUE) System.out.println(-1);
    else System.out.println(first + second);
  }

  public void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();

    pq.offer(new Node(start, 0));
    dp[start] = 0;

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int index = node.getIndex();
      int distance = node.getDistance();

      if (dp[index] < distance) continue;
      
      for (int i = 0; i < graph.get(index).size(); i++) {
        int cost = dp[index] + graph.get(index).get(i).getDistance();
        
        if (cost < dp[graph.get(index).get(i).getIndex()]) {
          pq.offer(new Node(graph.get(index).get(i).getIndex(), cost));
          dp[graph.get(index).get(i).getIndex()] = cost;
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