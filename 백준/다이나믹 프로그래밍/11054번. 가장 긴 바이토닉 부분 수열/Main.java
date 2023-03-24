import java.util.*;
import java.io.*;

class Main {

    int n;
    int[] a = new int[1001];
    int[] dp1 = new int[1002];
    int[] dp2 = new int[1002];
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            dp1[i] = 1;
            dp2[i] = 1;
        }

        // dp 초기화
        dp1[0] = 0;
        dp2[n + 1] = 0;
        
        // 증가(정순)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (a[i] > a[j]) dp1[i] = Math.max(dp1[i], dp1[j] + 1);
            }
        }

        // 증가(역순)
        for (int i = n; i >= 1; i--) {
            for (int j = n; j > i; j--) {
                if (a[i] > a[j]) dp2[i] = Math.max(dp2[i], dp2[j] + 1);
            }
        }

        // 바이토닉 부분 수열의 개수
        int answer = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = n; j > i; j--) {
                if (a[i] != a[j]) answer = Math.max(answer, dp1[i] + dp2[j]);
            }
        }

        System.out.println(answer);
    }
}