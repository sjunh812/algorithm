import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // N과 K를 입력받기 
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Integer[] a = new Integer[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    Integer[] b = new Integer[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(a);  // 배열 A는 오름차순 정렬
    Arrays.sort(b, Collections.reverseOrder());  // 배열 B는 내림차순 정렬

    for (int i = 0; i < k; i++) {
      if (a[i] < b[i]) {
        int temp = a[i];
        a[i] = b[i];
        b[i] = temp;
      } else {  
        break;
      }
    }

    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += a[i];
    }

    System.out.println(sum);
  }
}