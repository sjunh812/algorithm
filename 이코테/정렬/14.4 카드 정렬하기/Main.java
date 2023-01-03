import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    // 힙(Heap)에 초기 카드 묶음을 모두 삽입
    for (int i = 0; i < n; i++) {
      pq.offer(Integer.parseInt(br.readLine()));
    }

    int result = 0;
    while (pq.size() != 1) {
      // 가장 작은 2개의 카드 묶음 꺼내기
      int one = pq.poll();
      int two = pq.poll();
      // 카드 묶음을 합쳐서 다시 삽입
      int sum = one + two;
      result += sum;
      pq.offer(sum);
    }

    System.out.println(result);
  }
}