import java.util.*;
import java.io.*;

class Main {
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int l = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    char[] letters = new char[c];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < c; i++) {
      letters[i] = st.nextToken().charAt(0);
    }

    // 가능한 암호를 사전식으로 출력해야 하므로 정렬 수행
    Arrays.sort(letters);

    Combination comb = new Combination(c, l);
    comb.combination(letters, 0, 0);

    for (String candidate : comb.getResult()) {
      bw.write(candidate + "\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }
}

class Combination {

  private int n;
  private int r;
  private char[] now;
  private ArrayList<String> result;

  public Combination(int n, int r) {
    this.n = n;
    this.r = r;
    now = new char[r];
    result = new ArrayList<String>();
  }

  public void combination(char[] arr, int depth, int target) {
    if (depth == r) {
      char[] temp = new char[r];
      int vowels = 0;  // 모음의 개수
      int consonant = 0;  // 자음의 개수
      
      for (int i = 0; i < r; i++) {
        if (now[i] == 'a' || now[i] == 'e' || now[i] == 'i' || now[i] == 'o' || now[i] == 'u') {
          vowels++;
        } else {
          consonant++;
        }
        temp[i] = now[i];
      }
      
      if (vowels == 0 || consonant < 2) return;
      
      result.add(new String(temp));
      
      return;
    }

    if (target == n) return;

    now[depth] = arr[target];
    combination(arr, depth + 1, target + 1);
    combination(arr, depth, target + 1);
  }

  public ArrayList<String> getResult() {
    return this.result;
  }
}
