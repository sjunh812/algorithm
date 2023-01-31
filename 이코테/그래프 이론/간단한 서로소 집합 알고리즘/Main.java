import java.util.*;
import java.io.*;

class Main {

  int v;  // 노드의 개수
  int e;  // 간선(Union 연산)의 개수
  int[] parent = new int[100001];  // 부모 테이블
  
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

    // Union 연산을 각각 수행
    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      unionParent(a, b);
    }

    // 각 원소가 속한 집합 출력하기
    System.out.print("각 원소가 속한 집합: ");
    for (int i = 1; i <= v; i++) {
      System.out.print(findParent(i) + " ");
    }
    System.out.println();

    // 부모 테이블 내용 출력하기
    System.out.print("부모 테이블: ");
    for (int i = 1; i <= v; i++) {
      System.out.print(parent[i] + " ");
    }
    System.out.println();
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
    // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
    if (x == parent[x]) return x;
    return findParent(parent[x]);
  }
}