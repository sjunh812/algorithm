import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String a = br.readLine();
    String b = br.readLine();

    // 최소 편집 거리 출력
    System.out.println(editDistance(a, b));
  }

  public int editDistance(String a, String b) {
    int lenA = a.length();
    int lenB = b.length();

    // 다이나믹 프로그래밍을 위한 2차원 DP 테이블 초기화
    int[][] dp = new int[lenA + 1][lenB + 1];

    // DP 테이블 초기 설정
    for (int i = 1; i <= lenA; i++) {
      dp[i][0] = i;
    }
    for (int i = 1; i <= lenB; i++) {
      dp[0][i] = i;
    }

    // 최소 편집 거리 계산
    for (int i = 1; i <= lenA; i++) {
      for (int j = 1; j <= lenB; j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {  // 문자가 같다면, 왼쪽 위에 해당하는 수를 그대로 대입
          dp[i][j] = dp[i - 1][j - 1];
        } else {  // 문자가 다르다면, 세 가지 경우 중에서 최솟값 찾기
          // 삽입(왼쪽), 삭제(위쪽), 교체(왼쪽 위) 중에서 최소 비용을 찾아 대입
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1; 
        }
      }
    }

    return dp[lenA][lenB];
  }
}