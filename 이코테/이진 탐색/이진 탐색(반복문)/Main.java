import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());  // 원소의 개수
    int target = Integer.parseInt(st.nextToken());  // 찾고자 하는 값

    // 전체 원소 입력받기
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    // 이진 탐색 수행 결과 출력
    int result = binarySearch(arr, target, 0, n - 1);
    if (result == -1) System.out.println("원소가 존재하지 않습니다.");  
    else System.out.println(result + 1 + "번째 원소");
  }

  // 이진 탐색 (반복문)
  public static int binarySearch(int[] arr, int target, int start, int end) {
    while (start <= end) {
      int mid = (start + end) / 2;

      if (arr[mid] == target) return mid;
      else if (arr[mid] > target) end = mid -1;
      else start = mid + 1;
    }

    return -1;
  }
}