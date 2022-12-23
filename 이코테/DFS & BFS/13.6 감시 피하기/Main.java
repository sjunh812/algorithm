import java.util.*;
import java.io.*;

class Main {

  int n;  // 복도의 크기
  String[][] arr;  // 복도를 나타낸 2차원 배열
  ArrayList<ArrayList<Integer>> teachers = new ArrayList<>();  // 선생님의 위치를 나타낸 리스트
  boolean result = false;
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    arr = new String[n + 1][n + 1];

    // 복도 그리기
    for (int i = 1; i <= n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        String info = st.nextToken();
        arr[i][j] = info;

        // 선생님의 위치 저장
        if (info.equals("T")) {
          ArrayList<Integer> pos = new ArrayList<>();
          pos.add(i);
          pos.add(j);
          teachers.add(pos);
        }
      }
    }

    // 임의의 장애물 3개를 세울 때, 모든 학생이 선생님의 감시를 피할 수 있는지 검사
    obstacle(arr, 0);

    // 결과 출력
    if (result || teachers.size() == 0) System.out.println("YES");
    else System.out.println("NO");
  }

  private void obstacle(String[][] arr, int count) {
    // 이미 감시로부터 피하는 경우가 존재
    if (result) return;

    // 장애물 3개를 모두 세웠을 때, 감시 회피 검사
    if (count == 3) {  
      if (check(arr)) result = true;
      return;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (arr[i][j].equals("X")) {
          arr[i][j] = "O";
          obstacle(arr, count + 1);
          arr[i][j] = "X";
        }
      }
    }
  }

  private boolean check(String[][] arr) {
    for (int i = 0; i < teachers.size(); i++) {
      // 선생님의 위치
      int x = teachers.get(i).get(0);
      int y = teachers.get(i).get(1);

      // 열 감시 검사
      boolean frontSafe = false;
      boolean backSafe = false;
      for (int j = y - 1; j >= 1; j--) {  // 선생님 기준 앞 열
        if (arr[x][j].equals("S") && !frontSafe) return false;
        if (arr[x][j].equals("O")) frontSafe = true;
      }

      for (int j = y + 1; j <= n; j++) {  // 선생님 기준 뒷 열
        if (arr[x][j].equals("S") && !backSafe) return false;
        if (arr[x][j].equals("O")) backSafe = true;
      }

      // 행 감시 검사
      frontSafe = false;
      backSafe = false;     
      for (int j = x - 1; j >= 1; j--) {  // 선생님 기준 앞 행
        if (arr[j][y].equals("S") && !frontSafe) return false;
        if (arr[j][y].equals("O")) frontSafe = true;
      }

      for (int j = x + 1; j <= n; j++) {  // 선생님 기준 뒷 행
        if (arr[j][y].equals("S") && !backSafe) return false;
        if (arr[j][y].equals("O")) backSafe = true;
      }
    }
    
    return true;
  }
}