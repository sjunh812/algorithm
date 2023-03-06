import java.util.*;
import java.io.*;

class Main {

  long n, k;

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Long.parseLong(br.readLine());
    k = Long.parseLong(br.readLine());

    System.out.println(binarySearch(1, n * n));
  }

  public long binarySearch(long start, long end) {
    long answer = 0;
    long left = start;
    long right = end;

    while (left <= right) {
      long mid = (left + right) / 2;

      if (getCount(mid) < k) {
        left = mid + 1;
      } else {
        answer = mid;
        right = mid - 1;
      }
    }

    return answer;
  }

  public long getCount(long x) {
    long count = 0;
    
    for (int i = 1; i <= n; i++) {
      count += Math.min(x / i, n);  
    }

    return count;
  }
}