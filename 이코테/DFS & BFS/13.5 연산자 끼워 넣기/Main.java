import java.util.*;
import java.io.*;

class Permutation {

  private int n;
  private int r;  
  private int[] now;
  private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

  public ArrayList<ArrayList<Integer>> getResult() {
    return this.result;
  }
  
  public Permutation(int n, int r) {
    this.n = n;
    this.r = r;
    this.now = new int[r];
  }

  public void permutation(int[] arr, int depth) {
    if (depth == r) {
      ArrayList<Integer> temp = new ArrayList<>();
      
      for (int i = 0; i < r; i++) {
        temp.add(now[i]);  
      }

      result.add(temp);
    }

    for (int i = depth; i < n; i++) {
      swap(arr, i, depth);
      now[depth] = arr[depth];
      permutation(arr, depth + 1);
      swap(arr, i, depth);
    }
  }

  public void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}

class Main {

  int n;  // 수의 개수
  int[] arr;  // n개의 수
  int[] oper;  // n-1개의 연산자
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    oper = new int[n - 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    int start = 0;
    for (int i = 0 ; i < 4; i++) {
      int cnt = Integer.parseInt(st.nextToken());

      for (int j = start; j < start + cnt; j++) {
        oper[j] = i;
        System.out.print(i + " ");
      }
  
      start += cnt;
    }
    System.out.println();

    // n-1개의 모든 연산자에 대한 순열계산
    Permutation p = new Permutation(n - 1, n - 1);
    p.permutation(oper, 0);
    ArrayList<ArrayList<Integer>> pr = p.getResult();
    System.out.println("Permutation result : " + pr);

    // 모든 연산에 대해 최대값과 최소값 계산
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < pr.size(); i++) {
      int result = arr[0];
      
      for (int j = 0; j < pr.get(i).size(); j++) {
        result = calculate(pr.get(i).get(j), result, arr[j + 1]);
      }

      max = Math.max(max, result);
      min = Math.min(min, result);
    }

    System.out.println(max);
    System.out.println(min);
  }

  public int calculate(int oper, int a, int b) {
    if (oper == 0) {  // 덧셈
      return a + b;
    }

    if (oper == 1) {  // 뺄셈
      return a - b;
    }

    if (oper == 2) {  // 곱셈
      return a * b;
    }

    if (oper == 3) {  // 나눗셈
      if (a < 0) {
        return (a * -1 / b) * -1;
      } else {
        return a / b;
      }
    }

    return -1;
  }
}