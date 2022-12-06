import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCaseCnt = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < testCaseCnt; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());    // 책의 개수
      int m = Integer.parseInt(st.nextToken());    // 책을 나눠줄 학부생 수
      int[] selected = new int[n + 1];  // 책 선택여부(0 / 1)
      PriorityQueue<Student> pq = new PriorityQueue<>();
      int result = 0;
      
      for (int j = 0; j < m; j++) {
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st2.nextToken());  // 신청한 책의 시작 번호
        int b = Integer.parseInt(st2.nextToken());  // 신청한 책의 마지막 번호

        pq.offer(new Student(a, b));
      }

      while (!pq.isEmpty()) {
        Student student = pq.poll();

        for (int j = student.getA(); j <= student.getB(); j++) {
          if (selected[j] == 0) {
            selected[j] = 1;
            result++;
            
            break;
          }
        }
      }

      sb.append(result + "\n");
    }  

    System.out.println(sb);
  }
}

class Student implements Comparable<Student> {

  private int a;
  private int b;

  public Student(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public int getA() {
    return this.a;
  }

  public int getB() {
    return this.b;
  }

  @Override
  public int compareTo(Student other) {
    if (this.b != other.b) return this.b - other.b;
    else return this.a - this.a;
  }
}