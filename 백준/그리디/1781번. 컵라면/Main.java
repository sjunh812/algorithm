import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    Problem[] arr = new Problem[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int deadLine = Integer.parseInt(st.nextToken());
      long ramenCount = Long.parseLong(st.nextToken());
      arr[i] = new Problem(deadLine, ramenCount);
    }

    Arrays.sort(arr);

    PriorityQueue<Long> pq = new PriorityQueue<>();
    int curDeadLine = 1; 
    for (int i = 0; i < n; i++) {
      int deadLine = arr[i].getDeadLine();
      long ramenCount = arr[i].getRamenCount();

      if (pq.isEmpty() || curDeadLine <= deadLine) {
        pq.offer(ramenCount);
        curDeadLine++;
      } else {
        long min = pq.peek();
        if (min < ramenCount) {
          pq.poll();
          pq.offer(ramenCount);
        } 
      } 
    }

    long answer = 0;
    while (!pq.isEmpty()) {
      answer += pq.poll();
    }
    System.out.println(answer);
  }
}

class Problem implements Comparable<Problem> {

  private int deadLine;
  private long ramenCount;

  public Problem(int deadLine, long ramenCount) {
    this.deadLine = deadLine;
    this.ramenCount = ramenCount;
  }

  public int getDeadLine() {
    return this.deadLine;
  }

  public long getRamenCount() {
    return this.ramenCount;
  }

  @Override
  public int compareTo(Problem other) {
    if (this.deadLine == other.deadLine) return Long.compare(other.ramenCount, this.ramenCount);
    return Integer.compare(this.deadLine, other.deadLine);
  }
}