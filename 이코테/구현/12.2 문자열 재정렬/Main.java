import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().mySolution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    ArrayList<Character> result = new ArrayList<>();
    int value = 0;
    
    // 문자를 하나씩 확인하며 
    for (int i = 0; i < str.length(); i++) {
      if (Character.isLetter(str.charAt(i))) {  // 알파벳인 경우 리스트에 삽입
        result.add(str.charAt(i));
      } else {  // 숫자는 따로 더하기
        value +=  str.charAt(i) - '0';
      }
    }

    // 알파벳을 오름차순으로 정렬
    Collections.sort(result);

    // 알파벳을 차례대로 출력
    for (int i = 0; i < result.size(); i++) {
      System.out.print(result.get(i));
    }

    // 숫자가 하나라도 존재하는 경우 가장 뒤에 출력
    if (value != 0) System.out.print(value);
    System.out.println();
  }

  private void mySolution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    char[] arr = s.toCharArray();
    int sum = 0;
    String result = "";

    Arrays.sort(arr);

    for (int i = 0; i < arr.length; i++) {
      if (Character.isDigit(arr[i])) {
        sum += arr[i] - '0';
      } else {
        result += arr[i];
      }
    }

    if (sum != 0) result += sum;

    System.out.println(result);
  }
}