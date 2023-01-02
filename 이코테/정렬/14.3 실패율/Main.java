import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        List<Stage> list = new ArrayList<>(); 
        for (int i = 1; i <= N; i++) {
            list.add(new Stage(i, 0, 0));
        }
        
        for (int i = 0; i < stages.length; i++) {
            int stage = stages[i];
            for (int j = 0; j < stage - 1; j++) {
                list.get(j).addTotal();
            }
            if (stage - 1 < N) list.get(stage - 1).addFail();
        }
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()]; 
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).getNumber();
        }
        
        return answer;
    }
}

class Stage implements Comparable<Stage> {
    
    private int number; // 스테이지 번호
    private int total;  // 스테이지를 도달한 플레이어 수
    private int fail;   // 스테이지를 실패한 플레이어 수
    
    public Stage(int number, int total, int fail) {
        this.number = number;
        this.total = total;
        this.fail = fail;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public void addTotal() {
        this.total++;
    }
    
    public void addFail() {
        this.total++;
        this.fail++;
    }
    
    @Override
    public int compareTo(Stage other) {
        float thisPer = (float) this.fail / this.total;
        float otherPer = (float) other.fail / other.total;
        
        if (thisPer < otherPer) return 1;
        else if (thisPer > otherPer) return -1;
        else return Integer.compare(this.number, other.number);
    }
}