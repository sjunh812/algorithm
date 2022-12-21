import java.util.*;
import java.io.*;

class Main {

  int n;  // 얼음 틀의 세로 길이(행)
  int m;  // 얼음 틀의 가로 길이(열)
  int[][] frame;  // 얼음 틀
  boolean[][] visited;  // 얼음 틀 방문 노드

  // 상하좌우 이동
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};

  int cnt = 0;
  int result = 0;
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    frame = new int[n][m];
    visited = new boolean[n][m];

    // 얼음 틀 채우기 및 방문 노드 초기화
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      
      for (int j = 0; j < m; j++) {
        frame[i][j] = line.charAt(j) - '0';
        visited[i][j] = false;  
      }
    }

   for (int i = 0; i < n; i++) {     
      for (int j = 0; j < m; j++) {
        // dfs(i, j);
        bfs(i, j);
        System.out.println("cnt : " + cnt);
        if (cnt != 0) result++;
        cnt = 0;
      }
    }

    System.out.println(result);
  }

  private void dfs(int x, int y) {
    if (visited[x][y]) return;
    
    visited[x][y] = true;

    if (frame[x][y] == 1) {
      return;
    } else {
      cnt++;
    }

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
        if (!visited[nx][ny]) {
          dfs(nx, ny);
        }
      }
    }
  }

  private void bfs(int startX, int startY) {
    if (visited[startX][startY]) return;
    
    visited[startX][startY] = true;
    
    Queue<ArrayList<Integer>> queue = new LinkedList<>();
    ArrayList<Integer> start = new ArrayList<>();
    start.add(startX);
    start.add(startY);
    queue.offer(start);

    while (!queue.isEmpty()) { 
      int x = queue.peek().get(0);
      int y = queue.poll().get(1);

      if (frame[x][y] == 1) continue;
      else cnt++;
      
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
          if (!visited[nx][ny]) {
            ArrayList<Integer> position = new ArrayList<>();
            position.add(nx);
            position.add(ny);
            queue.offer(position);
            visited[nx][ny] = true;
          }
        }
      }
    }
  }
}