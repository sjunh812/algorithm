import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());  // 꽃의 개수

    PriorityQueue<Flower> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int startMonth = Integer.parseInt(st.nextToken());
      int startDay = Integer.parseInt(st.nextToken());
      int endMonth = Integer.parseInt(st.nextToken());
      int endDay = Integer.parseInt(st.nextToken());
      pq.offer(new Flower(startMonth, startDay, endMonth, endDay));
    }

    int min = pq.peek().getStart();
    int max = pq.poll().getEnd();
    int lastStart = -1;
    int lastEnd = -1;
    int result = 0;

    if (min == 0) {
       while (!pq.isEmpty()) {
        int start = pq.peek().getStart();
        int end = pq.poll().getEnd();
  
        if (lastStart == -1 && lastEnd == -1) {
          // min, max를 이용하여 비교
          if (start == 0) {
            if (end > max) max = end;
          } else {
            if (start > max + 1) break;
            lastStart = min;
            lastEnd = max;
            min = start;
            max = end;
            result++;
          }
        } else {
          // lastStart, lastEnd를 이용하여 비교
          if (start > lastEnd + 1) {
            if (min > lastEnd + 1) break;
            lastStart = min;
            lastEnd = max;
            min = start;
            max = end;
            result++;
          }
          
          if (end > max) {
            min = start;
            max = end;
          }
        }
      }
  
      if (lastEnd != 274) {
        if (max == 274 && min - lastEnd <= 1) result++;
        else result = 0;
      } 
    } else {
      result = 0;
    }

    System.out.println(result);
  }
}

class Flower implements Comparable<Flower> {

  int start = 0;
  int end = 0;
  int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  public Flower(int startMonth, int startDay, int endMonth, int endDay) {
    // 3월 1일 ~ 11월 30일
    // 0(3월 1일) ~ 274(11월 30일)
    if (startMonth <= 11 && endMonth >= 3) {
      for (int i = 2; i < startMonth; i++) {
        if (i == startMonth - 1) {
          start += startDay - 1;
          break;
        } else {
          start += dayOfMonth[i];
        }
      }
      
      for (int i = 2; i < 11; i++) {
        if (i == endMonth - 1) {
          end += endDay - 2;
          break;
        } else {
          end += dayOfMonth[i];
        }
      } 

      if (startMonth < 3) start = 0;
      if (endMonth > 11) end = 274;
    }
  }

  public int getStart() {
    return this.start;
  }

  public int getEnd() {
    return this.end;
  }
  
  @Override
  public int compareTo(Flower other) {
    if (this.start > other.start) return 1;
    else if (this.start < other.start) return -1;
    else return this.end - other.end;
  }
}