import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] fears = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n ; i++) {
      fears[i] = Integer.parseInt(st.nextToken());
    }

    int result = 0;  // 총 그룹의 수
    int count = 0;  // 현재 그룹에 포함된 모험가 수

    for (int i = 0; i < n; i++) {  // 공포도 낮은 것부터 하나씩 확인하며
      count++;  // 현재 그룹에 해당 모험가를 포함시키기

      int fear = fears[i];

      if (fear <= count) {  // 현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면, 그룹 결성
        result++;  // 총 그룹 수 증가시키기
        count = 0;  // 현재 그룹에 포함된 모험가의 수 초기화
      }
    }

    System.out.println(result);
  }
  
  private void mySolution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] fears = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      fears[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(fears);

    int i = 0;
    int result = 0;
    
    while (true) {      
      int fear = fears[i];
      int next = i + fear;
      int j = i + 1;
      
      if (next > n) break;
      
      for (; j < i + fear; j++) {
        if (fear < fears[j]) {
          next = j;
          break;
        }
      }
      
      if (next == i + fear) result++;
      
      i = next;
    }
    
    System.out.println(result);
  }
}