import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 집의 개수(N)과 공유기의 개수(C)를 입력받기
    int n = Integer.parseInt(st.nextToken());  
    int c = Integer.parseInt(st.nextToken()); 

    // 전체 집의 좌표 정보를 입력받기
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    // 이진 탐색을 위해 정렬 수행
    Arrays.sort(arr);

    int start = 1;  // 가능한 최소 거리(min gap)
    int end = arr[n - 1] - arr[0];  // 가능한 최대 거리(max gap)
    int result = 0;

    while (start <= end) {
      // mid는 가장 인접한 공유기 사이의 거리(gap)을 의미
      int mid = (start + end) / 2;
      // 첫째 집에는 무조건 공유기를 설치한다고 가정
      int value = arr[0];
      int cnt = 1;
      // 현재 mid 값을 이용해 공유기를 설치하기
      for (int i = 1; i < n; i++) {  // 앞에서부터 차근차근 설치
        if (arr[i] - value >= mid) {
          value = arr[i];
          cnt++;
        }
      }
      // c개 이상의 공유기를 설치할 수 있는 경우, 거리를 증가시키기
      if (cnt >= c) {
        start = mid + 1;
        result = mid;  // 최적의 결과를 저장
      }
      // c개 이상의 공유기를 설치할 수 없는 경우, 거리를 감소시키기
      else end = mid - 1;
    }

    System.out.println(result);
  }
}