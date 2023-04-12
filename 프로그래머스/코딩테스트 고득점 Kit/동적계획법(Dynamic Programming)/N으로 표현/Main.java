import java.util.*;

class Solution {

    public int solution(int N, int number) {        
        ArrayList<Set<Long>> list = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            list.add(new HashSet<Long>());
        }
               
        for (int i = 1; i <= 8; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= i; j++) {
                sb.append(String.valueOf(N));
            }
            list.get(i).add(Long.parseLong(sb.toString()));
                               
            for (int j = 1; j < i; j++) {
                for (long n1 : list.get(j)) {
                    for (long n2 : list.get(i - j)) {
                        if (n2 == 0) continue;
                        
                        list.get(i).add(n1 * n2);
                        list.get(i).add(n1 / n2);
                        list.get(i).add(n1 + n2);
                        list.get(i).add(n1 - n2);
                    }
                }
            }
            
            if (list.get(i).contains((long) number)) return i;
        }
        
        return -1;
    }
}