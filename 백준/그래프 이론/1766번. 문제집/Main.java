import java.util.*;
import java.io.*;

class Main {
  
  int n, m;
  ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  int[] indegree = new int[32001];
  ArrayList<Integer> result = new ArrayList<>();
  
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

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
      indegree[b]++;
    }

    topologySort();

    for (int i : result) {
      bw.write(i + " ");
    }

    bw.flush();
    bw.close();
    br.close();
  }

  public void topologySort() {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 1; i <= n; i++) {
      if (indegree[i] == 0) pq.offer(i);
    }

    while (!pq.isEmpty()) {
      int now = pq.poll();
      result.add(now);

      for (int next : graph.get(now)) {
        indegree[next]--;
        if (indegree[next] == 0) pq.offer(next);
      }
    }
  }
}