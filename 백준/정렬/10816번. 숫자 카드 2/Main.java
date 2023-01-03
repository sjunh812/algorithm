import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());  // 숫자 카드의 개수

    Map<Integer, Integer> map = new HashMap<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int card = Integer.parseInt(st.nextToken());
      if (map.containsKey(card)) map.replace(card, map.get(card) + 1);
      else map.put(card, 1);
    }

    int m = Integer.parseInt(br.readLine());  // 확인할 수들의 개수
    int[] arr = new int[m]; 
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < m; i++) {
      int num = arr[i];
      if (map.containsKey(num)) bw.write(String.valueOf(map.get(num)));
      else bw.write(String.valueOf(0));
      bw.write(" ");
    }

    bw.flush();
  }
}
