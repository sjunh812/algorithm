# ๐ ์๊ณ ๋ฆฌ์ฆ ๊ณต๋ถ
- ์ธ์ด : ```Java```  
#### โป ์์ถ๋ ฅ Tip
1. ```BufferedReader``` ํด๋์ค ์ด์ฉ โ ```Scanner``` ํด๋์ค๋ณด๋ค ๋น ๋ฅธ ์ฑ๋ฅ
2. ```StringTokenizer``` ํด๋์ค ์ด์ฉ โ ๋น ๋ฅธ ๋ฌธ์์ด ๊ณต๋ฐฑ์ฒ๋ฆฌ
3. ```BufferedWriter``` ํด๋์ค ์ด์ฉ โ ```System.out.print()``` ๋ณด๋ค ๋น ๋ฅธ ์ฑ๋ฅ
#### <์์ ์ฝ๋>
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

## 1. ์ด๊ฒ์ด ์ฝ๋ฉ ํ์คํธ๋ค(์ด์ฝํ) ์ ๋ณตํ๊ธฐ
- ๊ทธ๋ฆฌ๋
  - [์์  3.1 - ๊ฑฐ์ค๋ฆ๋](https://github.com/sjunh812/algorithm/blob/0a0dadafd8bb1f71c336988c63384b7484179e57/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/3.1%20%EA%B1%B0%EC%8A%A4%EB%A6%84%EB%8F%88/Main.java)
  - [์์  3.2 - ํฐ ์์ ๋ฒ์น](https://github.com/sjunh812/algorithm/blob/0a0dadafd8bb1f71c336988c63384b7484179e57/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/3.2%20%ED%81%B0%EC%88%98%EC%9D%98%20%EB%B2%95%EC%B9%99/Main.java)
  - [์์  3.3 - ์ซ์ ์นด๋ ๊ฒ์](https://github.com/sjunh812/algorithm/blob/11182cc57d1b8a404e2a2b7ec3effb27db91b69a/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/3.3%20%EC%88%AB%EC%9E%90%20%EC%B9%B4%EB%93%9C%20%EA%B2%8C%EC%9E%84/Main.java)
  - [์์  3.4 - 1์ด ๋  ๋๊น์ง](https://github.com/sjunh812/algorithm/blob/f047c37bc77c90040461a1a5583d42969f0fb206/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/3.4%201%EC%9D%B4%20%EB%90%A0%20%EB%95%8C%EA%B9%8C%EC%A7%80/Main.java)
  - [์์  11.1 - ๋ชจํ๊ฐ ๊ธธ๋](https://github.com/sjunh812/algorithm/blob/f047c37bc77c90040461a1a5583d42969f0fb206/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/11.1%20%EB%AA%A8%ED%97%98%EA%B0%80%20%EA%B8%B8%EB%93%9C/Main.java)
  - [์์  11.2 - ๊ณฑํ๊ธฐ ํน์ ๋ํ๊ธฐ](https://github.com/sjunh812/algorithm/blob/f047c37bc77c90040461a1a5583d42969f0fb206/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/11.2%20%EA%B3%B1%ED%95%98%EA%B8%B0%20%ED%98%B9%EC%9D%80%20%EB%8D%94%ED%95%98%EA%B8%B0/Main.java)
  - [์์  11.3 - ๋ฌธ์์ด ๋ค์ง๊ธฐ](https://github.com/sjunh812/algorithm/blob/f047c37bc77c90040461a1a5583d42969f0fb206/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/11.3%20%EB%AC%B8%EC%9E%90%EC%97%B4%20%EB%92%A4%EC%A7%91%EA%B8%B0/Main.java)
  - [์์  11.4 - ๋ง๋ค ์ ์๋ ๊ธ์ก](https://github.com/sjunh812/algorithm/blob/311c43de727fb9f023bf02207e43692a3f5d7e9b/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/11.4%20%EB%A7%8C%EB%93%A4%20%EC%88%98%20%EC%97%86%EB%8A%94%20%EA%B8%88%EC%95%A1/Main.java)
  - [์์  11.5 - ๋ณผ๋ง๊ณต ๊ณ ๋ฅด๊ธฐ](https://github.com/sjunh812/algorithm/blob/311c43de727fb9f023bf02207e43692a3f5d7e9b/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/11.5%20%EB%B3%BC%EB%A7%81%EA%B3%B5%20%EA%B3%A0%EB%A5%B4%EA%B8%B0/Main.java)
  - [์์  11.6 - ๋ฌด์ง์ ๋จน๋ฐฉ ๋ผ์ด๋ธ](https://github.com/sjunh812/algorithm/blob/013efc6a21040c7b923f9c343f5f45dda151812b/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B7%B8%EB%A6%AC%EB%94%94/11.6%20%EB%AC%B4%EC%A7%80%EC%9D%98%20%EB%A8%B9%EB%B0%A9%20%EB%9D%BC%EC%9D%B4%EB%B8%8C/Main.java)
- ๊ตฌํ
  - [์์  4.1 - ์ํ์ข์ฐ](https://github.com/sjunh812/algorithm/blob/f2746048f4188510c464305ff460b34bfbaf1245/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/4.1%20%EC%83%81%ED%95%98%EC%A2%8C%EC%9A%B0/Main.java)
  - [์์  4.2 - ์๊ฐ](https://github.com/sjunh812/algorithm/blob/f2746048f4188510c464305ff460b34bfbaf1245/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/4.2%20%EC%8B%9C%EA%B0%81/Main.java)
  - [์์  4.3 - ์์ค์ ๋์ดํธ](https://github.com/sjunh812/algorithm/blob/f2746048f4188510c464305ff460b34bfbaf1245/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/4.3%20%EC%99%95%EC%8B%A4%EC%9D%98%20%EB%82%98%EC%9D%B4%ED%8A%B8/Main.java)
  - [์์  4.4 - ๊ฒ์ ๊ฐ๋ฐ](https://github.com/sjunh812/algorithm/blob/f2746048f4188510c464305ff460b34bfbaf1245/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/4.4%20%EA%B2%8C%EC%9E%84%20%EA%B0%9C%EB%B0%9C/Main.java)
  - [์์  12.1 - ๋ญํค ์คํธ๋ ์ดํธ](https://github.com/sjunh812/algorithm/blob/84f7717da3a56bb67e46a712fb107ab57fca4d05/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/12.1%20%EB%9F%AD%ED%82%A4%20%EC%8A%A4%ED%8A%B8%EB%A0%88%EC%9D%B4%ED%8A%B8/Main.java)
  - [์์  12.2 - ๋ฌธ์์ด ์ฌ์ ๋ ฌ](https://github.com/sjunh812/algorithm/blob/84f7717da3a56bb67e46a712fb107ab57fca4d05/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/12.2%20%EB%AC%B8%EC%9E%90%EC%97%B4%20%EC%9E%AC%EC%A0%95%EB%A0%AC/Main.java)
  - [์์  12.3 - ๋ฌธ์์ด ์์ถ](https://github.com/sjunh812/algorithm/blob/84f7717da3a56bb67e46a712fb107ab57fca4d05/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/12.3%20%EB%AC%B8%EC%9E%90%EC%97%B4%20%EC%95%95%EC%B6%95/Main.java)
  - [์์  12.4 - ์๋ฌผ์ ์ ์ด์ ](https://github.com/sjunh812/algorithm/blob/a99dce7d256d41f953cbb430041175cfdfb84612/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/12.4%20%EC%9E%90%EB%AC%BC%EC%87%A0%EC%99%80%20%EC%97%B4%EC%87%A0/Main.java)
  - [์์  12.5 - ๋ฑ](https://github.com/sjunh812/algorithm/blob/8cb73cd119cee54db3fb592237f96601ee80cfcd/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/12.5%20%EB%B1%80/Main2.java)
  - [์์  12.6 - ๊ธฐ๋ฅ๊ณผ ๋ณด ์ค์น](https://github.com/sjunh812/algorithm/blob/8cb73cd119cee54db3fb592237f96601ee80cfcd/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/12.6%20%EA%B8%B0%EB%91%A5%EA%B3%BC%20%EB%B3%B4%20%EC%84%A4%EC%B9%98/Main2.java)
  - [์์  12.7 - ์นํจ ๋ฐฐ๋ฌ](https://github.com/sjunh812/algorithm/blob/8cb73cd119cee54db3fb592237f96601ee80cfcd/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/12.7%20%EC%B9%98%ED%82%A8%20%EB%B0%B0%EB%8B%AC/Main2.java)
  - [์์  12.8 - ์ธ๋ฒฝ ์ ๊ฒ](https://github.com/sjunh812/algorithm/blob/8cb73cd119cee54db3fb592237f96601ee80cfcd/%EC%9D%B4%EC%BD%94%ED%85%8C/%EA%B5%AC%ED%98%84/12.8%20%EC%99%B8%EB%B2%BD%20%EC%A0%90%EA%B2%80/Main2.java)
- DFS & BFS
  - [์์  5.1 - DFS ์์ ](https://github.com/sjunh812/algorithm/blob/c9ce1289672d93630b2f5ca6b8f010ded37a184b/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/5.1%20DFS%20%EC%98%88%EC%A0%9C/Main.java)
  - [์์  5.2 - BFS ์์ ](https://github.com/sjunh812/algorithm/blob/c9ce1289672d93630b2f5ca6b8f010ded37a184b/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/5.2%20BFS%20%EC%98%88%EC%A0%9C/Main.java)
  - [์์  5.3 - ์๋ฃ์ ์ผ๋ ค ๋จน๊ธฐ](https://github.com/sjunh812/algorithm/blob/c9ce1289672d93630b2f5ca6b8f010ded37a184b/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/5.3%20%EC%9D%8C%EB%A3%8C%EC%88%98%20%EC%96%BC%EB%A0%A4%20%EB%A8%B9%EA%B8%B0/Main2.java)
  - [์์  5.4 - ๋ฏธ๋ก ํ์ถ](https://github.com/sjunh812/algorithm/blob/c9ce1289672d93630b2f5ca6b8f010ded37a184b/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/5.4%20%EB%AF%B8%EB%A1%9C%20%ED%83%88%EC%B6%9C/Main2.java)
  - [์์  13.1 - ํน์  ๊ฑฐ๋ฆฌ์ ๋์ ์ฐพ๊ธฐ](https://github.com/sjunh812/algorithm/blob/c9ce1289672d93630b2f5ca6b8f010ded37a184b/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/13.1%20%ED%8A%B9%EC%A0%95%20%EA%B1%B0%EB%A6%AC%EC%9D%98%20%EB%8F%84%EC%8B%9C%20%EC%B0%BE%EA%B8%B0/Main2.java)
  - [์์  13.2 - ์ฐ๊ตฌ์](https://github.com/sjunh812/algorithm/blob/c9ce1289672d93630b2f5ca6b8f010ded37a184b/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/13.2%20%EC%97%B0%EA%B5%AC%EC%86%8C/Main2.java)
  - [์์  13.3 - ๊ฒฝ์์  ์ ์ผ](https://github.com/sjunh812/algorithm/blob/c9ce1289672d93630b2f5ca6b8f010ded37a184b/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/13.3%20%EA%B2%BD%EC%9F%81%EC%A0%81%20%EC%A0%84%EC%97%BC/Main2.java)
  - [์์  13.4 - ๊ดํธ ๋ณํ](https://github.com/sjunh812/algorithm/blob/8c1b170158c2aa63496d6d7cd4fb6850bfda7576/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/13.4%20%EA%B4%84%ED%98%B8%20%EB%B3%80%ED%99%98/Main2.java)
  - [์์  13.5 - ์ฐ์ฐ์ ๋ผ์ ๋ฃ๊ธฐ](https://github.com/sjunh812/algorithm/blob/8c1b170158c2aa63496d6d7cd4fb6850bfda7576/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/13.5%20%EC%97%B0%EC%82%B0%EC%9E%90%20%EB%81%BC%EC%9B%8C%20%EB%84%A3%EA%B8%B0/Main2.java)
  - [์์  13.6 - ๊ฐ์ ํผํ๊ธฐ](https://github.com/sjunh812/algorithm/blob/8c1b170158c2aa63496d6d7cd4fb6850bfda7576/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/13.6%20%EA%B0%90%EC%8B%9C%20%ED%94%BC%ED%95%98%EA%B8%B0/Main2.java)
  - [์์  13.7 - ์ธ๊ตฌ ์ด๋](https://github.com/sjunh812/algorithm/blob/2226fd209a21469ff0dc723cbe12b969312bf53f/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/13.7%20%EC%9D%B8%EA%B5%AC%20%EC%9D%B4%EB%8F%99/Main2.java)
  - [์์  13.8 - ๋ธ๋ก ์ด๋ํ๊ธฐ](https://github.com/sjunh812/algorithm/blob/2226fd209a21469ff0dc723cbe12b969312bf53f/%EC%9D%B4%EC%BD%94%ED%85%8C/DFS%20&%20BFS/13.8%20%EB%B8%94%EB%A1%9D%20%EC%9D%B4%EB%8F%99%ED%95%98%EA%B8%B0/Main.java)
- ์ ๋ ฌ
  - [์ ํ ์ ๋ ฌ](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/%EC%84%A0%ED%83%9D%20%EC%A0%95%EB%A0%AC/Main.java)
  - [์ฝ์ ์ ๋ ฌ](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/%EC%82%BD%EC%9E%85%20%EC%A0%95%EB%A0%AC/Main.java)
  - [ํต ์ ๋ ฌ](https://github.com/sjunh812/algorithm/blob/0a4543924a92f22cf34de8eb6ca749e3078ec6b1/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/%ED%80%B5%20%EC%A0%95%EB%A0%AC/Main.java)
  - [๊ณ์ ์ ๋ ฌ](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/%EA%B3%84%EC%88%98%20%EC%A0%95%EB%A0%AC/Main.java)
  - [์์  6.1 - ์์์ ์๋๋ก](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/6.1%20%EC%9C%84%EC%97%90%EC%84%9C%20%EC%95%84%EB%9E%98%EB%A1%9C/Main.java)
  - [์์  6.2 - ์ฑ์ ์ด ๋ฎ์ ์์๋ก ํ์ ์ถ๋ ฅํ๊ธฐ](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/6.2%20%EC%84%B1%EC%A0%81%EC%9D%B4%20%EB%82%AE%EC%9D%80%20%EC%88%9C%EC%84%9C%EB%A1%9C%20%ED%95%99%EC%83%9D%20%EC%B6%9C%EB%A0%A5%ED%95%98%EA%B8%B0/Main.java)
  - [์์  6.3 - ๋ ๋ฐฐ์ด์ ์์ ๊ต์ฒด](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/6.3%20%EB%91%90%20%EB%B0%B0%EC%97%B4%EC%9D%98%20%EC%9B%90%EC%86%8C%20%EA%B5%90%EC%B2%B4/Main.java)
  - [์์  14.1 - ๊ตญ์์](https://github.com/sjunh812/algorithm/blob/75090f4fef277baf7fc03fef29c2471767baa8e8/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/14.1%20%EA%B5%AD%EC%98%81%EC%88%98/Main.java)
  - [์์  14.2 - ์ํ๋](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/14.2%20%EC%95%88%ED%85%8C%EB%82%98/Main.java)
  - [์์  14.3 - ์คํจ์จ](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/14.3%20%EC%8B%A4%ED%8C%A8%EC%9C%A8/Main2.java)
  - [์์  14.4 - ์นด๋ ์ ๋ ฌํ๊ธฐ](https://github.com/sjunh812/algorithm/blob/0a4543924a92f22cf34de8eb6ca749e3078ec6b1/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%A0%95%EB%A0%AC/14.4%20%EC%B9%B4%EB%93%9C%20%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0/Main.java)
- ์ด์ง ํ์
  - [์ด์ง ํ์ (์ฌ๊ท)](https://github.com/sjunh812/algorithm/blob/cfcacdf89ab005b7e492be13109e380373cb3a10/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89(%EC%9E%AC%EA%B7%80)/Main.java)
  - [์ด์ง ํ์ (๋ฐ๋ณต๋ฌธ)](https://github.com/sjunh812/algorithm/blob/cfcacdf89ab005b7e492be13109e380373cb3a10/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89(%EB%B0%98%EB%B3%B5%EB%AC%B8)/Main.java)
  - [์์  7.1 - ๋ถํ ์ฐพ๊ธฐ](https://github.com/sjunh812/algorithm/blob/cfcacdf89ab005b7e492be13109e380373cb3a10/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/7.1%20%EB%B6%80%ED%92%88%20%EC%B0%BE%EA%B8%B0/Main2.java)
  - [์์  7.2 - ๋ก๋ณถ์ด ๋ก ๋ง๋ค๊ธฐ](https://github.com/sjunh812/algorithm/blob/cfcacdf89ab005b7e492be13109e380373cb3a10/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/7.2%20%EB%96%A1%EB%B3%B6%EC%9D%B4%20%EB%96%A1%20%EB%A7%8C%EB%93%A4%EA%B8%B0/Main.java)
  - [์์  15.1 - ์ ๋ ฌ๋ ๋ฐฐ์ด์์ ํน์  ์์ ๊ฐ์ ๊ตฌํ๊ธฐ](https://github.com/sjunh812/algorithm/blob/cfcacdf89ab005b7e492be13109e380373cb3a10/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/15.1%20%EC%A0%95%EB%A0%AC%EB%90%9C%20%EB%B0%B0%EC%97%B4%EC%97%90%EC%84%9C%20%ED%8A%B9%EC%A0%95%20%EC%88%98%EC%9D%98%20%EA%B0%9C%EC%88%98%20%EA%B5%AC%ED%95%98%EA%B8%B0/Main.java)
  - [์์  15.2 - ๊ณ ์ ์  ์ฐพ๊ธฐ](https://github.com/sjunh812/algorithm/blob/cfcacdf89ab005b7e492be13109e380373cb3a10/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/15.2%20%EA%B3%A0%EC%A0%95%EC%A0%90%20%EC%B0%BE%EA%B8%B0/Main.java)
  - [์์  15.3 - ๊ณต์ ๊ธฐ ์ค์น](https://github.com/sjunh812/algorithm/blob/cfcacdf89ab005b7e492be13109e380373cb3a10/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/15.3%20%EA%B3%B5%EC%9C%A0%EA%B8%B0%20%EC%84%A4%EC%B9%98/Main.java)
  - [์์  15.4 - ๊ฐ์ฌ ๊ฒ์](https://github.com/sjunh812/algorithm/blob/cfcacdf89ab005b7e492be13109e380373cb3a10/%EC%9D%B4%EC%BD%94%ED%85%8C/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/15.4%20%EA%B0%80%EC%82%AC%20%EA%B2%80%EC%83%89/Solution2.java)
- ๋ค์ด๋๋ฏน ํ๋ก๊ทธ๋๋ฐ
  - [๋นํจ์จ์ ์ธ ํผ๋ณด๋์น ์์ด](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/%EB%B9%84%ED%9A%A8%EC%9C%A8%EC%A0%81%EC%9D%B8%20%ED%94%BC%EB%B3%B4%EB%82%98%EC%B9%98%20%EC%88%98%EC%97%B4/Main.java)
  - [ํผ๋ณด๋์น ์์ด(Top-Down)](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/%ED%94%BC%EB%B3%B4%EB%82%98%EC%B9%98%20%EC%88%98%EC%97%B4%20(Top-Down)/Main.java)
  - [ํผ๋ณด๋์น ์์ด(Bottom-Up)](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/%ED%94%BC%EB%B3%B4%EB%82%98%EC%B9%98%20%EC%88%98%EC%97%B4%20(Bottom-Up)/Main.java)
  - [์์  8.1 - 1๋ก ๋ง๋ค๊ธฐ](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/8.1%201%EB%A1%9C%20%EB%A7%8C%EB%93%A4%EA%B8%B0/Main.java)
  - [์์  8.2 - ๊ฐ๋ฏธ ์ ์ฌ](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/8.2%20%EA%B0%9C%EB%AF%B8%20%EC%A0%84%EC%82%AC/Main.java)
  - [์์  8.3 - ๋ฐ๋ฅ ๊ณต์ฌ](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/8.3%20%EB%B0%94%EB%8B%A5%20%EA%B3%B5%EC%82%AC/Main.java)
  - [์์  8.4 - ํจ์จ์ ์ธ ํํ ๊ตฌ์ฑ](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/8.4%20%ED%9A%A8%EC%9C%A8%EC%A0%81%EC%9D%B8%20%ED%99%94%ED%8F%90%20%EA%B5%AC%EC%84%B1/Main.java)
  - [์์  16.1 - ๊ธ๊ด](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/16.1%20%EA%B8%88%EA%B4%91/Main.java)
  - [์์  16.2 - ์ ์ ์ผ๊ฐํ](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/16.2%20%EC%A0%95%EC%88%98%20%EC%82%BC%EA%B0%81%ED%98%95/Main2.java)
  - [์์  16.3 - ํด์ฌ](https://github.com/sjunh812/algorithm/blob/0da1d5dfb2dfe60eb2618ba35eeb346d73ca8847/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/16.3%20%ED%87%B4%EC%82%AC/Main2.java)
  - [์์  16.4 - ๋ณ์ฌ ๋ฐฐ์นํ๊ธฐ](https://github.com/sjunh812/algorithm/blob/fffb2111d7dd7ccd1ad6c633de5d3994596988cd/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/16.4%20%EB%B3%91%EC%82%AC%20%EB%B0%B0%EC%B9%98%ED%95%98%EA%B8%B0/Main.java)
  - [์์  16.5 - ๋ชป์๊ธด ์](https://github.com/sjunh812/algorithm/blob/fffb2111d7dd7ccd1ad6c633de5d3994596988cd/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/16.5%20%EB%AA%BB%EC%83%9D%EA%B8%B4%20%EC%88%98/Main.java)
  - [์์  16.6 - ํธ์ง ๊ฑฐ๋ฆฌ](https://github.com/sjunh812/algorithm/blob/fffb2111d7dd7ccd1ad6c633de5d3994596988cd/%EC%9D%B4%EC%BD%94%ED%85%8C/%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9%20%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/16.6%20%ED%8E%B8%EC%A7%91%20%EA%B1%B0%EB%A6%AC/Main.java)
<br>

## 2. ๋ฐฑ์ค ๋ฌธ์  ํ๊ธฐ
- ๊ทธ๋ฆฌ๋
  - [1744๋ฒ - ์ ๋ฌถ๊ธฐ](https://github.com/sjunh812/algorithm/blob/013efc6a21040c7b923f9c343f5f45dda151812b/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/1744%EB%B2%88.%20%EC%88%98%20%EB%AC%B6%EA%B8%B0/Main.java)
  - [1700๋ฒ - ๋ฉํฐํญ ์ค์ผ์ค๋ง](https://github.com/sjunh812/algorithm/blob/81932afeb9c7d8c710256617104955cb83116185/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/1700%EB%B2%88.%20%EB%A9%80%ED%8B%B0%ED%83%AD%20%EC%8A%A4%EC%BC%80%EC%A5%B4%EB%A7%81/Main.java)
  - [3109๋ฒ - ๋นต์ง](https://github.com/sjunh812/algorithm/blob/5d127044a0b3ea8fa8d5c030cce9812637c539d9/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/3109%EB%B2%88.%20%EB%B9%B5%EC%A7%91/Main.java)
  - [1080๋ฒ - ํ๋ ฌ](https://github.com/sjunh812/algorithm/blob/5d127044a0b3ea8fa8d5c030cce9812637c539d9/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/1080%EB%B2%88.%20%ED%96%89%EB%A0%AC/Main.java)
  - [10775๋ฒ - ๊ณตํญ](https://github.com/sjunh812/algorithm/blob/5d127044a0b3ea8fa8d5c030cce9812637c539d9/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/10775%EB%B2%88.%20%EA%B3%B5%ED%95%AD/Main.java)
  - [1783๋ฒ - ๋ณ๋  ๋์ดํธ](https://github.com/sjunh812/algorithm/blob/5b360fc06b163e30540c39744a7c12a17f781010/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/1783%EB%B2%88.%20%EB%B3%91%EB%93%A0%20%EB%82%98%EC%9D%B4%ED%8A%B8/Main.java)
  - [2457๋ฒ - ๊ณต์ฃผ๋์ ์ ์](https://github.com/sjunh812/algorithm/blob/5b360fc06b163e30540c39744a7c12a17f781010/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/2457%EB%B2%88.%20%EA%B3%B5%EC%A3%BC%EB%8B%98%EC%9D%98%20%EC%A0%95%EC%9B%90/Main.java)
  - [14916๋ฒ - ๊ฑฐ์ค๋ฆ๋](https://github.com/sjunh812/algorithm/blob/a69a5bc6010d4153823623e3186c9898af48421a/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/14916%EB%B2%88.%20%EA%B1%B0%EC%8A%A4%EB%A6%84%EB%8F%88/Main.java)
  - [9576๋ฒ - ์ฑ ๋๋ ์ฃผ๊ธฐ](https://github.com/sjunh812/algorithm/blob/a69a5bc6010d4153823623e3186c9898af48421a/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/9576%EB%B2%88.%20%EC%B1%85%20%EB%82%98%EB%88%A0%EC%A3%BC%EA%B8%B0/Main.java)
  - [18310๋ฒ - ์ํ๋](https://github.com/sjunh812/algorithm/blob/aa711923d5585addd5f1821d40ccd05d8a420e34/%EB%B0%B1%EC%A4%80/%EA%B7%B8%EB%A6%AC%EB%94%94/18310%EB%B2%88.%20%EC%95%88%ED%85%8C%EB%82%98/Main.java)
- ๊ตฌํ
  - [5430๋ฒ - AC](https://github.com/sjunh812/algorithm/blob/100529c5b4f9143c4ec528cd03579bf168a17089/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/5430%EB%B2%88.%20AC/Main.java)
  - [14502๋ฒ - ์ฐ๊ตฌ์](
https://github.com/sjunh812/algorithm/blob/100529c5b4f9143c4ec528cd03579bf168a17089/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/14502%EB%B2%88.%20%EC%97%B0%EA%B5%AC%EC%86%8C/Main.java)
  - [13460๋ฒ - ๊ตฌ์ฌ ํ์ถ 2](https://github.com/sjunh812/algorithm/blob/100529c5b4f9143c4ec528cd03579bf168a17089/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/13460%EB%B2%88.%20%EA%B5%AC%EC%8A%AC%20%ED%83%88%EC%B6%9C%202/Main.java)
  - [12100๋ฒ - 2048 (Easy)](https://github.com/sjunh812/algorithm/blob/61c187d23ed9757ce2df1d014872af4a11ecad75/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/12100%EB%B2%88.%202048%20(Easy)/Main.java)
  - [14500๋ฒ - ํํธ๋ก๋ฏธ๋ธ](https://github.com/sjunh812/algorithm/blob/61c187d23ed9757ce2df1d014872af4a11ecad75/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/14500%EB%B2%88.%20%ED%85%8C%ED%8A%B8%EB%A1%9C%EB%AF%B8%EB%85%B8/Main.java)
  - [15684๋ฒ - ์ฌ๋ค๋ฆฌ ์กฐ์](https://github.com/sjunh812/algorithm/blob/0c0f186e3c902fc6a6a39fe264e4b1b80af23597/%EB%B0%B1%EC%A4%80/%EA%B5%AC%ED%98%84/15684%EB%B2%88_%20%EC%82%AC%EB%8B%A4%EB%A6%AC%20%EC%A1%B0%EC%9E%91/Main.java)
- DFS & BFS
  - [1012๋ฒ - ์ ๊ธฐ๋ ๋ฐฐ์ถ](https://github.com/sjunh812/algorithm/blob/2226fd209a21469ff0dc723cbe12b969312bf53f/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/1012%EB%B2%88.%20%EC%9C%A0%EA%B8%B0%EB%86%8D%20%EB%B0%B0%EC%B6%94/Main.java)
  - [1697๋ฒ - ์จ๋ฐ๊ผญ์ง](https://github.com/sjunh812/algorithm/blob/2226fd209a21469ff0dc723cbe12b969312bf53f/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/1697%EB%B2%88.%20%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88/Main.java)
  - [1520๋ฒ - ๋ด๋ฆฌ๋ง ๊ธธ](https://github.com/sjunh812/algorithm/blob/644902e1c06f03375c00ea82f01f20959484b224/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/1520%EB%B2%88.%20%EB%82%B4%EB%A6%AC%EB%A7%89%20%EA%B8%B8/Main.java)
  - [1707๋ฒ - ์ด๋ถ ๊ทธ๋ํ](https://github.com/sjunh812/algorithm/blob/644902e1c06f03375c00ea82f01f20959484b224/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/1707%EB%B2%88.%20%EC%9D%B4%EB%B6%84%20%EA%B7%B8%EB%9E%98%ED%94%84/Main.java)
  - [1987๋ฒ - ์ํ๋ฒณ](https://github.com/sjunh812/algorithm/blob/644902e1c06f03375c00ea82f01f20959484b224/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/1987%EB%B2%88.%20%EC%95%8C%ED%8C%8C%EB%B2%B3/Main.java)
  - [2206๋ฒ - ๋ฒฝ ๋ถ์๊ณ  ์ด๋ํ๊ธฐ](https://github.com/sjunh812/algorithm/blob/644902e1c06f03375c00ea82f01f20959484b224/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/2206%EB%B2%88.%20%EB%B2%BD%20%EB%B6%80%EC%88%98%EA%B3%A0%20%EC%9D%B4%EB%8F%99%ED%95%98%EA%B8%B0/Main.java)
  - [7569๋ฒ - ํ ๋งํ ](https://github.com/sjunh812/algorithm/blob/644902e1c06f03375c00ea82f01f20959484b224/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/7569%EB%B2%88.%20%ED%86%A0%EB%A7%88%ED%86%A0/Main.java)
  - [13549๋ฒ - ์จ๋ฐ๊ผญ์ง 3](https://github.com/sjunh812/algorithm/blob/a02889cb29b365420e91a4a50dddeff6b066211c/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/13549%EB%B2%88.%20%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88%203/Main.java)
  - [9019๋ฒ - DSLR](https://github.com/sjunh812/algorithm/blob/a3aa64645c95d42a603e60fa4552ca6c81c38a90/%EB%B0%B1%EC%A4%80/DFS%20&%20BFS/9019%EB%B2%88.%20DSLR/Main.java)
- ์ ๋ ฌ
  - [1920๋ฒ - ์ ์ฐพ๊ธฐ](https://github.com/sjunh812/algorithm/blob/0a4543924a92f22cf34de8eb6ca749e3078ec6b1/%EB%B0%B1%EC%A4%80/%EC%A0%95%EB%A0%AC/1920%EB%B2%88.%20%EC%88%98%20%EC%B0%BE%EA%B8%B0/Main.java)
  - [10816๋ฒ - ์ซ์ ์นด๋ 2](https://github.com/sjunh812/algorithm/blob/0a4543924a92f22cf34de8eb6ca749e3078ec6b1/%EB%B0%B1%EC%A4%80/%EC%A0%95%EB%A0%AC/10816%EB%B2%88.%20%EC%88%AB%EC%9E%90%20%EC%B9%B4%EB%93%9C%202/Main.java)
- ์ด์ง ํ์
  - [12015๋ฒ - ๊ฐ์ฅ ๊ธด ์ฆ๊ฐํ๋ ๋ถ๋ถ ์์ด 2](https://github.com/sjunh812/algorithm/blob/ff779f57aa9375a56d05b277255d04b2d07b2ba2/%EB%B0%B1%EC%A4%80/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/12015%EB%B2%88.%20%EA%B0%80%EC%9E%A5%20%EA%B8%B4%20%EC%A6%9D%EA%B0%80%ED%95%98%EB%8A%94%20%EB%B6%80%EB%B6%84%20%EC%88%98%EC%97%B4%202/Main.java)
  - [1654๋ฒ - ๋์  ์๋ฅด๊ธฐ](https://github.com/sjunh812/algorithm/blob/ff779f57aa9375a56d05b277255d04b2d07b2ba2/%EB%B0%B1%EC%A4%80/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/1654%EB%B2%88.%20%EB%9E%9C%EC%84%A0%20%EC%9E%90%EB%A5%B4%EA%B8%B0/Main.java)
  - [2470๋ฒ - ๋ ์ฉ์ก](https://github.com/sjunh812/algorithm/blob/ff779f57aa9375a56d05b277255d04b2d07b2ba2/%EB%B0%B1%EC%A4%80/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/2470%EB%B2%88.%20%EB%91%90%20%EC%9A%A9%EC%95%A1/Main.java)
  - [7454๋ฒ - ํฉ์ด 0์ธ ๋ค ์ ์](https://github.com/sjunh812/algorithm/blob/ff779f57aa9375a56d05b277255d04b2d07b2ba2/%EB%B0%B1%EC%A4%80/%EC%9D%B4%EC%A7%84%20%ED%83%90%EC%83%89/7453%EB%B2%88.%20%ED%95%A9%EC%9D%B4%200%EC%9D%B8%20%EB%84%A4%20%EC%A0%95%EC%88%98/Main.java)
