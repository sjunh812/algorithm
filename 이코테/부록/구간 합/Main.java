import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int n = Integer.parseInt(br.readLine());  

    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 접두사 합(Prefix Sum) 배열 계산
    int[] prefix = new int[n + 1];
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += arr[i - 1];
      prefix[i] = sum;
    }

    int q = Integer.parseInt(br.readLine());  // 쿼리의 개수

    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int left = Integer.parseInt(st.nextToken());
      int right = Integer.parseInt(st.nextToken());

      // 구간 합 계산
      bw.write((prefix[right] - prefix[left - 1]) + "\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }
}