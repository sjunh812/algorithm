import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String inputData = br.readLine();
    int row = inputData.charAt(1) - '0';  // 행
    int column = inputData.charAt(0) - 'a' + 1;  // 열

    // 나이트가 이동할 수 있는 8가지 방향 정의
    int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
    int result = 0;
    for (int i = 0; i < 8; i++) {
      // 이동하고자 하는 위치 확인
      int nextRow = row + dx[i];
      int nextColumn = column + dy[i];
      // 해당 위치로 이동이 가능하다면 카운트 증가 
      if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
        result++;
      } 
    }

    System.out.println(result);
  }
  
  private void mySolution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int x = 0;
    int y = input.charAt(1) - '0';
    int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
    int[] dy = {-2, 2, -2, 2, -1, 1, -1, 1};
    char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    for (int i = 0; i < letters.length; i++) {
      if (input.charAt(0) == letters[i]) {
        x = i + 1;
        break;
      }
    }

    int result = 0;
    
    for (int i = 0; i < 8; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx <= 8 && nx > 0 && ny <= 8 && ny > 0) {
        result++;
      }
    }

    System.out.println(result);
  }
}