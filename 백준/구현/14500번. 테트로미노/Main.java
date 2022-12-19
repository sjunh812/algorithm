import java.util.*;
import java.io.*;

class Main {

  int n;  // 종이의 세로 크기
  int m;  // 종이의 가로 크기
  int[][] paper;  // 종이
  int result = 0;  // 테트로미노가 놓인 칸에 쓰인 수들의 최대 합
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    paper = new int[n][m];

    // 종이에 값 채우기
    for (int i = 0; i < n; i++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      
      for (int j = 0; j < m; j++) {
        paper[i][j] = Integer.parseInt(st2.nextToken());  
      }
    }

    tetromino1();
    tetromino2();
    tetromino3();
    tetromino4();
    tetromino5();

    System.out.println(result);
  }

  // 테트로미노1
  // ****
  private void tetromino1() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= m - 4; j++) {
        int sum = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i][j + 3];
        result = Math.max(result, sum);
      }
    }

    for (int j = 0; j < m; j++) {
      for (int i = 0; i <= n - 4; i++) {
        int sum = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 3][j];
        result = Math.max(result, sum);
      }
    }
  }

  // 테트로미노2
  // **
  // **
  private void tetromino2() {
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < m - 1; j++) {
        int sum = paper[i][j] + paper[i][j + 1] + paper[i + 1][j] + paper[i + 1][j + 1];
        result = Math.max(result, sum);
      }
    }
  }

  // 테트로미노3
  // *
  // *
  // **
  private void tetromino3() {
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j <= m - 3; j++) {
        int sum1 = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j];
        int sum2 = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j + 2];
        int sum3 = paper[i][j + 2] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
        int sum4 = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
        result = Math.max(Math.max(Math.max(Math.max(sum1, sum2), sum3), sum4), result);
      }
    }

    for (int j = 0; j < m - 1; j++) {
      for (int i = 0; i <= n - 3; i++) {
        int sum1 = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 2][j + 1];
        int sum2 = paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
        int sum3 = paper[i + 2][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
        int sum4 = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i][j + 1];
        result = Math.max(Math.max(Math.max(Math.max(sum1, sum2), sum3), sum4), result);
      }
    }
  }

  // 테트로미노4
  // *
  // **
  //  *
  private void tetromino4() {
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j <= m - 3; j++) {
        int sum1 = paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j] + paper[i + 1][j + 1];
        int sum2 = paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
        result = Math.max(Math.max(sum1, sum2), result);
      }
    }

    for (int j = 0; j < m - 1; j++) {
      for (int i = 0; i <= n - 3; i++) {
        int sum1 = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
        int sum2 = paper[i + 1][j] + paper[i + 2][j] + paper[i][j + 1] + paper[i + 1][j + 1];
        result = Math.max(Math.max(sum1, sum2), result);
      }
    }
  }

  // 테트로미노5
  // ***
  //  *
  private void tetromino5() {
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j <= m - 3; j++) {
        int sum1 = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j + 1];
        int sum2 = paper[i][j + 1] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
        result = Math.max(Math.max(sum1, sum2), result);
      }
    }

    for (int j = 0; j < m - 1; j++) {
      for (int i = 0; i <= n - 3; i++) {
        int sum1 = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 1][j + 1];
        int sum2 = paper[i + 1][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
        result = Math.max(Math.max(sum1, sum2), result);
      }
    }
  }
}