import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());  // 가게 부품의 개수

    // 가게 부품의 번호를 입력받기
    int[] store = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      store[i] = Integer.parseInt(st.nextToken());
    }

    int m = Integer.parseInt(br.readLine());  // 손님이 문의한 부품의 개수

    // 손님이 문의한 부품의 번호를 입력받기
    int[] customer =  new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0 ; i < m; i++) {
      customer[i] = Integer.parseInt(st.nextToken());
    }

    // 이진 탐색을 위해 가게 부품의 번호 배열을 정렬
    Arrays.sort(store);

    // 손님이 문의한 부품의 번호를 순차 탐색하며, 해당 부품의 번호가 가게에 있는지 이진 탐색
    for (int i = 0; i < m; i++) {
      if (binarySearch(store, customer[i], 0, n - 1)) bw.write("yes ");
      else bw.write("no ");
    }

    bw.flush();
    bw.close();
  }

  // 이진 탐색 (재귀)
  public boolean binarySearch(int[] arr, int target, int start, int end) {
    if (start > end) return false;

    int mid = (start + end) / 2;  // 중간 값

    // 타겟을 찾음.
    if (arr[mid] == target) return true;  
    // 중간 값보다 타겟이 더 작은 범위
    else if (arr[mid] > target) return binarySearch(arr, target, start, mid - 1); 
    // 중간 값보다 타겟이 더 큰 범위
    else return binarySearch(arr, target, mid + 1, end);  
  }
}