import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  int n;  
  int m;
  int k;
  Integer[] nums;
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void mySolution() throws Exception {
    input();

    // Integer[] numsTmp = Arrays.stream(nums).boxed().toArray(Integer[]::new);
    Arrays.sort(nums, Comparator.reverseOrder());

    int result = 0;
    
    if (nums[0] == nums[1]) {
      result = nums[0] * m;
    } else {
      int remain = m % (k + 1);
      result = nums[0] * k * m / (k + 1) + nums[1] * m / (k + 1) + nums[0] * remain;
    }

    System.out.println(result);
  }

  public void solution() throws Exception {
    input();

    Arrays.sort(nums);  // 오름차순

    int first = nums[n - 1];  // 가장 큰 수
    int second = nums[n - 2];  // 두 번째로 큰 수
    
    // 가장 큰 수가 더해지는 횟수 계산
    int cnt = (m / (k + 1)) * k;
    cnt += m % (k + 1);

    int result = 0;
    result += cnt * first;  // 가장 큰 수 더하기
    result += (m - cnt) * second;  // 두 번째로 큰 수 더하기

    System.out.println(result);
  }
  
  public void input() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    StringTokenizer st2 = new StringTokenizer(br.readLine());
    nums = new Integer[n];
    
    for(int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(st2.nextToken());  
    }
  }
}