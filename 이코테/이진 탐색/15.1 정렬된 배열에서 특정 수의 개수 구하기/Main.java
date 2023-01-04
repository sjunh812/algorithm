import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 데이터의 개수 N, 찾고자 하는 값 x 입력받기
    int n = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    // 전체 데이터 입력받기
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 값이 [x, x] 범위에 있는 데이터의 개수 계산
    int result = countByRange(arr, x, x);

    // 값이 x인 원소가 존재하지 않는다면
    if (result == 0) System.out.println(-1);
    // 값이 x인 원소가 존재한다면
    else System.out.println(result);
  }
  
  // 값이 [left_value, right_value]인 데이터의 개수를 반환하는 함수
  public int countByRange(int[] arr, int leftValue, int rightValue) {
    int rightIndex = upperBound(arr, rightValue, 0, arr.length - 1);
    int leftIndex = lowerBound(arr, leftValue, 0, arr.length - 1);
    
    return rightIndex - leftIndex;
  }

  public int lowerBound(int[] arr, int target, int start, int end) {
    while (start < end) {
      int mid = (start + end) / 2;

      if (arr[mid] >= target) end = mid - 1;
      else start = mid + 1;
    }
    
    return end;
  }
  
  public int upperBound(int[] arr, int target, int start, int end) {
    while (start < end) {
      int mid = (start + end) / 2;

      if (arr[mid] <= target) start = mid + 1;
      else end = mid - 1;
    }
    
    return end;
  }
}