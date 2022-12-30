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
- 구현
  - [5430번 - AC](https://github.com/sjunh812/algorithm/blob/100529c5b4f9143c4ec528cd03579bf168a17089/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/5430%EB%B2%88.%20AC/Main.java)
  - [14502번 - 연구소](
https://github.com/sjunh812/algorithm/blob/100529c5b4f9143c4ec528cd03579bf168a17089/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/14502%EB%B2%88.%20%EC%97%B0%EA%B5%AC%EC%86%8C/Main.java)
  - [13460번 - 구슬 탈출 2](https://github.com/sjunh812/algorithm/blob/100529c5b4f9143c4ec528cd03579bf168a17089/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/13460%EB%B2%88.%20%EA%B5%AC%EC%8A%AC%20%ED%83%88%EC%B6%9C%202/Main.java)
  - [12100번 - 2048 (Easy)](https://github.com/sjunh812/algorithm/blob/61c187d23ed9757ce2df1d014872af4a11ecad75/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/12100%EB%B2%88.%202048%20(Easy)/Main.java)
  - [14500번 - 테트로미노](https://github.com/sjunh812/algorithm/blob/61c187d23ed9757ce2df1d014872af4a11ecad75/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/14500%EB%B2%88.%20%ED%85%8C%ED%8A%B8%EB%A1%9C%EB%AF%B8%EB%85%B8/Main.java)
  - [15684번 - 사다리 조작](https://github.com/sjunh812/algorithm/blob/0c0f186e3c902fc6a6a39fe264e4b1b80af23597/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/15684%EB%B2%88_%20%EC%82%AC%EB%8B%A4%EB%A6%AC%20%EC%A1%B0%EC%9E%91/Main.java)
- DFS & BFS
  - [1012번 - 유기농 배추](https://github.com/sjunh812/algorithm/blob/2226fd209a21469ff0dc723cbe12b969312bf53f/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/1012%EB%B2%88.%20%EC%9C%A0%EA%B8%B0%EB%86%8D%20%EB%B0%B0%EC%B6%94/Main.java)
  - [1697번 - 숨바꼭질](https://github.com/sjunh812/algorithm/blob/2226fd209a21469ff0dc723cbe12b969312bf53f/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/1697%EB%B2%88.%20%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88/Main.java)
  - [1520번 - 내리막 길](https://github.com/sjunh812/algorithm/blob/644902e1c06f03375c00ea82f01f20959484b224/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/1520%EB%B2%88.%20%EB%82%B4%EB%A6%AC%EB%A7%89%20%EA%B8%B8/Main.java)
  - [1707번 - 이분 그래프](https://github.com/sjunh812/algorithm/blob/644902e1c06f03375c00ea82f01f20959484b224/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/1707%EB%B2%88.%20%EC%9D%B4%EB%B6%84%20%EA%B7%B8%EB%9E%98%ED%94%84/Main.java)
  - [1987번 - 알파벳](https://github.com/sjunh812/algorithm/blob/644902e1c06f03375c00ea82f01f20959484b224/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/1987%EB%B2%88.%20%EC%95%8C%ED%8C%8C%EB%B2%B3/Main.java)
  - [2206번 - 벽 부수고 이동하기](https://github.com/sjunh812/algorithm/blob/644902e1c06f03375c00ea82f01f20959484b224/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/2206%EB%B2%88.%20%EB%B2%BD%20%EB%B6%80%EC%88%98%EA%B3%A0%20%EC%9D%B4%EB%8F%99%ED%95%98%EA%B8%B0/Main.java)
  - [7569번 - 토마토](https://github.com/sjunh812/algorithm/blob/644902e1c06f03375c00ea82f01f20959484b224/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/7569%EB%B2%88.%20%ED%86%A0%EB%A7%88%ED%86%A0/Main.java)
  - [13549번 - 숨바꼭질 3](https://github.com/sjunh812/algorithm/blob/a02889cb29b365420e91a4a50dddeff6b066211c/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/13549%EB%B2%88.%20%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88%203/Main.java)
