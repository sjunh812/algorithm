import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());  // 테스트 케이스의 개수

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());  // 레지스터 초기 값
      int b = Integer.parseInt(st.nextToken());  // 레지스터 최종 값
      int[] visited = new int[10000];  // 변환 레지스터의 방문 노드

      System.out.println(bfs(a, b, visited));
    }
  }

  // A를 B로 변환하는데 필요한 최소한의 명령어를 출력하기 위해 너비 우선 탐색(BFS) 실행
  public String bfs(int a, int b, int[] visited) {
    Queue<Integer> q = new LinkedList<>();
    Queue<String> q2 = new LinkedList<>();
    q.offer(a);
    q2.offer("");
    visited[a] = 1;

    while (!q.isEmpty()) {
      int n = q.poll();
      String cmd = q2.poll();

      if (n == b) return cmd;
         
      // S
      int s = n - 1;
      if (n == 0) s = 9999;
      if (visited[s] == 0) {
        q.offer(s);
        q2.offer(cmd + "S");
        visited[s] = 1; 
      }
      
      if (n != 0) {
        // D
        int d = n * 2;
        if (d > 9999) d %= 10000;
        if (visited[d] == 0) {
          q.offer(d);
          q2.offer(cmd + "D");
          visited[a] = 1;
        }

        // L
        int l = rotate(n, true);
        if (l != n && visited[l] == 0) {
          q.offer(l);
          q2.offer(cmd + "L");
          visited[l] = 1;
        }
      
        // R
        int r = rotate(n, false);
        if (r != n && visited[r] == 0) {
          q.offer(r);
          q2.offer(cmd + "R"); 
          visited[r] = 1;
        }
      }
    }

    return "";
  }

  // n의 각 자릿수를 왼편 또는 오른편으로 회전
  public int rotate(int n, boolean left) {
    int d1 = n / 1000;
    int d2 = (n - d1 * 1000) / 100;
    int d3 = (n - (d1 * 1000 + d2 * 100)) / 10;
    int d4 = (n - (d1 * 1000 + d2 * 100 + d3 * 10));
    StringBuilder sb = new StringBuilder();
    
    if (left) {
      sb.append(String.valueOf(d2));
      sb.append(String.valueOf(d3));
      sb.append(String.valueOf(d4));
      sb.append(String.valueOf(d1));
    }
    else {
      sb.append(String.valueOf(d4));
      sb.append(String.valueOf(d1));
      sb.append(String.valueOf(d2));
      sb.append(String.valueOf(d3));
    }

    return Integer.parseInt(sb.toString());
  }
}