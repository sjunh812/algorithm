import java.util.*;
import java.io.*;

class Main2 {

  int n;  // 연산을 수행하고자 하는 수의 개수
  int[] arr;  // 연산을 수행하고자 하는 수의 배열

  // 덧셈, 뺄셈, 곱셈, 나눗셈 연산자 개수
  int add;
  int sub;
  int mul;
  int div;

  // 최댓값과 최솟값
  int max = Integer.MIN_VALUE;
  int min = Integer.MAX_VALUE;
  
  public static void main(String[] args) throws Exception {
    new Main2().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    n = Integer.parseInt(br.readLine());
    arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    add = Integer.parseInt(st.nextToken());
    sub = Integer.parseInt(st.nextToken());
    mul = Integer.parseInt(st.nextToken());
    div = Integer.parseInt(st.nextToken());

    // DFS 메소드 호출
    dfs(1, arr[0]);

    // 최댓값과 최솟값 차례대로 출력
    System.out.println(max);
    System.out.println(min);
  }

  private void dfs(int depth, int result) {
    // 모든 연산자를 다 사용한 경우, 최댓값과 최솟값 업데이트
    if (depth == n) {  
      max = Math.max(max, result);
      min = Math.min(min, result);
      return;
    }

    // 각 연산자에 대하여 재귀적으로 수행
    if (add > 0) {
      add--;
      dfs(depth + 1, result + arr[depth]);
      add++;
    }

    if (sub > 0) {
      sub--;
      dfs(depth + 1, result - arr[depth]);
      sub++;
    }

    if (mul > 0) {
      mul--;
      dfs(depth + 1, result * arr[depth]);
      mul++;
    }

    if (div > 0) {
      div--;
      dfs(depth + 1, result / arr[depth]);
      div++;
    }
  }
}