import java.util.*;
import java.io.*;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    List<Student> students = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      int score = Integer.parseInt(st.nextToken());
      students.add(new Student(name, score));
    }

    Collections.sort(students);

    for (int i = 0; i < students.size(); i++) {
      System.out.print(students.get(i).getName() + " ");
    }
  }
}

class Student implements Comparable<Student> {

  private String name;
  private int score;

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return this.name;
  }

  public int getScore() {
    return this.score;
  }

  // 정렬 기준은 '점수가 낮은 순서'
  @Override
  public int compareTo(Student other) {
    return Integer.compare(this.score, other.score);
  }
}