import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    
    st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int count = 0;
    int intervalSum = 0;
    int end = 0;
    for (int start = 0; start < n; start++) {
      // end를 가능한 만큼 이동
      while (intervalSum < m && end < n) {
        intervalSum += arr[end++];
      }

      // 부분합이 m
      if (intervalSum == m) count++;

      intervalSum -= arr[start];
    }

    System.out.println(count);
  }
}