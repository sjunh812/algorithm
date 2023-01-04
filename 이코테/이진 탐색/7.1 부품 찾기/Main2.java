import java.util.*;
import java.io.*;

public class Main2 {

  public static void main(String[] args) throws Exception {
    new Main2().solution1();
    new Main2().solution2();
    new Main2().solution3();
  }

  // 해결 방법 1 : 이진 탐색
  public void solution1() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // N (가게의 부품 개수)
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 이진 탐색을 수행하기 위해 사전에 정렬 수행
    Arrays.sort(arr);

    // M (손님이 확인 요청한 부품 개수)
    int m = Integer.parseInt(br.readLine());
    int[] targets = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      targets[i] = Integer.parseInt(st.nextToken());
    }

    // 손님이 확인 요청한 부품을 하나씩 확인
    for (int i = 0; i < m; i++) {
      // 해당 부품이 존재하는지 확인
      int result = binarySearch(arr, targets[i], 0, n - 1);
      if (result != -1) bw.write("yes ");
      else bw.write("no ");
    }

    bw.flush();
    bw.close();
  }

  public int binarySearch(int[] arr, int target, int start, int end) {
    while (start <= end) {
      int mid = (start + end) / 2;

      // 찾은 경우 중간점 인덱스 반환
      if (arr[mid] == target) return mid;
      // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
      else if (arr[mid] > target) end = mid - 1;
      // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
      else start = mid + 1;
    }

    return -1;
  }
  
  // 해결 방법 2 : 계수 정렬
  public void solution2() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // N (가게의 부품 개수)
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[1000001];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(st.nextToken());
      arr[x] = 1;
    }

    // M (손님이 확인 요청한 부품 개수)
    int m = Integer.parseInt(br.readLine());
    int[] targets = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      targets[i] = Integer.parseInt(st.nextToken());
    }

    // 손님이 확인 요청한 부품을 하나씩 확인
    for (int i = 0; i < m; i++) {
      // 해당 부품이 존재하는지 확인
      if (arr[targets[i]] == 1) bw.write("yes ");
      else bw.write("no ");
    }

    bw.flush();
    bw.close();
  }

  // 해결 방법 3 : 집합(Set)
  public void solution3() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // N (가게의 부품 개수)
    int n = Integer.parseInt(br.readLine());
    // 집합(Set) 정보를 처리하기 위한 HashSet 라이브러리
    Set<Integer> s = new HashSet<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(st.nextToken());
      s.add(x);
    }

    // M (손님이 확인 요청한 부품 개수)
    int m = Integer.parseInt(br.readLine());
    int[] targets = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      targets[i] = Integer.parseInt(st.nextToken());
    }

    // 손님이 확인 요청한 부품을 하나씩 확인
    for (int i = 0; i < m; i++) {
      // 해당 부품이 존재하는지 확인
      if (s.contains(targets[i])) bw.write("yes ");
      else bw.write("no ");
    }

    bw.flush();
    bw.close();
  }
}