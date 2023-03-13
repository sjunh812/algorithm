import java.util.*;
import java.io.*;

class Main {

  int n, m;
  int[] lessons = new int[100001];

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    int left = 0;
    int right = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      lessons[i] = Integer.parseInt(st.nextToken());
      left = Math.max(left, lessons[i]);
      right += lessons[i];
    }
    
    while (left <= right) {
      int mid = (left + right) / 2;
    
      if (m >= getBlueRayCount(mid)) right = mid - 1;
      else left = mid + 1;
    }

    System.out.println(left);
  }

  public int getBlueRayCount(int size) {
    int count = 0;
    int sum = 0;
    
    for (int lesson : lessons) {
      if (sum + lesson > size) {
        count++;
        sum = 0;
      }
      
      sum += lesson;
    }

    if (sum > 0) count++;

    return count;
  }
}