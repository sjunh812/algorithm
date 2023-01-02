import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    
    Integer[] arr = new Integer[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine()); 
    }

    Arrays.sort(arr, Collections.reverseOrder());

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}