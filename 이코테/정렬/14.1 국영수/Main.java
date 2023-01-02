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
      int kor = Integer.parseInt(st.nextToken());
      int eng = Integer.parseInt(st.nextToken());
      int mat = Integer.parseInt(st.nextToken());
      students.add(new Student(name, kor, eng, mat));
    }

    Collections.sort(students);

    for (int i = 0; i < n; i++) {
      System.out.println(students.get(i).getName());
    }
  }
}

class Student implements Comparable<Student> {

  private String name;
  private int kor;
  private int eng;
  private int mat;

  public Student(String name, int kor, int eng, int mat) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.mat = mat;
  }

  public String getName() {
    return this.name;
  }

  /*
  [ 정렬 기준 ]
  1) 두 번째 원소를 기준으로 내림차순 정렬
  2) 두 번째 원소가 같은 경우, 세 번째 원소를 기준으로 오름차순 정렬
  3) 세 번째 원소가 같은 경우, 네 번째 원소를 기준으로 내림차순 정렬
  4) 네 번째 원소가 같은 경우, 첫 번째 원소를 기준으로 오름차순 정렬
  */
  
  @Override
  public int compareTo(Student other) {
    if (this.kor == other.kor && this.eng == other.eng && this.mat == other.mat) {
      return this.name.compareTo(other.name);
    }
    if (this.kor == other.kor && this.eng == other.eng) {
        return Integer.compare(other.mat, this.mat);
    }
    if (this.kor == other.kor) {
        return Integer.compare(this.eng, other.eng);
    }
    return Integer.compare(other.kor, this.kor);
  }
}