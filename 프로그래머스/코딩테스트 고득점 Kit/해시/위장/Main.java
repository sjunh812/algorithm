import java.util.*;

class Solution {
    
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String[] cloth : clothes) {
            if (hashMap.containsKey(cloth[1])) hashMap.put(cloth[1], hashMap.get(cloth[1]) + 1);
            else hashMap.put(cloth[1], 1);
        }
   
        int answer = 1;
        for (int value : hashMap.values()) {
            answer *= value + 1;
        }
        
        return answer - 1;
    }
}