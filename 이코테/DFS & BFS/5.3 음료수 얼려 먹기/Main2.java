import java.util.*;
import java.io.*;

public class Main2 {

  public int n, m;
  public int[][] graph = new int[1000][1000];

  // DFS로 특정 노드를 방문하고 연결된 모든 노드들로 방문
  public boolean dfs(int x, int y) {
    // 주어진 범위에서 벗어나는 경우에는 즉시 종료
    if (x <= -1 || x >= n || y <= -1 || y >= m) {
      return false;
    }
    // 현재 노드를 아직 방문하지 않았다면
    if (graph[x][y] == 0) {
      // 해당 노드 방문 처리
      graph[x][y] = 1;
      // 상하좌우의 위치들로 모두 재귀적으로 호출
      dfs(x - 1, y);
      dfs(x, y - 1);
      dfs(x + 1, y);
      dfs(x, y + 1);

      return true;
    }

    return false;
  }

  public static void main(String[] args) throws Exception {
    new Main2().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // N, M을 공백을 기준으로 구분하여 입력 받기
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    // 2차원 리스트의 맵 정보 입력 받기
    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < m; j++) {
        graph[i][j] = str.charAt(j) - '0';
      }
    }

    // 모든 노드(위치)에 대하여 음료수 채우기
    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // 현재 위치에서 DFS 수행
        if (dfs(i, j)) {
          result++;
        }
      }
    }

    System.out.println(result);  // 정답 출력
  }
}