import java.util.*;
import java.io.*;

class Main {

  int[] parent = new int[100001];  // 부모 테이블
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 부모 테이블상에서, 부모를 자기 자신으로 초기화
    for (int i = 0; i <= n; i++) {
      parent[i] = i;
    }

    // 각 연산을 하나씩 확인 
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int oper = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (oper == 0) {  // 합집합(Union) 연산인 경우
        unionParent(a, b);
      } else {  // 찾기(Find) 연산인 경우
        if (findParent(a) == findParent(b)) System.out.println("YES");
        else System.out.println("NO");
      }
    }
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