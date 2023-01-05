import java.util.*;

class Solution {
    
    public int[] solution(String[] words, String[] queries) {
        String[] reverseWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            reverseWords[i] = new StringBuilder(words[i]).reverse().toString();
        }
        
        // 이분 탐색을 위해 정렬 수행
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) return s1.compareTo(s2);
                return s1.length() - s2.length();
            }
        });
        Arrays.sort(reverseWords, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) return s1.compareTo(s2);
                return s1.length() - s2.length();
            }
        });
        
        // '?'가 접두사나 점미사에 따라 가사 단어들을 바꿔가며 각각 이진 탐색 2회 수행
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = getMatchCount(words, reverseWords, queries[i]);
        }
        
        return result;
    }
    
    public int getMatchCount(String[] words, String[] reverseWords, String target) {
        String[] arr;   // 이진 탐색에 사용 할 배열
        if (target.charAt(0) == '?') {  // '?'가 접두사인 경우, 가사 단어 및 검색 키워드 역순
            arr = reverseWords; 
            target = new StringBuilder(target).reverse().toString();
        } else {
            arr = words;
        }
        
        int leftIndex = lowerBound(arr, target, 0, words.length - 1);
        int rightIndex = upperBound(arr, target, 0, words.length - 1);

        return rightIndex - leftIndex;
    }
    
    // 조건에 만족하는 최소 Index
    public int lowerBound(String[] words, String target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (check(words[mid], target) || compare(words[mid], target) > 0) end = mid - 1;
            else start = mid + 1;
        }
        
        return end;
    }
    
    // 조건에 만족하는 최대 Index
    public int upperBound(String[] words, String target, int start, int end) { 
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (check(words[mid], target) || compare(words[mid], target) < 0) start = mid + 1;
            else end = mid - 1;
        }
        
        return end;
    }
    
    // 매치 여부
    public boolean check(String word, String query) {
        if (word.length() != query.length()) return false;
        
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) != '?' && word.charAt(i) != query.charAt(i)) return false;
        }
        
        return true;
    }
    
    // 매치되지 않았을 때, 우선 순위 판별
    public int compare(String word, String query) {
        if (word.length() != query.length()) return word.length() - query.length();
        
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) != '?') {
                if (word.charAt(i) > query.charAt(i)) return 1;
                else if (word.charAt(i) < query.charAt(i)) return -1;
            }
        }
        
        return word.length() - query.length();
    }
}