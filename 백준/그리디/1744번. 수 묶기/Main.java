import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());  // 수열의 길이
    int[] arr = new int[n];  // 수열

    // 수열 입력 받기
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    // 수열 정렬
    // 정렬 우선순위 1. 크기 내림차순 2. 모두 음수(0포함)인 경우 절댓값 기준 내림차순 
    Integer[] boxedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
    Arrays.sort(boxedNums, new Comparator<Integer>() {
      @Override
      public int compare(Integer i1, Integer i2) {
        if (i1 <= 0 && i2 <= 0) return Math.abs(i2) - Math.abs(i1);
        else return i2 - i1;
      }
    });

    long result = 0;

    // 정렬된 수열을 차례대로 확인
    for (int i = 0; i < boxedNums.length; i++) {
      int first = boxedNums[i];
      
      if (i == boxedNums.length - 1) {
        // 마지막 원소의 경우 = 더하기 연산
        result += first;
      } else {
        int second = boxedNums[i + 1];

        if ((first > 1 && second > 1) || (first < 0 && second < 0) || (first < 0 && second == 0) {
          // 곱하기 연산
          // 1. 두 수가 모두 1보다 큰 양수일 때
          // 2. 두 수가 모두 음수일 때
          // 3. 첫 번째 수는 음수, 두 번째 수는 0일 때
          result += first * second;
          i++;  // 두 수를 비교했기 때문에 2만큼 건너뛰기
        } else {
          // 나머지 경우 = 더하기 연산
          result += first;
        }
      }
    }

    System.out.println(result);
  }
}