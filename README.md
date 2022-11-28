# 📒 알고리즘 공부
- 언어 : ```Java```  
#### ※ 입출력 Tip
1. ```BufferedReader``` 클래스 이용 → ```Scanner``` 클래스보다 빠른 성능
2. ```StringTokenizer``` 클래스 이용 → 빠른 문자열 공백처리
#### <예제코드>
```java
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    new Main().input();
  }

  public void input() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n1 = Integer.parseInt(st.nextToken());
    int n2 = Integer.parseInt(st.nextToken());

    System.out.println(n1 + "," + n2);
  }
}
```
<br>

## 1. 이것이 코딩 테스트다 정복하기
- 그리디
  - [예제 3.1 - 거스름돈](https://github.com/sjunh812/algorithm/blob/0a0dadafd8bb1f71c336988c63384b7484179e57/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/3.1%20%EA%B1%B0%EC%8A%A4%EB%A6%84%EB%8F%88/%EA%B1%B0%EC%8A%A4%EB%A6%84%EB%8F%88.md)
  - [예제 3.2 - 큰 수의 법칙](https://github.com/sjunh812/algorithm/blob/0a0dadafd8bb1f71c336988c63384b7484179e57/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/3.2%20%ED%81%B0%EC%88%98%EC%9D%98%20%EB%B2%95%EC%B9%99/Main.java)
