import java.util.*;
import java.io.*;

class Main {

  int n;  // 보드의 세로 크기(행)
  int m;  // 보드의 가로 크기(열)
  int min = 11;  // 빨간 구슬을 구멍으로 뺄 수 있는 최소 횟수
  int goalCnt = 0;  // 구멍에 빠진 구슬의 개수
  String goalColor = "R";  // 구멍에 빠진 구슬의 색상
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 보드의 세로 크기(행) n, 가로 크기(열) m 입력받기
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    
    String[][] board = new String[n][m];  // 보드
    int rx = 0, ry = 0;  // 빨간 구슬의 x, y 좌표
    int bx = 0, by = 0;  // 파란 구슬의 x, y 좌표

    // 보드판 그리기(+구슬의 위치 파악)
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      
      for (int j = 0; j < m; j++) {
        board[i][j] = Character.toString(line.charAt(j));
        
        if (board[i][j].equals("R")) {  // 빨간 구슬의 위치
          rx = i;
          ry = j;
        }
        if (board[i][j].equals("B")) {  // 파란 구슬의 위치
          bx = i;
          by = j;
        }
      }
    }

    // 구슬 탈출 시작!!
    escape(board, 0, rx, ry, bx, by);

    if (min == 11) min = -1;
    
    System.out.println(min);
  }

  // 구슬 탈출
  private void escape(String[][] board, int depth, int rx, int ry, int bx, int by) {
    if (depth == 11) {  // 기울이기 시행횟수가 10회 초과시 종료
      return;
    }

    if (goalCnt > 0) {  // 구멍에 한 개이상의 구슬이 빠지면 종료
      // 단, 빨간 구슬'만' 빠진 경우에 최소 시행 횟수 카운팅
      if (goalCnt == 1 && goalColor.equals("R")) min = Math.min(min, depth);
      return;
    }

    // 기울이기를 수행한 뒤, 각 구슬의 위치
    int[] coordR = new int[2];  
    int[] coordB = new int[2];

    // 방향별로 기울이기 수행
    // 0 : 왼쪽, 1 : 오른쪽, 2 : 위쪽, 3: 아래쪽
    for (int i = 0; i < 4; i++) {      
      if (rx == bx) {  // 두 구슬의 행이 같을 때
        if (i == 0 && ry > by || i == 1 && ry < by) { 
          // 1. 방향이 왼쪽이면서 파란 구슬이 더 왼쪽에 있는 경우
          // 2. 방향이 오른쪽이면서 파란 구슬이 더 오른쪽에 있는 경우
          // → 파란 구슬부터 기울이기 수행
          coordB = tilt(board, i, bx, by, "B");
          coordR = tilt(board, i, rx, ry, "R");
        } else {
          // 그렇지 않다면 빨간 구슬부터 기울이기 수행
          coordR = tilt(board, i, rx, ry, "R");
          coordB = tilt(board, i, bx, by, "B");
        }
      } else if (ry == by) {  // 두 구슬의 열이 같을 때
        if (i == 2 && rx > bx || i == 3 && rx < bx) {  
          // 1. 방향이 위쪽이면서 파란 구슬이 더 위쪽에 있는 경우
          // 2. 방향이 아래쪽이면서 파란 구슬이 더 아래쪽에 있는 경우
          // → 파란 구슬부터 기울이기 수행
          coordB = tilt(board, i, bx, by, "B");
          coordR = tilt(board, i, rx, ry, "R");
        } else {
          // 그렇지 않다면 빨간 구슬부터 기울이기 수행
          coordR = tilt(board, i, rx, ry, "R");
          coordB = tilt(board, i, bx, by, "B");
        }
      } else {  // 어느 구슬부터 기울이기를 수행해도 무관
        coordR = tilt(board, i, rx, ry, "R");
        coordB = tilt(board, i, bx, by, "B");
      }
           
      escape(board, depth + 1, coordR[0], coordR[1], coordB[0], coordB[1]);
      
      // 이전 보드 복구
      board[coordR[0]][coordR[1]] = ".";
      board[coordB[0]][coordB[1]] = ".";
      board[rx][ry] = "R";
      board[rx][ry] = "B";
      // 구멍에 빠진 구슬의 개수 초기화
      goalCnt = 0;
    }
  }
  
  // 기울이기
  private int[] tilt(String[][] board, int direction, int x, int y, String marble) {
    int[] coord = {x, y};
    board[x][y] = ".";
    
    if (direction == 0) {  // 왼쪽
      for (int i = y - 1; i >= 0; i--) {
        String next = board[x][i];

        if (!next.equals(".")) {
          if (next.equals("O")) {
            goalCnt++;
            goalColor = marble;
          } else {
            coord[0] = x;
            coord[1] = i + 1;
            board[x][i + 1] = marble; 
          }
          
          break;
        }
      }
    }
    
    if (direction == 1) {  // 오른쪽
      for (int i = y + 1; i <= m - 1; i++) {
        String next = board[x][i];

        if (!next.equals(".")) {
          if (next.equals("O")) {
            goalCnt++;
            goalColor = marble;
          } else {
            coord[0] = x;
            coord[1] = i - 1;
            board[x][i - 1] = marble; 
          }
          
          break;
        }
      }
    }

    if (direction == 2) {  // 위
      for (int i = x - 1; i >= 0; i--) {
        String next = board[i][y];

        if (!next.equals(".")) {
          if (next.equals("O")) {
            goalCnt++;
            goalColor = marble;
          } else {
            coord[0] = i + 1;
            coord[1] = y;
            board[i + 1][y] = marble;
          }

          break;
        }
      }
    }

    if (direction == 3) {  // 아래
      for (int i = x + 1; i <= n - 1; i++) {
        String next = board[i][y];

        if (!next.equals(".")) {
          if (next.equals("O")) {
            goalCnt++;
            goalColor = marble;
          } else {
            coord[0] = i - 1;
            coord[1] = y;
            board[i - 1][y] = marble;
          }

          break;
        }
      }
    }

    return coord;
  }
}