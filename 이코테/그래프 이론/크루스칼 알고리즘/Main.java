import java.util.*;
import java.io.*;

class Main {

  int v;  // 노드의 개수
  int e;  // 간선의 개수
  int[] parent = new int[100001];  // 부모 테이블
  ArrayList<Edge> edges = new ArrayList<>();  // 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
  int result = 0;
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    v = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());

    // 부모 테이블상에서, 부모를 자기 자신으로 초기화
    for (int i = 1; i <= v; i++) {
      parent[i] = i;
    }

    // 모든 간선에 대한 정보를 입력 받기
    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      edges.add(new Edge(a, b, cost));
    }

    // 간선을 비용순으로 정렬
    Collections.sort(edges);

    // 간선을 하나씩 확인하며
    for (int i = 0; i < edges.size(); i++) {
      int a = edges.get(i).getNodeA();
      int b = edges.get(i).getNodeB();
      int cost = edges.get(i).getDistance();

      // 사이클이 발생하지 않은 경우에만 집합에 포합
      if (findParent(a) != findParent(b)) {
        unionParent(a, b);
        result += cost;
      }
    }

    System.out.println(result);
  }

  // 두 원소가 속한 집합 합치기
  public void unionParent(int a, int b) {
    a = findParent(a);
    b = findParent(b);

    if (a < b) parent[b] = a;
    else parent[a] = b;
  }

  // 특정 원소가 속한 집합을 찾기
  public int findParent(int x) {
    if (parent[x] == x) return x;
    return parent[x] = findParent(parent[x]);
  }
}

class Edge implements Comparable<Edge> {

  private int nodeA;
  private int nodeB;
  private int distance;

  public Edge(int nodeA, int nodeB, int distance) {
    this.nodeA = nodeA;
    this.nodeB = nodeB;
    this.distance = distance;
  }

  public int getNodeA() {
    return this.nodeA;
  }

  public int getNodeB() {
    return this.nodeB;
  }

  public int getDistance() {
    return this.distance;
  }

  @Override
  public int compareTo(Edge other) {
    return this.distance - other.distance;
  }
}