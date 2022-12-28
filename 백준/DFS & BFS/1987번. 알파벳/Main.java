import java.util.*;
import java.io.*;

class Main {

  int r;  // 행
  int c;  // 열
  int[][] board;  // 보드

  // 말의 이동 거리
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};

  int result = 0;
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    board = new int[r][c];
    
    for (int i = 0; i < r; i++) {
      String str = br.readLine();
      for (int j = 0; j < c; j++) {
        board[i][j] = str.charAt(j) - 'A';  // 알파벳을 숫자로 표시
      }
    }

    dfs(0 , 0, new int[26], 0);

    System.out.println(result);
  }

  public void dfs(int x, int y, int[] history, int count) {
    history[board[x][y]] = 1;
    count++;
    
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
        if (history[board[nx][ny]] == 0) {
          dfs(nx, ny, history, count);
          history[board[nx][ny]] = 0;  // 백트래킹
        }
      }
    }

    result = Math.max(result, count);
  }
}