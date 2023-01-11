import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());  // 삼각형의 크기
    
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();  // 삼각형의 정보
    ArrayList<ArrayList<Integer>> dp = new ArrayList<>();  // 다이나믹 프로그래밍 DP 테이블
    
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      ArrayList<Integer> subList = new ArrayList<>();
      ArrayList<Integer> subDp = new ArrayList<>();
      
      for (int j = 0; j <= i; j++) {
        int value = Integer.parseInt(st.nextToken());
        subList.add(value);
        subDp.add(value);
      }

      list.add(subList);
      dp.add(subDp);
    }

    // 다이나믹 프로그래밍(바텀업)
    for (int i = 1; i < dp.size(); i++) {
      for (int j = 0; j < dp.get(i).size(); j++) {
        int max = 0;
        
        if (j == 0) max = dp.get(i - 1).get(0);
        else if (j == dp.get(i).size() - 1) max = dp.get(i - 1).get(dp.get(i - 1).size() - 1);
        else max = Math.max(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j));

        dp.get(i).set(j, list.get(i).get(j) + max);
      }
    }

    int result = 0;
    for (int i = 0; i < dp.get(n - 1).size(); i++) {
      result = Math.max(result, dp.get(n - 1).get(i));
    }

    System.out.println(result);
  }
}