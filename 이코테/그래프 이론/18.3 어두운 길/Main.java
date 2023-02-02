import java.util.*;
import java.io.*;

class Main {

  int[] parent = new int[200001];  // 부모 테이블
  ArrayList<Edge> edges = new ArrayList<>();  // 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());  // 집의 개수
    int m = Integer.parseInt(st.nextToken());  // 도로의 개수

    // 부모 테이블을 자기 자신으로 초기화
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }
    
    // 모든 간선에 대한 정보를 입력 받기
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int z = Integer.parseInt(st.nextToken());
      edges.add(new Edge(x, y, z));
    }

    Collections.sort(edges);  // 간선을 비용순으로 정렬
    
    long answer = 0;
    for (int i = 0; i < edges.size(); i++) {
      int x = edges.get(i).getX();
      int y = edges.get(i).getY();
      int cost = edges.get(i).getDistance();

      if (findParent(x) != findParent(y)) unionParent(x, y);  // 사이클이 발생하지 않는 경우에만 집합에 포함
      else answer += cost;  // 사이클이 발생하는 경우, 절약해야하는 비용이므로 정답에 합침
    }

    System.out.println(answer);
  }

  public void unionParent(int a, int b) {
    a = findParent(a);
    b = findParent(b);

    if (a < b) parent[b] = a;
    else parent[a] = b;
  }

  public int findParent(int x) {
    if (parent[x] == x) return x;
    return parent[x] = findParent(parent[x]);
  }
}

class Edge implements Comparable<Edge> {

  private int x;
  private int y;
  private int distance;

  public Edge(int x, int y, int distance) {
    this.x = x;
    this.y = y;
    this.distance = distance;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public int getDistance() {
    return this.distance;
  }

  @Override
  public int compareTo(Edge other) {
    return this.distance - other.distance;
  }
}