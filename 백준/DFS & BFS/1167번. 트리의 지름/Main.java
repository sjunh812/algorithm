import java.util.*;
import java.io.*;

class Main {

  int v;  
  ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  boolean[] visited = new boolean[100001];
  int start = 0;
  int answer = 0;
  
  public static void main(String[] arg) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    v = Integer.parseInt(br.readLine());

    for (int i = 0; i <= v; i++) {
      graph.add(new ArrayList<Node>());
    }

    for (int i = 0; i < v; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int next = Integer.parseInt(st.nextToken());
      
      while (next != -1) {
        int distance = Integer.parseInt(st.nextToken());
        graph.get(x).add(new Node(next, distance));
        next = Integer.parseInt(st.nextToken());
      }
    }

    bfs(1);
    visited = new boolean[100001];
    bfs(start);

    System.out.println(answer);
  }

  public void bfs(int s) {
    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(s, 0));
    visited[s] = true;

    while (!q.isEmpty()) {
      Node node = q.poll();
      int x = node.getNumber();
      int dist = node.getDistance();

      if (dist > answer) {
        answer = dist;
        start = x;
      }

      for (Node next : graph.get(x)) {
        int nx = next.getNumber();
        int cost = next.getDistance() + dist;

        if (!visited[nx]) {
          q.offer(new Node(nx, cost));
          visited[nx] = true;
        }
      }
    }
  }
}

class Node {

  private int number;
  private int distance;

  public Node(int number, int distance) {
    this.number = number;
    this.distance = distance;
  }

  public int getNumber() {
    return this.number;
  }

  public int getDistance() {
    return this.distance;
  }
}