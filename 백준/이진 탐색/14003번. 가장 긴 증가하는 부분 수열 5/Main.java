import java.util.*;
import java.io.*;

class Main {

  int[] arr;
  int[] path;
  ArrayList<Integer> list = new ArrayList<>();
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    arr = new int[n];
    path = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; i++) {
      if (list.isEmpty() || list.get(list.size() - 1) < arr[i]) {
        list.add(arr[i]);
        path[i] = list.size() - 1;
      } else {
        binarySearch(i);
      }
    }

    Stack<Integer> stack = new Stack<>();
    int index = list.size() - 1;
    
    for (int i = n - 1; i >= 0; i--) {
      if (path[i] == index) {
        stack.push(arr[i]);
        index--;
      }
    }

    bw.write(list.size() + "\n");
    while (!stack.isEmpty()) {
      bw.write(stack.pop() + " ");
    }

    bw.flush();
    bw.close();
    br.close();
  }

  public void binarySearch(int index) {
    int target = arr[index];
    int left = 0;
    int right = list.size() - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (list.get(mid) < target) left = mid + 1;
      else right = mid - 1;
    }

    list.set(left, target);
    path[index] = left;
  }
}