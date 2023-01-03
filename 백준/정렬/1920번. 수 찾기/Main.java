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
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    int m = Integer.parseInt(br.readLine());
    
    st = new StringTokenizer(br.readLine());
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(a);

    for (int i = 0; i < m; i++) {
      int bb = b[i];
      if (midSearch(a, 0, n - 1, bb)) bw.write(String.valueOf(1));
      else bw.write(String.valueOf(0));
      bw.write("\n");
    }

    bw.flush();
  }

  public boolean midSearch(int[] arr, int start, int end, int find) {
    if (start > end) return false;
    
    int mid = (start + end) / 2;
    
    if (arr[mid] == find) return true;
    else if (arr[mid] > find) return midSearch(arr, start, mid - 1, find);
    else return midSearch(arr, mid + 1, end, find);
  }
}

