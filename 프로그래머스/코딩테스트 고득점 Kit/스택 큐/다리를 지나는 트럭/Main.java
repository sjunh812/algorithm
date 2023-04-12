import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        
        for (int w : truck_weights) {
            trucks.offer(w);
        }
        
        int answer = 0;
        int totalWeight = 0;
        
        while (true) {
            if (trucks.isEmpty()) {
                answer += bridge_length;
                break;
            }
            
            answer++;
            
            int truck = trucks.peek();
            
            if (bridge.size() == bridge_length) {
                totalWeight -= bridge.poll();
            }
            
            if (bridge.size() < bridge_length) {
                if (totalWeight + truck <= weight) {
                    bridge.offer(truck);
                    totalWeight += trucks.poll();
                } else {
                    bridge.offer(0);
                }
            }
        }
        
        return answer;
    }
}