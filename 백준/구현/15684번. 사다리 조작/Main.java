import java.util.*;
import java.io.*;

class Main {

  int n;  // 세로선의 개수(사다리 열)
  int m;  // 가로선의 개수(사다리 행)
  int h;  // 세로선마다 가로선을 놓을 수 있는 위치의 개수(점선)
  int result = 4;  // 추가해야 하는 가로선의 개수의 최솟값
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    boolean[][] visited = new boolean[h + 1][n + 1];
    for (int i = 0; i <= h; i++) {
      for (int j = 0; j <= n; j++) {
        visited[i][j] = false;
      }
    }
    
    for (int i = 0; i < m; i++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st2.nextToken());
      int b = Integer.parseInt(st2.nextToken());
      visited[a][b] = true;
    }

    makeLadder(visited, 0);
    
    if (result == 4) result = -1;
    System.out.println(result);
  }

  private void makeLadder(boolean[][] visited, int depth) {
    if (checkLadder(visited)) {
      result = Math.min(depth, result);
      return;
    }
    
    if (depth == 3) {
      return;
    }

    for (int i = 1; i <= h; i++) {
      for (int j = 1; j < n; j++) {
        if (!visited[i][j]) {
          visited[i][j] = true;
          makeLadder(visited, depth + 1);
          visited[i][j] = false;
        }
      }
    }
  }

  private boolean checkLadder(boolean[][] visited) {
    for (int i = 1; i <= n; i++) {
      int a = 1;
      int b = i;
      int lastA = -1;
      int lastB = -1;
      
      while (true) {
        if (a > h) break;
        
        if (visited[a][b] && b + 1 != lastB) {
          lastA = a;
          lastB = b;
          b++;
        } else if (visited[a][b - 1] && b - 1 != lastB) {
          lastA = a;
          lastB = b;
          b--;
        } else {
          lastA = a;
          lastB = b;
          a++;
        }
      } 

      if (i != b) return false;
    }

    return true;
  }
}