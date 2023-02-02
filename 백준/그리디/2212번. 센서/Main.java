import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());  // 센서 수
    int k = Integer.parseInt(br.readLine());  // 집중국 수

    // 센서의 위치를 입력 받기
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);  // 센서간 간격을 구하기 위해 오름차순 정렬

    Integer[] intervals = new Integer[n - 1];  // 한 칸씩 센서 간격을 담은 배열
    for (int i = 0; i < n - 1; i++) {
      intervals[i] = arr[i + 1] - arr[i];
    }

    // 한 칸씩 센서 간격을 담은 배열을 내림차순 정렬
    Arrays.sort(arr, Collections.reverseOrder());

    // k개의 집중국을 설치하면, k - 1개의 센서 간격을 건너뛸 수 있다!
    // 따라서 내림차순 정렬한 배열에서 k - 1개를 제외한 값을 더하면 됨.
    int answer = 0;
    for (int i = k - 1; i < n - 1; i++) {
      answer += intervals[i];
    }
    
    System.out.println(answer);
  }
}