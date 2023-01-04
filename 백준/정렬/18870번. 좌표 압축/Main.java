import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    Node[] arr = new Node[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = new Node(i, Integer.parseInt(st.nextToken()));
    }

    Arrays.sort(arr);

    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        result[arr[i].getIndex()] = 0;
      } else if (arr[i - 1].getNumber() == arr[i].getNumber()) {
        result[arr[i].getIndex()] = result[arr[i - 1].getIndex()];
      } else {
        result[arr[i].getIndex()] = result[arr[i - 1].getIndex()] + 1;
      }
    }

    for (int i = 0; i < n; i++) {
      bw.write(String.valueOf(result[i]));
      bw.write(" ");
    }

    bw.flush();
    bw.close();
  }
}

class Node implements Comparable<Node> {

  private int index;
  private int number;

  public Node(int index, int number) {
    this.index = index;
    this.number = number;
  }

  public int getIndex() {
    return this.index;
  }

  public int getNumber() {
    return this.number;
  }

  @Override
  public int compareTo(Node other) {
    return this.number - other.number;
  }
}