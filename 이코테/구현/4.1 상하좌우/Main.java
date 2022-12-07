import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] plans = br.readLine().split(" ");
    int x = 1;  // 행
    int y = 1;  // 열

    // L, R, U, D에 따른 이동 방향
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    char[] moveTypes = {'L', 'R', 'U', 'D'};

    // 이동 계획을 하나씩 확인 
    for (int i = 0; i < plans.length; i++) {
      char plan = plans[i].charAt(0);
      // 이동 후 좌표 구하기
      int nx = -1;
      int ny = -1;

      for (int j = 0; j < 4; j++) {
        if (plan == moveTypes[j]) {
          nx = x + dx[j];
          ny = y + dy[j];
        }
      }

      if (nx < 1 || nx > n || ny < 1 || ny > n) continue;

      x = nx;
      y = ny;
    }

    System.out.println(x + " " + y);
  }
  
  private void mySolution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());  // 정사각형의 크기
    
    String secondLine = br.readLine();
    String[] letters = secondLine.split(" ");
    int row = 1;  // 현재 행
    int col = 1;  // 현재 열

    for (int i = 0; i < letters.length; i++) {
      String letter = letters[i];
      int moveRow = 0;  // 움직일 행
      int moveCol = 0;  // 움직일 열
      
      switch(letter) {
        case "L" :
          moveCol = -1;
          break;
        case "R" :
          moveCol = 1;
          break;
        case "U" :
          moveRow = -1;
          break;
        case "D" :
          moveRow = 1;
          break;
        default :
          break;
      }

      if (row + moveRow <= n && row + moveRow > 0 && col + moveCol <= n && col + moveCol > 0) {
        row += moveRow;
        col += moveCol;
      }
    }

    System.out.println(row + " " + col);
  }
}