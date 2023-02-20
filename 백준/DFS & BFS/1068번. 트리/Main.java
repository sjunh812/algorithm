import java.util.*;
import java.io.*;

class Main {

  int n;
  int[] tree;
  int d;
  ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  boolean[] visited = new boolean[50];
  int answer = 0;
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<Integer>());
    }

    int root = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(st.nextToken());
      if (x == -1) root = i;
      else graph.get(x).add(i);
    }

    d = Integer.parseInt(br.readLine());

    bfs(root);

    System.out.println(answer);
  }

  public void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(start);
    visited[start] = true;

    while (!q.isEmpty()) {
      int now = q.poll();
      if (now == d) continue;
      int cnt = 0;
      
      for (int next : graph.get(now)) {
        if (next == d) cnt++;
        if (!visited[next]) {
          q.offer(next);
          visited[next] = true;
        }
      }

      if (cnt == graph.get(now).size()) answer++;
    }
  }
}