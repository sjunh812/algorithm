import java.util.*;
import java.io.*;

class Main {
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    boolean[] check = new boolean[n + 1];
    Arrays.fill(check, true);
    check[0] = false;
    check[1] = false;
    
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (check[m]) {
        int j = 2;
        while (i * j <= n) {
          check[i * j] = false;
          j++;
        }
      }
    }

    for (int i = m; i <= n; i++) {
      if (check[i]) bw.write(i + "\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
