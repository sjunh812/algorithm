import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] a = new int[n];
    int[] b = new int[n];
    int[] c = new int[n];
    int[] d = new int[n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      a[i] = Integer.parseInt(st.nextToken());
      b[i] = Integer.parseInt(st.nextToken());
      c[i] = Integer.parseInt(st.nextToken());
      d[i] = Integer.parseInt(st.nextToken());
    }

    long[] ab = new long[n * n];
    long[] cd = new long[n * n];

    int index = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        ab[index] = a[i] + b[j];
        cd[index++] = c[i] + d[j];
      }
    }

    Arrays.sort(ab);
    Arrays.sort(cd);

    long result = 0;
    for (int i = 0; i < ab.length; i++) {
      long target = ab[i] * -1;
      result += getCount(cd, target);
    }

    System.out.println(result);
  }

  public int getCount(long[] arr, long target) {
    int leftValue = lowerBound(arr, target, 0, arr.length - 1);
    int rightValue = upperBound(arr, target, 0, arr.length - 1);
    
    return rightValue - leftValue;
  }
  
  public int lowerBound(long[] arr, long target, int start, int end) {
    while (start <= end) {
      int mid = (start + end) / 2;

      if (arr[mid] >= target) end = mid - 1;
      else start = mid + 1;
    }

    return end;
  }
  
  public int upperBound(long[] arr, long target, int start, int end) {
    while (start <= end) {
      int mid = (start + end) / 2;

      if (arr[mid] > target) end = mid - 1;
      else start = mid + 1;
    }

    return end;
  }
}