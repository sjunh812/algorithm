import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

  int row;  // 행
  int col;  // 열
  String[] map;  // 지도(빈칸 및 건물)
  int result = 0;  // 파이프라인의 개수
  int[] direction = {-1, 0 ,1};  // 탐색 방향(행), 열의 경우 한 칸씩 증가
  boolean[][] visited;  // 탐색여부를 체크할 2차원 배열(boolean)
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    row = Integer.parseInt(st.nextToken());
    col = Integer.parseInt(st.nextToken());
    map = new String[row];
    visited = new boolean[row][col];
    
    for (int i = 0; i < row; i++) {      
      Arrays.fill(visited[i], false);  // 탐색여부 최초 false로 초기화
      map[i] = br.readLine();
    }

    // DFS, 모든 경로를 조건에 맞게 탐색
    for (int i = 0; i < row; i++) {
      nodeSearch(i, 0);
    }

    System.out.println(result);
  }

  private boolean nodeSearch(int r, int c) {
    visited[r][c] = true;  // 탐색 체크

    if (c == col - 1) {  // 탐색의 마지막 도달
      result++;  // 파이프라인 완성, 개수 증가
      return true;
    }
    
    for (int i = 0; i < 3; i++) {  // 탐색 3가지 조건(오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선)
      int nr = r + direction[i];  // 다음 탐색할 행
      int nc = c + 1;  // 다음 탐색할 열

      if (nr < 0 || nr >= row || visited[nr][nc] || map[nr].charAt(nc) == 'x') {
        // 해당 분기는 탐색 종료 - 조건 미충족
        continue;
      }

      if (nodeSearch(nr, nc)) {  // 탐색 종료
        return true;
      }
    }

    return false;
  }
}