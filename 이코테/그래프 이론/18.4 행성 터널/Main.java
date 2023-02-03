import java.util.*;
import java.io.*;

class Main {
  
  int n;  // 노드의 개수
  Position[] x;
  Position[] y;
  Position[] z;
  int[] parent = new int[100001];  // 부모 테이블 
  ArrayList<Edge> edges = new ArrayList<>();  // 모든 간선을 담을 리스트와, 최종 비용을 담을 변수

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    // 부모 테이블상에서, 부모를 자기 자신으로 초기화
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }

    ArrayList<Position> x = new ArrayList<Position>();
    ArrayList<Position> y = new ArrayList<Position>();
    ArrayList<Position> z = new ArrayList<Position>();

    // 모든 노드에 대한 좌표 값 입력받기
    for (int i = 1; i <= n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      x.add(new Position(Integer.parseInt(st.nextToken()), i));
      y.add(new Position(Integer.parseInt(st.nextToken()), i));
      z.add(new Position(Integer.parseInt(st.nextToken()), i));
    }

    Collections.sort(x);
    Collections.sort(y);
    Collections.sort(z);

    // 인접한 노드들로부터 간선 정보를 추출하여 처리
    for (int i = 0; i < n - 1; i++) {
      edges.add(new Edge(x.get(i).getY(), x.get(i + 1).getY(), x.get(i + 1).getX() - x.get(i).getX()));
      edges.add(new Edge(y.get(i).getY(), y.get(i + 1).getY(), y.get(i + 1).getX() - y.get(i).getX()));
      edges.add(new Edge(z.get(i).getY(), z.get(i + 1).getY(), z.get(i + 1).getX() - z.get(i).getX()));
    }

    // 간선을 비용순으로 정렬
    Collections.sort(edges);

    long answer = 0;

    // 간선을 하나씩 확인하며
    for (int i = 0; i < edges.size(); i++) {
      int a = edges.get(i).getA();
      int b = edges.get(i).getB();
      int cost = edges.get(i).getDistance();

      // 사이클이 발생하지 않는 경우에만 집합에 포함
      if (findParent(a) != findParent(b)) {
        unionParent(a, b);
        answer += cost;
      }
    }

    System.out.println(answer);
  }

  // 두 원소가 속한 집합을 합치기
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

class Position implements Comparable<Position> {

  private int x;
  private int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  @Override
  public int compareTo(Position other) {
      if (this.x == other.x) return Integer.compare(this.y, other.y);
      return Integer.compare(this.x, other.x);
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