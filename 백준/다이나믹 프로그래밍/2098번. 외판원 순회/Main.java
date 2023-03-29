import java.util.*;
import java.io.*;

class Main {

    static final int INF = (int) 1e9;    
    
    int n;
    int[][] arr = new int[16][16];
    int[][] dp = new int[16][1 << 16];
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i], INF * 2);
            }
        }

        System.out.println(tsp(0, 1));
    }

    public int tsp(int target, int visited) {
        if (visited == (1 << n) - 1) {
            if (arr[target][0] == 0) return INF;    // 이때 리턴값은 DP 초깃값보다 작아야함.
            return arr[target][0];
        }

        if (dp[target][visited] != INF * 2) return dp[target][visited];

        for (int i = 0; i < n; i++) {
            if (arr[target][i] == 0) continue;
            
            if ((visited & (1 << i)) != 0) continue;
            
            int temp = arr[target][i] + tsp(i, visited | (1 << i));
            
            if (dp[target][visited] > temp) dp[target][visited] = temp;
        }

        return dp[target][visited];
    }
}