import java.util.*;
import java.io.*;

// 첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 40, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절댓값은 100,000을 넘지 않는다.

class Main {

  int n, s;
  int[] arr = new int[40];
  ArrayList<Integer> leftList = new ArrayList<>();
  ArrayList<Integer> rightList = new ArrayList<>();
  long answer = 0;
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    setSubSquence(0, 0, n / 2, leftList);
    setSubSquence(0, n / 2, n, rightList);

    Collections.sort(leftList);
    Collections.sort(rightList);

    int left = 0;
    int right = rightList.size() - 1;

    while (left < leftList.size() && right >= 0) {
      int leftValue = leftList.get(left);
      int rightValue = rightList.get(right);
      int sum = leftValue + rightValue;

      if (sum == s) {
        long lCnt = 0;
        while (left < leftList.size() && leftList.get(left) == leftValue) {
          lCnt++;
          left++;
        }

        long rCnt = 0;
        while (right >= 0 && rightList.get(right) == rightValue) {
          rCnt++;
          right--;
        }
        
        answer += lCnt * rCnt;
      } else if (sum < s) {
        left++;
      } else {
        right--;
      }
    }

    if (s == 0) System.out.println(answer - 1);
    else System.out.println(answer);
  }
  
  public void setSubSquence(int sum, int start, int end, ArrayList<Integer> list) {
    if (start == end) {
      list.add(sum);
      return;
    }
    
    setSubSquence(sum, start + 1, end, list);
    setSubSquence(sum + arr[start], start + 1, end, list);
  }
}