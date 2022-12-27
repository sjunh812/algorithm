import java.util.*;
import java.io.*;

class Main {

  int n;  // 수빈이의 위치
  int k;  // 동생의 위치
  int[] visited;  // 방문 노드
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    visited = new int[100001];

    System.out.println(bfs());
  }

  public int bfs() {
    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(n, 0));
    visited[n] = 1;

    while (!q.isEmpty()) {
      Node node = q.poll();
      int pos = node.getPos();
      int time = node.getTime();

      if (node.getPos() == k) return time;
      
      // 뒤로 걷기
      int next1 = pos + 1;
      if (next1 >= 0 && next1 <= 100000 && visited[next1] == 0) {
        q.offer(new Node(next1, time + 1));
        visited[next1] = 1;
      }

      // 앞으로 걷기
      int next2 = pos - 1;
      if (next2 >= 0 && next2 <= 100000 && visited[next2] == 0) {
        q.offer(new Node(next2, time + 1));
        visited[next2] = 1;
      }

      // 순간이동
      int next3 = pos * 2;
      if (next3 >= 0 && next3 <= 100000 && visited[next3] == 0) {
        q.offer(new Node(next3, time + 1));
        visited[next3] = 1;
      }
    }

    return -1;
  }
}

class Node {

  private int pos;
  private int time;

  public Node(int pos, int time) {
    this.pos = pos;
    this.time = time;
  }

  public int getPos() {
    return this.pos;
  }

  public int getTime() {
    return this.time;
  }
}