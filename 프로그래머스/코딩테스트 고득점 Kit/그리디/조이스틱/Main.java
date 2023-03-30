import java.util.*;

class Solution {

    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
        
        for (int i = 0; i < name.length(); i++) {
            char alphabet = name.charAt(i);
                
            answer += Math.min(alphabet - 'A', 'Z' - alphabet + 1);
            
            int aIndex = i + 1;
            while (aIndex < name.length() && name.charAt(aIndex) == 'A') {
                aIndex++;
            }
            
            move = Math.min(move, i * 2 + name.length() - aIndex);
            move = Math.min(move, (name.length() - aIndex) * 2 + i);
        }
        
        return answer + move;
    }
}