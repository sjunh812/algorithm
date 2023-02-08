import java.util.*;
import java.io.*;

class Main {

  static final long INF = Long.MAX_VALUE;
  
  int n;
  int m;
  ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  long[] dp = new long[501];

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
  
    for(int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Node>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      graph.get(a).add(new Node(b, c));
    }

    Arrays.fill(dp, INF);

    bellmanFord(1);

    if (findNegativeCycle()) {
      bw.write("-1\n");
    } else {
      for (int i = 2; i <= n; i++) {
        if (dp[i] == INF) bw.write("-1\n");
        else bw.write(dp[i] + "\n");
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }

  public void bellmanFord(int start) {
    dp[start] = 0;
    
    for (int i = 0; i < n; i++) {
      for (int now = 1; now <= n; now++) {
        for (Node node : graph.get(now)) {
          int next = node.getIndex();
          long cost = dp[now] + node.getDistance();
          
          if (dp[now] != INF && dp[next] > cost) dp[next] = cost;
        }
      }
    }
  }

  public boolean findNegativeCycle() {
    for (int now = 1; now <= n; now++) {
      for (Node node : graph.get(now)) {
        int next = node.getIndex();
        long cost = dp[now] + node.getDistance();

        if (dp[now] != INF && dp[next] > cost) return true;
      }
    }

    return false;
  }
}

class Node {

  private int index;
  private long distance;

  public Node(int index, long distance) {
    this.index = index;
    this.distance = distance;
  }

  public int getIndex() {
    return this.index;
  }

  public long getDistance() {
    return this.distance;
  }
}