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

## 1. 이것이 코딩 테스트다(이코테) 정복하기
- 그리디
  - [예제 3.1 - 거스름돈](https://github.com/sjunh812/algorithm/blob/0a0dadafd8bb1f71c336988c63384b7484179e57/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/3.1%20%EA%B1%B0%EC%8A%A4%EB%A6%84%EB%8F%88/Main.java)
  - [예제 3.2 - 큰 수의 법칙](https://github.com/sjunh812/algorithm/blob/0a0dadafd8bb1f71c336988c63384b7484179e57/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/3.2%20%ED%81%B0%EC%88%98%EC%9D%98%20%EB%B2%95%EC%B9%99/Main.java)
  - [예제 3.3 - 숫자 카드 게임](https://github.com/sjunh812/algorithm/blob/11182cc57d1b8a404e2a2b7ec3effb27db91b69a/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/3.3%20%EC%88%AB%EC%9E%90%20%EC%B9%B4%EB%93%9C%20%EA%B2%8C%EC%9E%84/Main.java)
  - [예제 3.4 - 1이 될 때까지](https://github.com/sjunh812/algorithm/blob/f047c37bc77c90040461a1a5583d42969f0fb206/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/3.4%201%EC%9D%B4%20%EB%90%A0%20%EB%95%8C%EA%B9%8C%EC%A7%80/Main.java)
  - [예제 11.1 - 모험가 길드](https://github.com/sjunh812/algorithm/blob/f047c37bc77c90040461a1a5583d42969f0fb206/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/11.1%20%EB%AA%A8%ED%97%98%EA%B0%80%20%EA%B8%B8%EB%93%9C/Main.java)
  - [예제 11.2 - 곱하기 혹은 더하기](https://github.com/sjunh812/algorithm/blob/f047c37bc77c90040461a1a5583d42969f0fb206/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/11.2%20%EA%B3%B1%ED%95%98%EA%B8%B0%20%ED%98%B9%EC%9D%80%20%EB%8D%94%ED%95%98%EA%B8%B0/Main.java)
  - [예제 11.3 - 문자열 뒤집기](https://github.com/sjunh812/algorithm/blob/f047c37bc77c90040461a1a5583d42969f0fb206/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/11.3%20%EB%AC%B8%EC%9E%90%EC%97%B4%20%EB%92%A4%EC%A7%91%EA%B8%B0/Main.java)
  - [예제 11.4 - 만들 수 없는 금액](https://github.com/sjunh812/algorithm/blob/311c43de727fb9f023bf02207e43692a3f5d7e9b/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/11.4%20%EB%A7%8C%EB%93%A4%20%EC%88%98%20%EC%97%86%EB%8A%94%20%EA%B8%88%EC%95%A1/Main.java)
  - [예제 11.5 - 볼링공 고르기](https://github.com/sjunh812/algorithm/blob/311c43de727fb9f023bf02207e43692a3f5d7e9b/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/11.5%20%EB%B3%BC%EB%A7%81%EA%B3%B5%20%EA%B3%A0%EB%A5%B4%EA%B8%B0/Main.java)
  - [예제 11.6 - 무지의 먹방 라이브](https://github.com/sjunh812/algorithm/blob/013efc6a21040c7b923f9c343f5f45dda151812b/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/11.6%20%EB%AC%B4%EC%A7%80%EC%9D%98%20%EB%A8%B9%EB%B0%A9%20%EB%9D%BC%EC%9D%B4%EB%B8%8C/Main.java)
- 구현
  - [예제 4.1 - 상하좌우](https://github.com/sjunh812/algorithm/blob/f2746048f4188510c464305ff460b34bfbaf1245/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/4.1%20%EC%83%81%ED%95%98%EC%A2%8C%EC%9A%B0/Main.java)
  - [예제 4.2 - 시각](https://github.com/sjunh812/algorithm/blob/f2746048f4188510c464305ff460b34bfbaf1245/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/4.2%20%EC%8B%9C%EA%B0%81/Main.java)
  - [예제 4.3 - 왕실의 나이트](https://github.com/sjunh812/algorithm/blob/f2746048f4188510c464305ff460b34bfbaf1245/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/4.3%20%EC%99%95%EC%8B%A4%EC%9D%98%20%EB%82%98%EC%9D%B4%ED%8A%B8/Main.java)
  - [예제 4.4 - 게임 개발](https://github.com/sjunh812/algorithm/blob/f2746048f4188510c464305ff460b34bfbaf1245/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/4.4%20%EA%B2%8C%EC%9E%84%20%EA%B0%9C%EB%B0%9C/Main.java)
  - [예제 12.1 - 럭키 스트레이트](https://github.com/sjunh812/algorithm/blob/84f7717da3a56bb67e46a712fb107ab57fca4d05/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/12.1%20%EB%9F%AD%ED%82%A4%20%EC%8A%A4%ED%8A%B8%EB%A0%88%EC%9D%B4%ED%8A%B8/Main.java)
  - [예제 12.2 - 문자열 재정렬](https://github.com/sjunh812/algorithm/blob/84f7717da3a56bb67e46a712fb107ab57fca4d05/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/12.2%20%EB%AC%B8%EC%9E%90%EC%97%B4%20%EC%9E%AC%EC%A0%95%EB%A0%AC/Main.java)
  - [예제 12.3 - 문자열 압축](https://github.com/sjunh812/algorithm/blob/84f7717da3a56bb67e46a712fb107ab57fca4d05/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/12.3%20%EB%AC%B8%EC%9E%90%EC%97%B4%20%EC%95%95%EC%B6%95/Main.java)
<br>

## 2. 백준 문제 풀기
- 그리디
  - [1744번 - 수 묶기](https://github.com/sjunh812/algorithm/blob/013efc6a21040c7b923f9c343f5f45dda151812b/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/1744%EB%B2%88.%20%EC%88%98%20%EB%AC%B6%EA%B8%B0/Main.java)
  - [1700번 - 멀티탭 스케줄링](https://github.com/sjunh812/algorithm/blob/81932afeb9c7d8c710256617104955cb83116185/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/1700%EB%B2%88.%20%EB%A9%80%ED%8B%B0%ED%83%AD%20%EC%8A%A4%EC%BC%80%EC%A5%B4%EB%A7%81/Main.java)
  - [3109번 - 빵집](https://github.com/sjunh812/algorithm/blob/5d127044a0b3ea8fa8d5c030cce9812637c539d9/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/3109%EB%B2%88.%20%EB%B9%B5%EC%A7%91/Main.java)
  - [1080번 - 행렬](https://github.com/sjunh812/algorithm/blob/5d127044a0b3ea8fa8d5c030cce9812637c539d9/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/1080%EB%B2%88.%20%ED%96%89%EB%A0%AC/Main.java)
  - [10775번 - 공항](https://github.com/sjunh812/algorithm/blob/5d127044a0b3ea8fa8d5c030cce9812637c539d9/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/10775%EB%B2%88.%20%EA%B3%B5%ED%95%AD/Main.java)
  - [1783번 - 병든 나이트](https://github.com/sjunh812/algorithm/blob/5b360fc06b163e30540c39744a7c12a17f781010/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/1783%EB%B2%88.%20%EB%B3%91%EB%93%A0%20%EB%82%98%EC%9D%B4%ED%8A%B8/Main.java)
  - [2457번 - 공주님의 정원](https://github.com/sjunh812/algorithm/blob/5b360fc06b163e30540c39744a7c12a17f781010/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/2457%EB%B2%88.%20%EA%B3%B5%EC%A3%BC%EB%8B%98%EC%9D%98%20%EC%A0%95%EC%9B%90/Main.java)
  - [14916번 - 거스름돈](https://github.com/sjunh812/algorithm/blob/a69a5bc6010d4153823623e3186c9898af48421a/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/14916%EB%B2%88.%20%EA%B1%B0%EC%8A%A4%EB%A6%84%EB%8F%88/Main.java)
  - [9576번 - 책 나눠주기](https://github.com/sjunh812/algorithm/blob/a69a5bc6010d4153823623e3186c9898af48421a/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/9576%EB%B2%88.%20%EC%B1%85%20%EB%82%98%EB%88%A0%EC%A3%BC%EA%B8%B0/Main.java)
  - [18310번 - 안테나](https://github.com/sjunh812/algorithm/blob/aa711923d5585addd5f1821d40ccd05d8a420e34/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/18310%EB%B2%88.%20%EC%95%88%ED%85%8C%EB%82%98/Main.java)
