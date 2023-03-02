# 📒 알고리즘 공부
- 언어 : ```Java```  
#### ※ 입출력 Tip
1. ```BufferedReader``` 클래스 이용 → ```Scanner``` 클래스보다 빠른 성능
2. ```StringTokenizer``` 클래스 이용 → 빠른 문자열 공백처리
3. ```BufferedWriter``` 클래스 이용 → ```System.out.print()``` 보다 빠른 성능
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
  - [예제 12.4 - 자물쇠와 열쇠](https://github.com/sjunh812/algorithm/blob/a99dce7d256d41f953cbb430041175cfdfb84612/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/12.4%20%EC%9E%90%EB%AC%BC%EC%87%A0%EC%99%80%20%EC%97%B4%EC%87%A0/Main.java)
  - [예제 12.5 - 뱀](https://github.com/sjunh812/algorithm/blob/8cb73cd119cee54db3fb592237f96601ee80cfcd/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/12.5%20%EB%B1%80/Main2.java)
  - [예제 12.6 - 기둥과 보 설치](https://github.com/sjunh812/algorithm/blob/8cb73cd119cee54db3fb592237f96601ee80cfcd/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/12.6%20%EA%B8%B0%EB%91%A5%EA%B3%BC%20%EB%B3%B4%20%EC%84%A4%EC%B9%98/Main2.java)
  - [예제 12.7 - 치킨 배달](https://github.com/sjunh812/algorithm/blob/8cb73cd119cee54db3fb592237f96601ee80cfcd/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/12.7%20%EC%B9%98%ED%82%A8%20%EB%B0%B0%EB%8B%AC/Main2.java)
  - [예제 12.8 - 외벽 점검](https://github.com/sjunh812/algorithm/blob/8cb73cd119cee54db3fb592237f96601ee80cfcd/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/12.8%20%EC%99%B8%EB%B2%BD%20%EC%A0%90%EA%B2%80/Main2.java)
- DFS & BFS
  - [예제 5.1 - DFS 예제](https://github.com/sjunh812/algorithm/blob/c9ce1289672d93630b2f5ca6b8f010ded37a184b/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/5.1%20DFS%20%EC%98%88%EC%A0%9C/Main.java)
  - [예제 5.2 - BFS 예제](https://github.com/sjunh812/algorithm/blob/c9ce1289672d93630b2f5ca6b8f010ded37a184b/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/5.2%20BFS%20%EC%98%88%EC%A0%9C/Main.java)
  - [예제 5.3 - 음료수 얼려 먹기](https://github.com/sjunh812/algorithm/blob/c9ce1289672d93630b2f5ca6b8f010ded37a184b/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/5.3%20%EC%9D%8C%EB%A3%8C%EC%88%98%20%EC%96%BC%EB%A0%A4%20%EB%A8%B9%EA%B8%B0/Main2.java)
  - [예제 5.4 - 미로 탈출](https://github.com/sjunh812/algorithm/blob/c9ce1289672d93630b2f5ca6b8f010ded37a184b/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/5.4%20%EB%AF%B8%EB%A1%9C%20%ED%83%88%EC%B6%9C/Main2.java)
  - [예제 13.1 - 특정 거리의 도시 찾기](https://github.com/sjunh812/algorithm/blob/c9ce1289672d93630b2f5ca6b8f010ded37a184b/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/13.1%20%ED%8A%B9%EC%A0%95%20%EA%B1%B0%EB%A6%AC%EC%9D%98%20%EB%8F%84%EC%8B%9C%20%EC%B0%BE%EA%B8%B0/Main2.java)
  - [예제 13.2 - 연구소](https://github.com/sjunh812/algorithm/blob/c9ce1289672d93630b2f5ca6b8f010ded37a184b/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/13.2%20%EC%97%B0%EA%B5%AC%EC%86%8C/Main2.java)
  - [예제 13.3 - 경쟁적 전염](https://github.com/sjunh812/algorithm/blob/c9ce1289672d93630b2f5ca6b8f010ded37a184b/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/13.3%20%EA%B2%BD%EC%9F%81%EC%A0%81%20%EC%A0%84%EC%97%BC/Main2.java)
  - [예제 13.4 - 괄호 변환](https://github.com/sjunh812/algorithm/blob/8c1b170158c2aa63496d6d7cd4fb6850bfda7576/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/13.4%20%EA%B4%84%ED%98%B8%20%EB%B3%80%ED%99%98/Main2.java)
  - [예제 13.5 - 연산자 끼워 넣기](https://github.com/sjunh812/algorithm/blob/8c1b170158c2aa63496d6d7cd4fb6850bfda7576/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/13.5%20%EC%97%B0%EC%82%B0%EC%9E%90%20%EB%81%BC%EC%9B%8C%20%EB%84%A3%EA%B8%B0/Main2.java)
  - [예제 13.6 - 감시 피하기](https://github.com/sjunh812/algorithm/blob/8c1b170158c2aa63496d6d7cd4fb6850bfda7576/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/13.6%20%EA%B0%90%EC%8B%9C%20%ED%94%BC%ED%95%98%EA%B8%B0/Main2.java)
  - [예제 13.7 - 인구 이동](https://github.com/sjunh812/algorithm/blob/2226fd209a21469ff0dc723cbe12b969312bf53f/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/13.7%20%EC%9D%B8%EA%B5%AC%20%EC%9D%B4%EB%8F%99/Main2.java)
  - [예제 13.8 - 블록 이동하기](https://github.com/sjunh812/algorithm/blob/2226fd209a21469ff0dc723cbe12b969312bf53f/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/13.8%20%EB%B8%94%EB%A1%9D%20%EC%9D%B4%EB%8F%99%ED%95%98%EA%B8%B0/Main.java)
- 정렬
  - [선택 정렬](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/%EC%84%A0%ED%83%9D%20%EC%A0%95%EB%A0%AC/Main.java)
  - [삽입 정렬](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/%EC%82%BD%EC%9E%85%20%EC%A0%95%EB%A0%AC/Main.java)
  - [퀵 정렬](https://github.com/sjunh812/algorithm/blob/0a4543924a92f22cf34de8eb6ca749e3078ec6b1/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/%ED%80%B5%20%EC%A0%95%EB%A0%AC/Main.java)
  - [계수 정렬](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/%EA%B3%84%EC%88%98%20%EC%A0%95%EB%A0%AC/Main.java)
  - [예제 6.1 - 위에서 아래로](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/6.1%20%EC%9C%84%EC%97%90%EC%84%9C%20%EC%95%84%EB%9E%98%EB%A1%9C/Main.java)
  - [예제 6.2 - 성적이 낮은 순서로 학생 출력하기](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/6.2%20%EC%84%B1%EC%A0%81%EC%9D%B4%20%EB%82%AE%EC%9D%80%20%EC%88%9C%EC%84%9C%EB%A1%9C%20%ED%95%99%EC%83%9D%20%EC%B6%9C%EB%A0%A5%ED%95%98%EA%B8%B0/Main.java)
  - [예제 6.3 - 두 배열의 원소 교체](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/6.3%20%EB%91%90%20%EB%B0%B0%EC%97%B4%EC%9D%98%20%EC%9B%90%EC%86%8C%20%EA%B5%90%EC%B2%B4/Main.java)
  - [예제 14.1 - 국영수](https://github.com/sjunh812/algorithm/blob/75090f4fef277baf7fc03fef29c2471767baa8e8/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/14.1%20%EA%B5%AD%EC%98%81%EC%88%98/Main.java)
  - [예제 14.2 - 안테나](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/14.2%20%EC%95%88%ED%85%8C%EB%82%98/Main.java)
  - [예제 14.3 - 실패율](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/14.3%20%EC%8B%A4%ED%8C%A8%EC%9C%A8/Main2.java)
  - [예제 14.4 - 카드 정렬하기](https://github.com/sjunh812/algorithm/blob/0a4543924a92f22cf34de8eb6ca749e3078ec6b1/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/14.4%20%EC%B9%B4%EB%93%9C%20%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0/Main.java)
- 이진 탐색
  - [이진 탐색 (재귀)](https://github.com/sjunh812/algorithm/blob/cfcacdf89ab005b7e492be13109e380373cb3a10/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89(%EC%9E%AC%EA%B7%80)/Main.java)
  - [이진 탐색 (반복문)](https://github.com/sjunh812/algorithm/blob/cfcacdf89ab005b7e492be13109e380373cb3a10/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89(%EB%B0%98%EB%B3%B5%EB%AC%B8)/Main.java)
  - [예제 7.1 - 부품 찾기](https://github.com/sjunh812/algorithm/blob/cfcacdf89ab005b7e492be13109e380373cb3a10/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/7.1%20%EB%B6%80%ED%92%88%20%EC%B0%BE%EA%B8%B0/Main2.java)
  - [예제 7.2 - 떡볶이 떡 만들기](https://github.com/sjunh812/algorithm/blob/cfcacdf89ab005b7e492be13109e380373cb3a10/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/7.2%20%EB%96%A1%EB%B3%B6%EC%9D%B4%20%EB%96%A1%20%EB%A7%8C%EB%93%A4%EA%B8%B0/Main.java)
  - [예제 15.1 - 정렬된 배열에서 특정 수의 개수 구하기](https://github.com/sjunh812/algorithm/blob/cfcacdf89ab005b7e492be13109e380373cb3a10/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/15.1%20%EC%A0%95%EB%A0%AC%EB%90%9C%20%EB%B0%B0%EC%97%B4%EC%97%90%EC%84%9C%20%ED%8A%B9%EC%A0%95%20%EC%88%98%EC%9D%98%20%EA%B0%9C%EC%88%98%20%EA%B5%AC%ED%95%98%EA%B8%B0/Main.java)
  - [예제 15.2 - 고정점 찾기](https://github.com/sjunh812/algorithm/blob/cfcacdf89ab005b7e492be13109e380373cb3a10/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/15.2%20%EA%B3%A0%EC%A0%95%EC%A0%90%20%EC%B0%BE%EA%B8%B0/Main.java)
  - [예제 15.3 - 공유기 설치](https://github.com/sjunh812/algorithm/blob/cfcacdf89ab005b7e492be13109e380373cb3a10/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/15.3%20%EA%B3%B5%EC%9C%A0%EA%B8%B0%20%EC%84%A4%EC%B9%98/Main.java)
  - [예제 15.4 - 가사 검색](https://github.com/sjunh812/algorithm/blob/cfcacdf89ab005b7e492be13109e380373cb3a10/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/15.4%20%EA%B0%80%EC%82%AC%20%EA%B2%80%EC%83%89/Solution2.java)
- 다이나믹 프로그래밍
  - [비효율적인 피보나치 수열](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/%EB%B9%84%ED%9A%A8%EC%9C%A8%EC%A0%81%EC%9D%B8%20%ED%94%BC%EB%B3%B4%EB%82%98%EC%B9%98%20%EC%88%98%EC%97%B4/Main.java)
  - [피보나치 수열(Top-Down)](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/%ED%94%BC%EB%B3%B4%EB%82%98%EC%B9%98%20%EC%88%98%EC%97%B4%20(Top-Down)/Main.java)
  - [피보나치 수열(Bottom-Up)](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/%ED%94%BC%EB%B3%B4%EB%82%98%EC%B9%98%20%EC%88%98%EC%97%B4%20(Bottom-Up)/Main.java)
  - [예제 8.1 - 1로 만들기](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/8.1%201%EB%A1%9C%20%EB%A7%8C%EB%93%A4%EA%B8%B0/Main.java)
  - [예제 8.2 - 개미 전사](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/8.2%20%EA%B0%9C%EB%AF%B8%20%EC%A0%84%EC%82%AC/Main.java)
  - [예제 8.3 - 바닥 공사](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/8.3%20%EB%B0%94%EB%8B%A5%20%EA%B3%B5%EC%82%AC/Main.java)
  - [예제 8.4 - 효율적인 화폐 구성](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/8.4%20%ED%9A%A8%EC%9C%A8%EC%A0%81%EC%9D%B8%20%ED%99%94%ED%8F%90%20%EA%B5%AC%EC%84%B1/Main.java)
  - [예제 16.1 - 금광](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/16.1%20%EA%B8%88%EA%B4%91/Main.java)
  - [예제 16.2 - 정수 삼각형](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/16.2%20%EC%A0%95%EC%88%98%20%EC%82%BC%EA%B0%81%ED%98%95/Main2.java)
  - [예제 16.3 - 퇴사](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/16.3%20%ED%87%B4%EC%82%AC/Main2.java)
  - [예제 16.4 - 병사 배치하기](https://github.com/sjunh812/algorithm/blob/fffb2111d7dd7ccd1ad6c633de5d3994596988cd/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/16.4%20%EB%B3%91%EC%82%AC%20%EB%B0%B0%EC%B9%98%ED%95%98%EA%B8%B0/Main.java)
  - [예제 16.5 - 못생긴 수](https://github.com/sjunh812/algorithm/blob/fffb2111d7dd7ccd1ad6c633de5d3994596988cd/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/16.5%20%EB%AA%BB%EC%83%9D%EA%B8%B4%20%EC%88%98/Main.java)
  - [예제 16.6 - 편집 거리](https://github.com/sjunh812/algorithm/blob/fffb2111d7dd7ccd1ad6c633de5d3994596988cd/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/16.6%20%ED%8E%B8%EC%A7%91%20%EA%B1%B0%EB%A6%AC/Main.java)
- 최단 경로
  - [다익스트라 알고리즘](https://github.com/sjunh812/algorithm/blob/e0e5e7b35b40d6246ac7925bde8bda3ac8ed6f5f/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%B5%9C%EB%8B%A8%20%EA%B2%BD%EB%A1%9C/%EB%8B%A4%EC%9D%B5%EC%8A%A4%ED%8A%B8%EB%9D%BC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Main.java)
  - [개선된 다익스트라 알고리즘](https://github.com/sjunh812/algorithm/blob/e0e5e7b35b40d6246ac7925bde8bda3ac8ed6f5f/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%B5%9C%EB%8B%A8%20%EA%B2%BD%EB%A1%9C/%EA%B0%9C%EC%84%A0%EB%90%9C%20%EB%8B%A4%EC%9D%B5%EC%8A%A4%ED%8A%B8%EB%9D%BC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Main.java)
  - [플로이드 워셜 알고리즘](https://github.com/sjunh812/algorithm/blob/e0e5e7b35b40d6246ac7925bde8bda3ac8ed6f5f/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%B5%9C%EB%8B%A8%20%EA%B2%BD%EB%A1%9C/%ED%94%8C%EB%A1%9C%EC%9D%B4%EB%93%9C%20%EC%9B%8C%EC%85%9C%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Main.java)
  - [예제 9.1 - 미래 도시](https://github.com/sjunh812/algorithm/blob/e0e5e7b35b40d6246ac7925bde8bda3ac8ed6f5f/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%B5%9C%EB%8B%A8%20%EA%B2%BD%EB%A1%9C/9.1%20%EB%AF%B8%EB%9E%98%20%EB%8F%84%EC%8B%9C/Main2.java)
  - [예제 9.2 - 전보](https://github.com/sjunh812/algorithm/blob/e0e5e7b35b40d6246ac7925bde8bda3ac8ed6f5f/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%B5%9C%EB%8B%A8%20%EA%B2%BD%EB%A1%9C/9.2%20%EC%A0%84%EB%B3%B4/Main2.java)
  - [예제 17.1 - 플로이드](https://github.com/sjunh812/algorithm/blob/e0e5e7b35b40d6246ac7925bde8bda3ac8ed6f5f/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%B5%9C%EB%8B%A8%20%EA%B2%BD%EB%A1%9C/17.1%20%ED%94%8C%EB%A1%9C%EC%9D%B4%EB%93%9C/Main2.java)
  - [예제 17.2 - 정확한 순위](https://github.com/sjunh812/algorithm/blob/e0e5e7b35b40d6246ac7925bde8bda3ac8ed6f5f/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%B5%9C%EB%8B%A8%20%EA%B2%BD%EB%A1%9C/17.2%20%EC%A0%95%ED%99%95%ED%95%9C%20%EC%88%9C%EC%9C%84/Main2.java)
  - [예제 17.3 - 화성 탐사](https://github.com/sjunh812/algorithm/blob/e0e5e7b35b40d6246ac7925bde8bda3ac8ed6f5f/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%B5%9C%EB%8B%A8%20%EA%B2%BD%EB%A1%9C/17.3%20%ED%99%94%EC%84%B1%20%ED%83%90%EC%82%AC/Main2.java)
  - [예제 17.4 - 숨바꼭질](https://github.com/sjunh812/algorithm/blob/e0e5e7b35b40d6246ac7925bde8bda3ac8ed6f5f/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%B5%9C%EB%8B%A8%20%EA%B2%BD%EB%A1%9C/17.4%20%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88/Main2.java)
- 그래프 이론
  - [간단한 서로소 집합 알고리즘](https://github.com/sjunh812/algorithm/blob/3ad2d054e62086cf64542a672280c8f803dc1ff9/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%9E%98%ED%94%84%20%EC%9D%B4%EB%A1%A0/%EA%B0%84%EB%8B%A8%ED%95%9C%20%EC%84%9C%EB%A1%9C%EC%86%8C%20%EC%A7%91%ED%95%A9%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Main.java)
  - [개선된 서로소 집합 알고리즘(경로 압축)](https://github.com/sjunh812/algorithm/blob/3ad2d054e62086cf64542a672280c8f803dc1ff9/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%9E%98%ED%94%84%20%EC%9D%B4%EB%A1%A0/%EA%B0%9C%EC%84%A0%EB%90%9C%20%EC%84%9C%EB%A1%9C%EC%86%8C%20%EC%A7%91%ED%95%A9%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98(%EA%B2%BD%EB%A1%9C%20%EC%95%95%EC%B6%95)/Main.java)
  - [서로소 집합을 활용한 사이클 판별](https://github.com/sjunh812/algorithm/blob/3ad2d054e62086cf64542a672280c8f803dc1ff9/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%9E%98%ED%94%84%20%EC%9D%B4%EB%A1%A0/%EC%84%9C%EB%A1%9C%EC%86%8C%20%EC%A7%91%ED%95%A9%EC%9D%84%20%ED%99%9C%EC%9A%A9%ED%95%9C%20%EC%82%AC%EC%9D%B4%ED%81%B4%20%ED%8C%90%EB%B3%84/Main.java)
  - [크루스칼 알고리즘](https://github.com/sjunh812/algorithm/blob/3ad2d054e62086cf64542a672280c8f803dc1ff9/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%9E%98%ED%94%84%20%EC%9D%B4%EB%A1%A0/%ED%81%AC%EB%A3%A8%EC%8A%A4%EC%B9%BC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Main.java)
  - [위상 정렬](https://github.com/sjunh812/algorithm/blob/3ad2d054e62086cf64542a672280c8f803dc1ff9/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%9E%98%ED%94%84%20%EC%9D%B4%EB%A1%A0/%EC%9C%84%EC%83%81%20%EC%A0%95%EB%A0%AC/Main.java)
  - [예제 10.1 - 팀 결성](https://github.com/sjunh812/algorithm/blob/4e0dc6433d70f5a9621b3a99dd506ab3590c6af8/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%9E%98%ED%94%84%20%EC%9D%B4%EB%A1%A0/10.1%20%ED%8C%80%20%EA%B2%B0%EC%84%B1/Main.java)
  - [예제 10.2 - 도시 분할 계획](https://github.com/sjunh812/algorithm/blob/4e0dc6433d70f5a9621b3a99dd506ab3590c6af8/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%9E%98%ED%94%84%20%EC%9D%B4%EB%A1%A0/10.2%20%EB%8F%84%EC%8B%9C%20%EB%B6%84%ED%95%A0%20%EA%B3%84%ED%9A%8D/Main.java)
  - [예제 10.3 - 커리큘럼](https://github.com/sjunh812/algorithm/blob/4e0dc6433d70f5a9621b3a99dd506ab3590c6af8/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%9E%98%ED%94%84%20%EC%9D%B4%EB%A1%A0/10.3%20%EC%BB%A4%EB%A6%AC%ED%81%98%EB%9F%BC/Main.java)
  - [예제 18.1 - 여행 계획](https://github.com/sjunh812/algorithm/blob/4e0dc6433d70f5a9621b3a99dd506ab3590c6af8/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%9E%98%ED%94%84%20%EC%9D%B4%EB%A1%A0/18.1%20%EC%97%AC%ED%96%89%20%EA%B3%84%ED%9A%8D/Main.java)
  - [예제 18.2 - 탑승구](https://github.com/sjunh812/algorithm/blob/8c0a2ae97fefd0f11da5df48277b443e0e567817/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%9E%98%ED%94%84%20%EC%9D%B4%EB%A1%A0/18.2%20%ED%83%91%EC%8A%B9%EA%B5%AC/Main.java)
  - [예제 18.3 - 어두운 길](https://github.com/sjunh812/algorithm/blob/4e0dc6433d70f5a9621b3a99dd506ab3590c6af8/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%9E%98%ED%94%84%20%EC%9D%B4%EB%A1%A0/18.3%20%EC%96%B4%EB%91%90%EC%9A%B4%20%EA%B8%B8/Main.java)
  - [예제 18.4 - 행성 터널](https://github.com/sjunh812/algorithm/blob/4e0dc6433d70f5a9621b3a99dd506ab3590c6af8/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%9E%98%ED%94%84%20%EC%9D%B4%EB%A1%A0/18.4%20%ED%96%89%EC%84%B1%20%ED%84%B0%EB%84%90/Main.java)
  - [예제 18.5 - 최종 순위](https://github.com/sjunh812/algorithm/blob/4c5283723db57b72fad40f1ac081c4e64e130ab5/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%9E%98%ED%94%84%20%EC%9D%B4%EB%A1%A0/18.5%20%EC%B5%9C%EC%A2%85%20%EC%88%9C%EC%9C%84/Main.java)
- 2020년 상반기 삼성전자 기출문제
  - [아기 상어(백준 - 16236번)](https://github.com/sjunh812/algorithm/blob/3c41d3c6e0de021b486c3bacddc142ab94af79d7/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/16236%EB%B2%88.%20%EC%95%84%EA%B8%B0%20%EC%83%81%EC%96%B4/Main.java)
  - [청소년 상어(백준 - 19236번)](https://github.com/sjunh812/algorithm/blob/0f19c5182dc701fe228966b6a227f00908ff9528/%EC%9D%B4%EC%BD%94%ED%85%8C/2020%EB%85%84%20%EC%83%81%EB%B0%98%EA%B8%B0%20%EC%82%BC%EC%84%B1%EC%A0%84%EC%9E%90%20%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C/%EC%B2%AD%EC%86%8C%EB%85%84%20%EC%83%81%EC%96%B4/Main.java)
  - [어른 상어(백준 - 19237번)](https://github.com/sjunh812/algorithm/blob/38bbde0ea2a3b94093e7b2a1c72398f6cf1f284c/%EC%9D%B4%EC%BD%94%ED%85%8C/2020%EB%85%84%20%EC%83%81%EB%B0%98%EA%B8%B0%20%EC%82%BC%EC%84%B1%EC%A0%84%EC%9E%90%20%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C/%EC%96%B4%EB%A5%B8%20%EC%83%81%EC%96%B4/Main.java)
- 부록
  - [소수 판별](https://github.com/sjunh812/algorithm/blob/master/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%B6%80%EB%A1%9D/%EC%86%8C%EC%88%98%20%ED%8C%90%EB%B3%84/Main.java)
  - [에라토스테네스의 체](https://github.com/sjunh812/algorithm/blob/master/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%B6%80%EB%A1%9D/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98%20%EC%B2%B4/Main.java)
  - [정렬되어 있는 두 리스트 합치기 (투 포인터)](https://github.com/sjunh812/algorithm/blob/master/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%B6%80%EB%A1%9D/%EC%A0%95%EB%A0%AC%EB%90%98%EC%96%B4%20%EC%9E%88%EB%8A%94%20%EB%91%90%20%EB%A6%AC%EC%8A%A4%ED%8A%B8%20%ED%95%A9%EC%B9%98%EA%B8%B0%20(%ED%88%AC%20%ED%8F%AC%EC%9D%B8%ED%84%B0)/Main.java)
  - [특정한 합을 가지는 연속 수열 찾기 (투 포인터)](https://github.com/sjunh812/algorithm/blob/master/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%B6%80%EB%A1%9D/%ED%8A%B9%EC%A0%95%ED%95%9C%20%ED%95%A9%EC%9D%84%20%EA%B0%80%EC%A7%80%EB%8A%94%20%EC%97%B0%EC%86%8D%20%EC%88%98%EC%97%B4%20%EC%B0%BE%EA%B8%B0%20(%ED%88%AC%20%ED%8F%AC%EC%9D%B8%ED%84%B0)/Main.java)
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
  - [11501번 - 주식](https://github.com/sjunh812/algorithm/blob/4925a559d5e1acdbba45bb5a628aa587a7129202/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/11501%EB%B2%88.%20%EC%A3%BC%EC%8B%9D/Main2.java)
  - [1781번 - 컵라면](https://github.com/sjunh812/algorithm/blob/4925a559d5e1acdbba45bb5a628aa587a7129202/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/1781%EB%B2%88.%20%EC%BB%B5%EB%9D%BC%EB%A9%B4/Main.java)
- 구현
  - [5430번 - AC](https://github.com/sjunh812/algorithm/blob/100529c5b4f9143c4ec528cd03579bf168a17089/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/5430%EB%B2%88.%20AC/Main.java)
  - [14502번 - 연구소](
https://github.com/sjunh812/algorithm/blob/100529c5b4f9143c4ec528cd03579bf168a17089/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/14502%EB%B2%88.%20%EC%97%B0%EA%B5%AC%EC%86%8C/Main.java)
  - [13460번 - 구슬 탈출 2](https://github.com/sjunh812/algorithm/blob/100529c5b4f9143c4ec528cd03579bf168a17089/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/13460%EB%B2%88.%20%EA%B5%AC%EC%8A%AC%20%ED%83%88%EC%B6%9C%202/Main.java)
  - [12100번 - 2048 (Easy)](https://github.com/sjunh812/algorithm/blob/61c187d23ed9757ce2df1d014872af4a11ecad75/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/12100%EB%B2%88.%202048%20(Easy)/Main.java)
  - [14500번 - 테트로미노](https://github.com/sjunh812/algorithm/blob/61c187d23ed9757ce2df1d014872af4a11ecad75/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/14500%EB%B2%88.%20%ED%85%8C%ED%8A%B8%EB%A1%9C%EB%AF%B8%EB%85%B8/Main.java)
  - [15684번 - 사다리 조작](https://github.com/sjunh812/algorithm/blob/0c0f186e3c902fc6a6a39fe264e4b1b80af23597/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/15684%EB%B2%88_%20%EC%82%AC%EB%8B%A4%EB%A6%AC%20%EC%A1%B0%EC%9E%91/Main.java)
  - [1475번 - 방 번호](https://github.com/sjunh812/algorithm/blob/d47e016d42af5df43ecf806affc66093d3235948/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/1475%EB%B2%88.%20%EB%B0%A9%20%EB%B2%88%ED%98%B8/Main.java)
- DFS & BFS
  - [1012번 - 유기농 배추](https://github.com/sjunh812/algorithm/blob/2226fd209a21469ff0dc723cbe12b969312bf53f/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/1012%EB%B2%88.%20%EC%9C%A0%EA%B8%B0%EB%86%8D%20%EB%B0%B0%EC%B6%94/Main.java)
  - [1697번 - 숨바꼭질](https://github.com/sjunh812/algorithm/blob/2226fd209a21469ff0dc723cbe12b969312bf53f/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/1697%EB%B2%88.%20%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88/Main.java)
  - [1520번 - 내리막 길](https://github.com/sjunh812/algorithm/blob/644902e1c06f03375c00ea82f01f20959484b224/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/1520%EB%B2%88.%20%EB%82%B4%EB%A6%AC%EB%A7%89%20%EA%B8%B8/Main.java)
  - [1707번 - 이분 그래프](https://github.com/sjunh812/algorithm/blob/644902e1c06f03375c00ea82f01f20959484b224/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/1707%EB%B2%88.%20%EC%9D%B4%EB%B6%84%20%EA%B7%B8%EB%9E%98%ED%94%84/Main.java)
  - [1987번 - 알파벳](https://github.com/sjunh812/algorithm/blob/644902e1c06f03375c00ea82f01f20959484b224/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/1987%EB%B2%88.%20%EC%95%8C%ED%8C%8C%EB%B2%B3/Main.java)
  - [2206번 - 벽 부수고 이동하기](https://github.com/sjunh812/algorithm/blob/644902e1c06f03375c00ea82f01f20959484b224/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/2206%EB%B2%88.%20%EB%B2%BD%20%EB%B6%80%EC%88%98%EA%B3%A0%20%EC%9D%B4%EB%8F%99%ED%95%98%EA%B8%B0/Main.java)
  - [7569번 - 토마토](https://github.com/sjunh812/algorithm/blob/644902e1c06f03375c00ea82f01f20959484b224/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/7569%EB%B2%88.%20%ED%86%A0%EB%A7%88%ED%86%A0/Main.java)
  - [13549번 - 숨바꼭질 3](https://github.com/sjunh812/algorithm/blob/a02889cb29b365420e91a4a50dddeff6b066211c/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/13549%EB%B2%88.%20%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88%203/Main.java)
  - [9019번 - DSLR](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/9019%EB%B2%88.%20DSLR/Main.java)
  - [2573번 - 빙산](https://github.com/sjunh812/algorithm/blob/6919b8d0f10927737c096a9eb4f03820e17d1236/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/2573%EB%B2%88.%20%EB%B9%99%EC%82%B0/Main.java)
  - [16236번 - 아기 상어](https://github.com/sjunh812/algorithm/blob/3c41d3c6e0de021b486c3bacddc142ab94af79d7/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/16236%EB%B2%88.%20%EC%95%84%EA%B8%B0%20%EC%83%81%EC%96%B4/Main.java)
  - [1600번 - 말이 되고픈 원숭이](https://github.com/sjunh812/algorithm/blob/2667ef7ab14e412c2105a69b27d75932f684b98c/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/1600%EB%B2%88.%20%EB%A7%90%EC%9D%B4%20%EB%90%98%EA%B3%A0%ED%94%88%20%EC%9B%90%EC%88%AD%EC%9D%B4/Main.java)
  - [1068번 - 트리](https://github.com/sjunh812/algorithm/blob/a7d3ad49f6c9ea4becde3a388e965c00630fc7fa/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/1068%EB%B2%88.%20%ED%8A%B8%EB%A6%AC/Main.java)
  - [1167번 - 트리의 지름](https://github.com/sjunh812/algorithm/blob/master/%EB%B0%B1%EC%A4%80/DFS%20%26%20BFS/1167%EB%B2%88.%20%ED%8A%B8%EB%A6%AC%EC%9D%98%20%EC%A7%80%EB%A6%84/Main.java)
  - [2644번 - 촌수계산](https://github.com/sjunh812/algorithm/blob/master/%EB%B0%B1%EC%A4%80/DFS%20%26%20BFS/2644%EB%B2%88.%20%EC%B4%8C%EC%88%98%EA%B3%84%EC%82%B0/Main.java)
  - [17142번 - 연구소 3](https://github.com/sjunh812/algorithm/blob/master/%EB%B0%B1%EC%A4%80/DFS%20%26%20BFS/17142%EB%B2%88.%20%EC%97%B0%EA%B5%AC%EC%86%8C%203/Main.java)
- 정렬
  - [1920번 - 수 찾기](https://github.com/sjunh812/algorithm/blob/0a4543924a92f22cf34de8eb6ca749e3078ec6b1/%EB%B0%B1%EC%A4%80/%EC%A0%95%EB%A0%AC/1920%EB%B2%88.%20%EC%88%98%20%EC%B0%BE%EA%B8%B0/Main.java)
  - [10816번 - 숫자 카드 2](https://github.com/sjunh812/algorithm/blob/0a4543924a92f22cf34de8eb6ca749e3078ec6b1/%EB%B0%B1%EC%A4%80/%EC%A0%95%EB%A0%AC/10816%EB%B2%88.%20%EC%88%AB%EC%9E%90%20%EC%B9%B4%EB%93%9C%202/Main.java)
- 이진 탐색
  - [12015번 - 가장 긴 증가하는 부분 수열 2](https://github.com/sjunh812/algorithm/blob/ff779f57aa9375a56d05b277255d04b2d07b2ba2/%EB%B0%B1%EC%A4%80/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/12015%EB%B2%88.%20%EA%B0%80%EC%9E%A5%20%EA%B8%B4%20%EC%A6%9D%EA%B0%80%ED%95%98%EB%8A%94%20%EB%B6%80%EB%B6%84%20%EC%88%98%EC%97%B4%202/Main.java)
  - [1654번 - 랜선 자르기](https://github.com/sjunh812/algorithm/blob/ff779f57aa9375a56d05b277255d04b2d07b2ba2/%EB%B0%B1%EC%A4%80/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/1654%EB%B2%88.%20%EB%9E%9C%EC%84%A0%20%EC%9E%90%EB%A5%B4%EA%B8%B0/Main.java)
  - [2470번 - 두 용액](https://github.com/sjunh812/algorithm/blob/ff779f57aa9375a56d05b277255d04b2d07b2ba2/%EB%B0%B1%EC%A4%80/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/2470%EB%B2%88.%20%EB%91%90%20%EC%9A%A9%EC%95%A1/Main.java)
  - [7454번 - 합이 0인 네 정수](https://github.com/sjunh812/algorithm/blob/ff779f57aa9375a56d05b277255d04b2d07b2ba2/%EB%B0%B1%EC%A4%80/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/7453%EB%B2%88.%20%ED%95%A9%EC%9D%B4%200%EC%9D%B8%20%EB%84%A4%20%EC%A0%95%EC%88%98/Main.java)
- 다이나믹 프로그래밍
  - [2579번 - 계단 오르기](https://github.com/sjunh812/algorithm/blob/b3196465a53d5851fd0b02543d431712c3b2b9f8/%EB%B0%B1%EC%A4%80/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/2579%EB%B2%88.%20%EA%B3%84%EB%8B%A8%20%EC%98%A4%EB%A5%B4%EA%B8%B0/Main.java)
  - [11053번 - 가장 긴 증가하는 부분 수열](https://github.com/sjunh812/algorithm/blob/b3196465a53d5851fd0b02543d431712c3b2b9f8/%EB%B0%B1%EC%A4%80/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/11053%EB%B2%88.%20%EA%B0%80%EC%9E%A5%20%EA%B8%B4%20%EC%A6%9D%EA%B0%80%ED%95%98%EB%8A%94%20%EB%B6%80%EB%B6%84%20%EC%88%98%EC%97%B4/Main.java)
  - [1010번 - 다리 놓기](https://github.com/sjunh812/algorithm/blob/642417611de68ccacfebe35fe465a9907fd63e3f/%EB%B0%B1%EC%A4%80/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/1010%EB%B2%88.%20%EB%8B%A4%EB%A6%AC%20%EB%86%93%EA%B8%B0/Main.java)
  - [9095번 - 1, 2, 3 더하기](https://github.com/sjunh812/algorithm/blob/642417611de68ccacfebe35fe465a9907fd63e3f/%EB%B0%B1%EC%A4%80/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/9095%EB%B2%88.%201,%202,%203%20%EB%8D%94%ED%95%98%EA%B8%B0/Main.java)
  - [12865번 - 평범한 배낭](https://github.com/sjunh812/algorithm/blob/642417611de68ccacfebe35fe465a9907fd63e3f/%EB%B0%B1%EC%A4%80/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/12865%EB%B2%88.%20%ED%8F%89%EB%B2%94%ED%95%9C%20%EB%B0%B0%EB%82%AD/Main.java)
  - [9251번 - LCS](https://github.com/sjunh812/algorithm/blob/2780fa25ac7c76835dc5e1ec744539dc0ba0e741/%EB%B0%B1%EC%A4%80/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/9251%EB%B2%88.%20LCS/Main.java)
  - [1005번 - ACM Craft](https://github.com/sjunh812/algorithm/blob/2780fa25ac7c76835dc5e1ec744539dc0ba0e741/%EB%B0%B1%EC%A4%80/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/1005%EB%B2%88.%20ACM%20Craft/Main.java)
  - [2293번 - 동전 1](https://github.com/sjunh812/algorithm/blob/bc178f91297dcda54b3d18ef3796eb063ddd4ca1/%EB%B0%B1%EC%A4%80/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/2293%EB%B2%88.%20%EB%8F%99%EC%A0%84%201/Main.java)
  - [2011번 - 암호코드](https://github.com/sjunh812/algorithm/blob/bc178f91297dcda54b3d18ef3796eb063ddd4ca1/%EB%B0%B1%EC%A4%80/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/2011%EB%B2%88.%20%EC%95%94%ED%98%B8%EC%BD%94%EB%93%9C/Main.java)
  - [10942번 - 팰린드롬](https://github.com/sjunh812/algorithm/blob/113dd911a4e120c584310c296fd9c2eacfb4f1c6/%EB%B0%B1%EC%A4%80/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/10942%EB%B2%88.%20%ED%8C%B0%EB%A6%B0%EB%93%9C%EB%A1%AC/Main.java)
- 최단 경로
  - [1238번 - 파티](https://github.com/sjunh812/algorithm/blob/136b353d290898cc97f05827420f0e9ddc6292cd/%EB%B0%B1%EC%A4%80/%EC%B5%9C%EB%8B%A8%20%EA%B2%BD%EB%A1%9C/1238%EB%B2%88.%20%ED%8C%8C%ED%8B%B0/Main.java)
  - [1504번 - 특정한 최단 경로](https://github.com/sjunh812/algorithm/blob/136b353d290898cc97f05827420f0e9ddc6292cd/%EB%B0%B1%EC%A4%80/%EC%B5%9C%EB%8B%A8%20%EA%B2%BD%EB%A1%9C/1504%EB%B2%88.%20%ED%8A%B9%EC%A0%95%ED%95%9C%20%EC%B5%9C%EB%8B%A8%20%EA%B2%BD%EB%A1%9C/Main.java)
  - [5719번 - 거의 최단 경로](https://github.com/sjunh812/algorithm/blob/136b353d290898cc97f05827420f0e9ddc6292cd/%EB%B0%B1%EC%A4%80/%EC%B5%9C%EB%8B%A8%20%EA%B2%BD%EB%A1%9C/5719%EB%B2%88.%20%EA%B1%B0%EC%9D%98%20%EC%B5%9C%EB%8B%A8%20%EA%B2%BD%EB%A1%9C/Main.java)
  - [10217번 - KCM Travel](https://github.com/sjunh812/algorithm/blob/136b353d290898cc97f05827420f0e9ddc6292cd/%EB%B0%B1%EC%A4%80/%EC%B5%9C%EB%8B%A8%20%EA%B2%BD%EB%A1%9C/10217%EB%B2%88.%20KCM%20Travel/Main.java)
  - [9370번 - 미확인 도착지](https://github.com/sjunh812/algorithm/blob/dded173b68ef0ff46d1f66cda05b8387d3b06fbf/%EB%B0%B1%EC%A4%80/%EC%B5%9C%EB%8B%A8%20%EA%B2%BD%EB%A1%9C/9370%EB%B2%88.%20%EB%AF%B8%ED%99%95%EC%9D%B8%20%EB%8F%84%EC%B0%A9%EC%A7%80/Main.java)
  - [11657번 - 타임머신](https://github.com/sjunh812/algorithm/blob/13fcaa9f8cc05212e6e4424ec4500835d8d0652c/%EB%B0%B1%EC%A4%80/%EC%B5%9C%EB%8B%A8%20%EA%B2%BD%EB%A1%9C/11657%EB%B2%88.%20%ED%83%80%EC%9E%84%EB%A8%B8%EC%8B%A0/Main.java)
- 그래프 이론
  - [9466번 - 텀 프로젝트](https://github.com/sjunh812/algorithm/blob/13fcaa9f8cc05212e6e4424ec4500835d8d0652c/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%9E%98%ED%94%84%20%EC%9D%B4%EB%A1%A0/9466%EB%B2%88.%20%ED%85%80%20%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8/Main.java)
  - [1766번 - 문제집](https://github.com/sjunh812/algorithm/blob/7db28bad021a7b11b04fd429c242edf7e5e8f6a4/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%9E%98%ED%94%84%20%EC%9D%B4%EB%A1%A0/1766%EB%B2%88.%20%EB%AC%B8%EC%A0%9C%EC%A7%91/Main.java)
<br>

## 3. 프로그래머스 문제 풀기
### 코딩테스트 고득점 Kit
- 해시
  - [위장](https://github.com/sjunh812/algorithm/blob/798a1e27bf49a3dfcfd30b2e6766748756917495/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4/%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8%20%EA%B3%A0%EB%93%9D%EC%A0%90%20Kit/%ED%95%B4%EC%8B%9C/%EC%9C%84%EC%9E%A5/Main.java)
  - [베스트앨범](https://github.com/sjunh812/algorithm/blob/master/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4/%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8%20%EA%B3%A0%EB%93%9D%EC%A0%90%20Kit/%ED%95%B4%EC%8B%9C/%EB%B2%A0%EC%8A%A4%ED%8A%B8%EC%95%A8%EB%B2%94/Main.java)
- 스택, 큐
  - [다리를 지나는 트럭](https://github.com/sjunh812/algorithm/blob/e210bdddd01c4b8286c9ee5fc3da318f87a24a40/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4/%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8%20%EA%B3%A0%EB%93%9D%EC%A0%90%20Kit/%EC%8A%A4%ED%83%9D,%ED%81%90/%EB%8B%A4%EB%A6%AC%EB%A5%BC%20%EC%A7%80%EB%82%98%EB%8A%94%20%ED%8A%B8%EB%9F%AD/Main.java)
