import java.util.*;
import java.io.*;

class Main {

  int g;  // 탑승구의 수
  int p;  // 비행기의 수
  int[] parent = new int[100001];  // 부모 테이블
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    g = Integer.parseInt(br.readLine());
    p = Integer.parseInt(br.readLine());

    // 부모 테이블상에서, 부모를 자기 자신으로 초기화
    for (int i = 1; i <= g; i++) {
      parent[i] = i;
    }

    // 순서대로 비행기별 도킹 가능한 탑승구 범위를 입력 받기
    int[] planes = new int[p];
    for (int i = 0; i < p; i++) {
      planes[i] = Integer.parseInt(br.readLine());
    }

    int answer = 0;
    for (int i = 0; i < p; i++) {
      int parent = findParent(planes[i]);  // 현재 비행기의 탑승구의 루트 확인
      if (parent == 0) break;  // 현재 루트가 0이라면, 종료
      unionParent(parent, parent - 1);  // 그렇지 않다면 바로 왼쪽의 집합과 합치기
      answer++;
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