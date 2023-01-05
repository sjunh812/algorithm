import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 이진 탐색 수행
    int index = binarySearch(arr, 0, n - 1);

    // 결과 출력
    System.out.println(index);
  }

  // 이진 탐색(재귀 함수)
  public int binarySearch(int[] arr, int start, int end) {
    if (start > end) return -1;

    int mid = (start + end) / 2;

    // 고정점을 찾은 경우 중간점 인덱스 반환
    if (arr[mid] == mid) return mid;
    // 중간점의 값보다 중간점이 작은 경우 왼쪽 확인
    else if (arr[mid] > mid) return binarySearch(arr, start, mid - 1);
    // 중간점의 값보다 중간점이 큰 경우 오른쪽 확인
    else return binarySearch(arr, mid + 1, end);
  }
}