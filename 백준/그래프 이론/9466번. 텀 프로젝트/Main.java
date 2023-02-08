import java.util.*;
import java.io.*;

class Main {

  int n;
  int[] graph;
  int[] indegree;
  int[] team;
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());

    for (int tc = 0; tc < t; tc++) {
      n = Integer.parseInt(br.readLine());

      graph = new int[100001];
      indegree = new int[100001];
      team = new int[100001];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++) {
        int x = Integer.parseInt(st.nextToken());
        graph[i] = x;
        indegree[x]++;
      }

      // 위상 정렬을 수행
      topologySort();

      int answer = 0;
      for (int i = 1; i <= n; i++) {
        if (team[i] == 1) answer++;
      }
      bw.write(answer + "\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }

  public void topologySort() {
    Queue<Integer> q = new LinkedList<>();

    for (int i = 1; i <= n; i++) {
      if (indegree[i] == 0) {
        q.offer(i);
        team[i] = 1;
      }
    }

    while (!q.isEmpty()) {
      int now = q.poll();
      int next = graph[now];
      
      indegree[next]--;
      if (indegree[next] == 0) {
        q.offer(next);
        team[next]= 1;
      }
    }
  }
}