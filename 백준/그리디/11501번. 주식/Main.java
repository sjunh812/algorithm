import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());

    for (int tc = 0; tc < t; tc++) {
      int n = Integer.parseInt(br.readLine());

      int[] arr = new int[n];                      
      PriorityQueue<Stock> pq = new PriorityQueue<>();
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0 ; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
        pq.offer(new Stock(i, arr[i]));
      }

      int start = 0;
      int lastIndex = -1;
      long answer = 0;

      while (!pq.isEmpty()) {
        Stock s = pq.poll();
        int index = s.getIndex();
        int stock = s.getStock();

        if (lastIndex < index) {
          lastIndex = index;

          for (int i = start; i < index; i++) {
            answer += (stock - arr[i]);
          }
          
          start = index + 1;
          if (start >= n - 1) break;
        }
      }

      bw.write(String.valueOf(answer));
      bw.write("\n");
    }

    bw.flush();
    bw.close();
  }
}

class Stock implements Comparable<Stock> {

  private int index;
  private int stock;

  public Stock(int index, int stock) {
    this.index = index;
    this.stock = stock;
  }

  public int getIndex() {
    return this.index;
  }

  public int getStock() {
    return this.stock;
  }

  @Override
  public int compareTo(Stock other) {
    if (other.stock == this.stock) return this.index - other.index;
    return other.stock - this.stock;
  }
}