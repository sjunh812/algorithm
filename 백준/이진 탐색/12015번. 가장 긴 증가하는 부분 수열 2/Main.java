import java.util.*;
import java.io.*;

class Main {
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int value = arr[i];
      
      if (list.isEmpty() || list.get(list.size() - 1) < value) list.add(value);
      else binarySearch(list, value, 0, list.size() - 1);
    }

    System.out.println(list.size());
  }

  public void binarySearch(ArrayList<Integer> list, int target, int start, int end) {
    while (start <= end) {
      int mid = (start + end) / 2;

      if (list.get(mid) > target) end = mid - 1;
      else if (list.get(mid) < target) start = mid + 1;
      else return;
    }

    list.set(start, target);
  }
}