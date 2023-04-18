import java.util.*;
import java.io.*;

class Main {

    int n;
    int[][] arr = new int[17][17];
    int[][][] dp = new int[17][17][3];    // 0:오른쪽, 1:왼쪽, 2:대각선
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][2][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 1) continue;
                
                // 1) 왼쪽 대각선 위 기준
                if (arr[i - 1][j] == 0 && arr[i][j - 1] == 0) {
                    dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
                // 2) 위 기준
                dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];
                // 3) 왼쪽 기준
                dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];
            }
        }

        System.out.println(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]);
    }
}

// class Main {

//     int n;
//     int[][] arr = new int[16][16];
//     int answer = 0;
    
//     public static void main(String[] args) throws Exception {
//         new Main().solution();
//     }

//     public void solution() throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         n = Integer.parseInt(br.readLine());

//         for (int i = 0; i < n; i++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             for (int j = 0; j < n; j++) {
//                 arr[i][j] = Integer.parseInt(st.nextToken());
//             }
//         }

//         dfs(0, 1, 0);

//         System.out.println(answer);
//     }

//     public void dfs(int x, int y, int direction) {
//         if (x == n - 1 && y == n - 1) {
//             answer++;
//             return;
//         }

//         if (direction == 0) {
//             if (y + 1 < n && arr[x][y + 1] == 0) dfs(x, y + 1, 0);
//         } else if (direction == 1) {
//             if (x + 1 < n && arr[x + 1][y] == 0) dfs(x + 1, y, 1);
//         } else {
//             if (y + 1 < n && arr[x][y + 1] == 0) dfs(x, y + 1, 0);
//             if (x + 1 < n && arr[x + 1][y] == 0) dfs(x + 1, y, 1);
//         }

//         if (x + 1 < n && y + 1 < n && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0) dfs(x + 1, y + 1, 2); 
//     }
// }