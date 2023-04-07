import java.util.*;
import java.io.*;

class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    int n;
    int[][] arr = new int[500][500];
    long[][] dp = new long[500][500];
    long answer = 0;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                arr[i][j] = x;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                 dfs(i, j);
            }
        }

        System.out.println(answer + 1);
    }

    public long dfs(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (arr[x][y] < arr[nx][ny]) {
                    dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
                    answer = Math.max(answer, dp[x][y]);
                }
            }
        }

        return dp[x][y];
    }
}