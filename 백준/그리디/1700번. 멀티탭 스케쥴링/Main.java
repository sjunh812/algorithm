import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st1.nextToken());  // 멀티탭 구멍의 개수
    int k = Integer.parseInt(st1.nextToken());  // 전기용품의 총 사용횟수
    int[] arr = new int[k];  // 전기용품 사용순서
    int[] cnt = new int[k + 1];  // 전기용품 별 사용횟수
    
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) {
      arr[i] = Integer.parseInt(st2.nextToken());
      cnt[arr[i]]++;
    }

    int[] used = new int[k + 1];  // 현재의 전기용품 별 사용여부
    int remain = n;  // 현재 남은 멀티탭 구멍의 개수
    int result = 0;  // 플러그를 빼는 횟수(결과 값)
    HashSet<Integer> set = new HashSet<>();  // 꽂힌 모든 전기용품이 앞으로 다시 사용될 때, 중복판별 할 HashSet
    
    for (int i = 0; i < k; i++) {
      if (used[arr[i]] == 0) {  // 전기용품이 사용 중이지 않을 때
        if (remain > 0) {  // 남은 멀티탭 구멍이 존재할 때
          remain--; 
        } else {  // 남은 멀티탭 구멍이 없을 때 → 우선순위에 따라 판별
          boolean flag = false;

          // 1. 꽂힌 전기용품이 뒤에서 한번도 사용되지 않는 경우
          for (int j = 1; j <= k; j++) {
            if (used[j] == 1 && cnt[j] == 0) {  // 현재 사용 중 + 남은 사용횟수 0회
              flag = true;
              used[j] = 0;
              result++;
              
              break;
            }
          }

          // 2. 꽂힌 전기용품이 뒤에서 한번씩은 사용되는 경우
          if (!flag) {          
            int removeIndex = 0;  // 마지막으로 사용되는 전기용품의 종류(번호)
            
            for (int j = i + 1; j < k; j++) {
              if (used[arr[j]] == 1) {
                set.add(arr[j]);  // HashSet을 이용해 중복처리
                removeIndex = arr[j];  // 마지막 사용될 전기용품의 종류를 갱신
              }
              
              if (set.size() == n) {  // 꽂힌 전기용품의 종류를 뒤에서 모두 한번씩 탐색완료
                set.clear();
                break;
              }
            }
  
            used[removeIndex] = 0;  // 마지막 사용될 전기용품을 플러그에서 뺀다.
            result++;
          }
        }
      }

      used[arr[i]] = 1;  // 현재 전기용품 사용여부 갱신 → 사용 중
      cnt[arr[i]]--;  // 해당 전기용품의 총 사용횟수 차감
    }
      
    System.out.println(result);
  }
}