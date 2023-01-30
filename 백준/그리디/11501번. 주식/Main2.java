import java.util.*;
import java.io.*;

class Main2 {

  public static void main(String[] args) throws Exception {
    new Main2().solution();
  }

  public void solution2() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());

    for (int tc = 0; tc < t; tc++) {
      int n = Integer.parseInt(br.readLine());

      int[] arr = new int[n];
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0 ; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      int max = arr[n - 1];
      long answer = 0;
      
      for (int i = n - 2; i >= 0; i--) {
        if (max <= arr[i]) {
          max = arr[i];
          continue;
        }

        answer += (max - arr[i]);
      }

      bw.write(String.valueOf(answer));
      bw.write("\n");
    }

    bw.flush();
    bw.close();
  }
}