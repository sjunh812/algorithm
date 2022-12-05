import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int result = 0;

    if (n == 1) {
      result = 1;
    } else if (n == 2) {
      result = (m - 1) / 2 + 1; 
      if (result > 4) result = 4;
    } else {
      if (m < 7) {
        result = m;
        if (result > 4) result = 4;
      } else {
        result = m - 2;
      }
    }

    System.out.println(result);
  }
}