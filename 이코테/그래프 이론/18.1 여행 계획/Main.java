import java.util.*;
import java.io.*;

class Main {

  int n;  // 여행지의 개수
  int m;  // 여행 계획에 속한 여행지의 개수
  int[] parent = new int[501];  // 부모 테이블
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    // 부모 테이블상에서, 부모를 자기 자신으로 초기화
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }

    // Union 연산을 각각 수행
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        int x = Integer.parseInt(st.nextToken());
        // 연결된 경우 합집합(Union) 연산 수행
        if (x == 1) unionParent(i, j);
      }
    }

    // 여행 계획 입력 받기
    ArrayList<Integer> plan = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int x = Integer.parseInt(st.nextToken());
      plan.add(x);
    }

    boolean answer = true;
    // 여행 계획에 속하는 모든 노드들의 루트가 동일한지 확인
    for (int i = 0; i < m - 1; i++) {
      if (findParent(plan.get(i)) != findParent(plan.get(i + 1))) answer = false;
    }

    // 여행 계획에 속하는 모든 노드가 서로 연결되어 있는지(루트가 동일한지) 확인
    if (answer) System.out.println("YES");
    else System.out.println("NO");
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
    if (parent[x] == x) return x;
    return parent[x] = findParent(parent[x]);
  }
}