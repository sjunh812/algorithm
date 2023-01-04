import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 떡의 개수(N)과 요청한 떡의 길이(M)
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 떡의 개별 높이 정보
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
    // 이진 탐색을 위한 시작점과 끝점 설정
    int start = 0;
    int end = Integer.MAX_VALUE;

    // 이진 탐색 수행 (반복문)
    int result = 0;

    while (start <= end) {
      long total = 0;
      int mid = (start + end) / 2;

      for (int i = 0; i < n; i++) {
        // 잘랐을 때의 떡의 양 계산
        if (arr[i] > mid) total += arr[i] - mid;
      }

      // 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
      if (total < m) end = mid - 1;
      else {  // 떡의 양이 충분한 경우 덜 자르기(오른쪽 부분)
        result = mid;  // 최대한 덜 잘랐을 때가 정답이므로, 저장
        start = mid + 1;
      }
    }

    System.out.println(result);
  }
}