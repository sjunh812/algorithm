import java.util.*;
import java.io.*;

class Main {

  int[] parent = new int[100001];  // 부모 테이블
  ArrayList<Edge> edges = new ArrayList<>();  // 길의 정보를 담은 리스트
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());  // 집의 개수
    int m = Integer.parseInt(st.nextToken());  // 길의 개수

    // 부모 테이블상에서, 부모를 자기 자신으로 초기화
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }

    // 모든 간선에 대한 정보를 입력 받기
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      edges.add(new Edge(a, b, c));
    }

    Collections.sort(edges);  // 간선을 비용순으로 정렬

    int last = 0; // 최소 신장 트리에 포함되는 간선 중에서 가장 비용이 큰 간선
    int result = 0;

    // 간선을 하나씩 확인하며
    for (int i = 0; i < edges.size(); i++) {
      int a = edges.get(i).getA();
      int b = edges.get(i).getB();
      int cost = edges.get(i).getDistance();
      
      // 사이클이 발생하지 않는 경우에만 집합에 포함
      if (findParent(a) != findParent(b)) {
        unionParent(a, b);
        result += cost;
        last = cost;
      }
    } 

    System.out.println(result - cost);
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

  private int a;
  private int b;
  private int distance;

  public Edge(int a, int b, int distance) {
    this.a = a;
    this.b = b;
    this.distance = distance;
  }

  public int getA() {
    return this.a;
  }

  public int getB() {
    return this.b;
  }

  public int getDistance() {
    return this.distance;
  }

  @Override
  public int compareTo(Edge other) {
    return this.distance - other.distance;
  }
}