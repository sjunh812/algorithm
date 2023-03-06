import java.util.*;

class Solution {
  
    public int solution(int[][] jobs) {
        // jobs[작업이 요청되는 시점][작업의 소요시간]
        PriorityQueue<HardDisk> taskQueue = new PriorityQueue<>(new TaskComparator());
        PriorityQueue<HardDisk> waitQueue = new PriorityQueue<>();
        
        for (int i = 0; i < jobs.length; i++) {
            taskQueue.offer(new HardDisk(jobs[i][0], jobs[i][1]));
        }
        
        int sum = 0;
        int position = 0;
        
        while (!taskQueue.isEmpty()) {            
            if (position < taskQueue.peek().getStart()) {
                position = taskQueue.peek().getStart();
                continue;
            }
            
            while (!taskQueue.isEmpty()) {
                if (position >= taskQueue.peek().getStart()) waitQueue.offer(taskQueue.poll());
                else break;
            }
            
            if (!waitQueue.isEmpty()) {
                HardDisk task = waitQueue.poll();

                sum += (position - task.getStart()) + task.getTime();                         
                position += task.getTime();
                
                while (!waitQueue.isEmpty()) {
                    taskQueue.offer(waitQueue.poll());
                }
            }
        }
        
        return sum / jobs.length;
    }
}

class TaskComparator implements Comparator<HardDisk> {
    
    @Override
    public int compare(HardDisk hd1, HardDisk hd2) {
        return hd1.getStart() - hd2.getStart();
    }
}

class HardDisk implements Comparable<HardDisk> {
    
    private int start;
    private int time;
    
    public HardDisk(int start, int time) {
        this.start = start;
        this.time = time;
    }
    
    public int getStart() {
        return start;
    }
    
    public int getTime() {
        return this.time;
    }
    
    @Override
    public int compareTo(HardDisk other) {
        return this.time - other.time;
    }
}