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
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }

    int i = 0;
    int j = 0;
    int k = 0;
    int[] result = new int[n + m];
  
    while (i < n || j < m) {
      if (j >= m || (i < n && a[i] <= b[j])) { 
        // 리스트 B의 모든 원소가 처리되었거나, 리스트 A의 원소가 더 적을 때
        result[k] = a[i];
        i++;
      } else { 
        // 리스트 A의 모든 원소가 처리되었거나, 리스트 B의 원소가 더 적을 때
        result[k] = b[j];
        j++;
      }
      
      k++;
    }

    // 결과 출력
    for (int x : result) {
      System.out.print(x + " ");
    }
  }
}