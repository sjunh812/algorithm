import java.util.*;

class Solution {
    
    ArrayList<ArrayList<Integer>> permList = new ArrayList<>(); // 순열 리스트
    
    public int solution(int n, int[] week, int[] dist) {
        int answer = -1;
        int[] newWeek = new int[week.length * 2];   // 외벽의 `원형`이기 때문에 길이가 2배인 `일자` 모형으로
        
        // 새로 만든 `일자` 모형의 취약 지점 배열내 값 채우기
        for (int i = 0; i < newWeek.length; i++) {
            if (i < week.length) newWeek[i] = week[i];
            else newWeek[i] = week[i - week.length] + n;
        }
        
        // 친구 별 이동 거리가 담긴 dist에 대한 순열
        perm(dist, new int[dist.length], new boolean[dist.length], 0, dist.length, dist.length);
        
        // 친구 별 이동 거리 순열에 대하여 완전 탐색
        for (int i = 0; i < week.length; i++) {
            for (int j = 0; j < permList.size(); j++) {
                ArrayList<Integer> candidate = permList.get(j); // 친구 별 이동 거리 순열 후보
                int start = i;  // 취약 지점 탐색 시작 위치
                
                for (int k = 0; k < candidate.size(); k++) {
                    int distance = candidate.get(k);    // 특정 친구의 이동 거리
                    int sum = 0;    // 탐색 중 이동한 거리
                    
                    while (start - i < week.length) {
                        int curWeek = newWeek[start];   // 현재 취약 지점
                        int nextWeek = newWeek[start + 1];  // 다음 취약 지점 
                        sum += nextWeek - curWeek;  // 취약 지점 사이 간 거리의 합
                        
                        if (sum >= distance) {  // 특정 친구에 대한 탐색 완료
                            if (sum == distance) start += 2;
                            else start += 1;
                            
                            break;
                        } else {
                            start++;
                        }
                    }
                    
                    if (start - i >= week.length) { // 순열 후보에 대한 탐색 완료
                        if (answer == -1 || answer > k) answer = k + 1;
                        break;
                    }
                }
            }
        }
        
        System.out.println(answer);
        return answer;
    }
    
    // 순열
    public void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {    
            ArrayList<Integer> list  = new ArrayList<>();
            
            for (int i = 0; i < output.length; i++) {
                list.add(output[i]);
            }
            
            permList.add(list);
            
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}   