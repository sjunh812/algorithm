import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution("xababcdcdababcdcd");  // answer = 17
  }

  public int solution(String s) {
    int answer = s.length();

    for (int step = 1; step < s.length() / 2 + 1; step++) {
      String compressed = "";
      String prev =  s.substring(0, step);  // 앞에서부터 step 만큼의 문자열 추출
      int cnt = 1;
      // 단위(step) 크기만큼 증가시키며 이전 문자열과 비교
      for (int j = step; j < s.length(); j += step) {
        // 이전 상태와 동일하다면 압축 횟수(cnt) 증
        String sub = "";
        for (int k = j; k < j + step; k++) {
          if (k < s.length()) sub += s.charAt(k);
        }
        if (prev.equals(sub)) cnt++;
        // 다른 문자열이 나왔다면(더 이상 압축하지 못하는 경우라면)
        else {
          compressed += (cnt >= 2) ? cnt + prev : prev;
          sub = "";
          for (int k = j; k < j + step; k++) {
            if (k < s.length()) sub += s.charAt(k);
          }
          prev = sub;  // 다시 상태 초기화
          cnt = 1;
        }
      }

      // 남아있는 문자열에 대해서 처리
      compressed += (cnt >= 2) ? cnt + prev : prev;
      // 만들어지는 압축 문자열이 가장 짧은 것이 정답 
      answer = Math.min(answer, compressed.length());
    }

    System.out.println(answer);
    
    return answer;
  }

  public int mySolution(String s) {
        int answer = 1001;
        
        // 문자열 길이가 1 일때
        if (s.length() == 1) return 1;
        
        // 문자열을 자를 수 있는 모든 길이 단위 탐색
        // 문자열 절반 이상의 길이 단위는 의미없음.
        for (int unit = 1; unit <= s.length() / 2; unit++) {
            int i = 0;  // 문자열 탐색 시작 index
            int cnt = 0;    // 해당 단위로 압축 시 나오는 결과 값(압축된 문자열의 길이)
            String last = s.substring(i, i + unit); // 단위로 자른 마지막 문자열
            String result = ""; // 압축된 문자열
            
            while (i < s.length()) {
                String current; // 단위에 맞게 자른 현재 문자열
                if (i + unit > s.length()) current = s.substring(i, s.length()); 
                else current = s.substring(i, i + unit);
                
                if (last.equals(current)) {
                    cnt++;
                } else {
                    if (cnt > 1) result += (cnt + last);
                    else result += last;
                    
                    cnt = 1;
                }
                
                if (i + unit >= s.length()) {
                    if (cnt > 1) result += (cnt + current);
                    else result += current;
                }
                
                last = current;
                i += unit;
            }
            
            if (answer > result.length()) answer = result.length();
        }

        System.out.println(answer);
        
        return answer;
    }
}