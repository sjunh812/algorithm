import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st1.nextToken());
    int m = Integer.parseInt(st1.nextToken());
    int[] weightCounts = new int[11];  // 1부터 10까지 무게를 담을 수 있는 배열

    StringTokenizer st2 = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int weight = Integer.parseInt(st2.nextToken());
      weightCounts[weight] += 1;
    }

    int result = 0;

    // 1부터 m까지 각 무게에 대하여 처리
    for (int i = 1; i <= m; i++) {
      n -= weightCounts[i];  // 무게가 i인 볼링공 개수(A가 선택할 수 있는 개수) 제외
      result += weightCounts[i] * n;  // B가 선택하는 경우의 수와 곱해주기
    }

    System.out.println(result);
  }

  private void mySolution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st1.nextToken());
    int m = Integer.parseInt(st1.nextToken());
    int[] balls = new int[n];

    StringTokenizer st2 = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      balls[i] = Integer.parseInt(st2.nextToken());
    }

    Arrays.sort(balls);

    int result = n * (n - 1) / 2;
    int ballCount = 0;
      
    for (int i = 0; i < n; i++) {
      ballCount++;
      
      if (i == n - 1 || balls[i] != balls[i + 1]) {
        result -= ballCount * (ballCount - 1) / 2;
        ballCount = 0;  
      }
    }

    System.out.println(result);
  }
}