import java.util.*;
import java.io.*;

// 1. 두 포인터
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

    Arrays.sort(arr);

    int start = 0;
    int end = n - 1;
    int sum = 2000000000;
    int[] result = new int[2];
    
    while (start < end) {
      if (sum > Math.abs(arr[start] + arr[end])) {
        sum = Math.abs(arr[start] + arr[end]);
        result[0] = arr[start];
        result[1] = arr[end];
      }

      if (arr[start] + arr[end] > 0) end--;
      else start++;
    }

    for (int i = 0; i < 2; i++) {
      System.out.print(result[i] + " ");
    }
  }
}

// 2, 이진 탐색
class Main2 {

  public static void main(String[] args) throws Exception {
    new Main2().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for (int i = 0 ; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 이진 탐색을 위한 정렬
    Arrays.sort(arr);

    int[] answer = new int[2];
    int sum = Integer.MAX_VALUE;

    for (int i = 0; i < n - 1; i++) {
      int start = i + 1;
      int end = n - 1;
      int target = arr[i] * -1;
      boolean finish = false;

      while (start <= end) {
        int mid = (start + end) / 2;

        if (sum > Math.abs(arr[mid] + arr[i])) {
          answer[0] = arr[i];
          answer[1] = arr[mid];
          sum = Math.abs(arr[mid] + arr[i]);
        }
        
        if (arr[mid] < target) start = mid + 1;
        else if (arr[mid] > target) end = mid - 1;
        else {
          finish = true;
          break;
        }
      }

      if (finish) break;
    }

    for (int i = 0; i < 2; i++) {
      System.out.print(answer[i] + " ");
    }
  }
}