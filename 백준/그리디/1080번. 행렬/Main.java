import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

  public static void main(String[] args) throws Exception {
    System.out.println(new Main().solution());
  }

  private int solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] a = new int[n][m];
    int[][] b = new int[n][m];

    
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      
      for (int j = 0; j < m; j++) {
        a[i][j] = line.charAt(j) - '0';
      }
    }

    for (int i = 0; i < n; i++) {
      String line = br.readLine();
       
      for (int j = 0; j < m; j++) {
        b[i][j] = line.charAt(j) - '0';
      }
    }

    int result = 0;

    for (int i = 0; i < n - 2; i++) {
      for (int j = 0; j < m - 2; j++) {
         if (a[i][j] == b[i][j]) continue;
        
          swap(a, i, j); 
          result++;
        
          if (a[i][j] != b[i][j]) return -1;
       }
    }

    for (int i = 0; i < n; i++) {      
      for (int j = 0; j < m; j++) {
        if (a[i][j] != b[i][j]) return -1;
      }
    }
      
    return result;
  }

  private void swap(int[][] arr, int n, int m) {
    for (int i = n; i < n + 3; i++) {
      for (int j = m; j < m + 3; j++) {
        if (arr[i][j] == 0) arr[i][j] = 1;
        else arr[i][j] = 0;
      }
    }
  } 
}