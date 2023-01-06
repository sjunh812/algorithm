import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int k = Integer.parseInt(st.nextToken());  // 이미 가지고 있는 랜선의 개수
    int n = Integer.parseInt(st.nextToken());  // 필요한 랜선의 개수

    // 이미 가지고 있는 랜선의 길이 배열 입력받기
    int[] arr = new int[k];
    for (int i = 0; i < k; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    // 이진 탐색을 위한 정렬 수행
    Arrays.sort(arr);
    
    double start = 1;
    double end = Integer.MAX_VALUE;
    double max = 0;
    
    while (start <= end) {
      double mid = (start + end) / 2;

      if (getCount(arr, mid) >= n) {
        start = mid + 1;
        max = Math.max(max, mid);
      } else {
        end = mid - 1;
      }
    }

    System.out.println((int) max);
  }

  public int getCount(int[] arr, double length) {
    int cnt = 0;

    for (int i = 0; i < arr.length; i++) {
      cnt += (int) (arr[i] / length); 
    }

    return cnt;
  }
}