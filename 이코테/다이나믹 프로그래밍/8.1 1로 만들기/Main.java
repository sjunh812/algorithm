import java.util.*;
import java.io.*;

class Main {

  public static int[] dp = new int[30001];
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int x = Integer.parseInt(br.readLine());

    // 다이나믹 프로그래밍(Dynamic Programing) 진행 (바텀업)
    for (int i = 2; i <= x; i++) {
      // 현재의 수에서 1을 빼는 경우
      dp[i] = dp[i - 1] + 1;
      // 현재의 수가 2로 나누어 떨어지는 경우
      if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
      // 현재의 수가 3으로 나누어 떨어지는 경우
      if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
      // 현재의 수가 5로 나누어 떨어지는 경우
      if (i % 5 == 0) dp[i] = Math.min(dp[i], dp[i / 5] + 1);
    }

    System.out.println(dp[x]);
    
    // System.out.println(bfs(x));
  }

  public int bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    Queue<Integer> depth = new LinkedList<>();
    q.offer(start);
    depth.offer(0);

    while (!q.isEmpty()) {
      int x = q.poll();
      int dep = depth.poll();
      
      if (x == 1) {
        return dep;
      }

      // 1. 5로 나누어떨어지면, 5로 나눈다.
      if (x % 5 == 0) {
        q.offer(x / 5);
        depth.offer(dep + 1);
      }
      // 2. 3으로 나누어떨어지면, 3으로 나눈다.
      if (x % 3 == 0) {
        q.offer(x / 3);
        depth.offer(dep + 1);
      }
      // 3. 2로 나누어떨어지면, 2로 나눈다.
      if (x % 2 == 0) {
        q.offer(x / 2);
        depth.offer(dep + 1);
      }
      // 4. 1을 뺀다.
      q.offer(x - 1);
      depth.offer(dep + 1);
    }

    return -1;
  }
}