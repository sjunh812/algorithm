import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());  // 테스트 케이스의 개수

    for (int i = 0; i < t; i++) {
      String p = br.readLine();  // 수행할 함수
      int n = Integer.parseInt(br.readLine());  // 배열의 길이
      String arrStr = br.readLine();  // 배열(ex) [1,2,3])
      String[] arr = arrStr.substring(1, arrStr.length() - 1).split(",");  // 실제 배열
      
      Deque<String> list = new ArrayDeque<String>();
      for (int j = 0; j < arr.length; j++) {
        if (!arr[j].isEmpty()) list.add(arr[j]);
      }

      String result = "";
      boolean reverse = false;

      for (int j = 0; j < p.length(); j++) {
        char function = p.charAt(j);

        if (function == 'R') {
          if (!list.isEmpty()) reverse = !reverse;
        }
        
        if (function == 'D') {
          if (list.isEmpty()) {
            result = "error";
            break;
          }

          if (reverse) list.removeLast();
          else list.removeFirst();
        }
      }

      if (result.equals("error")) {
        bw.write(result);
        bw.write("\n");
        continue;
      }
      
      Iterator it;
      if (reverse) it = list.descendingIterator();
      else it = list.iterator();

      bw.write("[");
      while (it.hasNext()) {
        bw.write(String.valueOf(it.next()));
        if (it.hasNext()) bw.write(",");
      }
      bw.write("]");
      bw.write("\n");
    }

    bw.flush();
  }
}