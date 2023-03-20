import java.util.*;
import java.io.*;

class Main {

    int n;
    long m;
    long[] arr;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        long left = 1;
        long right = (long) 1e18;
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = getCount(mid);
            
            if (count >= m) right = mid - 1;
            else left = mid + 1;
        }

        System.out.println(left);
    }

    public long getCount(long totalTime) {
        long count = 0;
        
        for (long tableTime : arr) {
            count += totalTime / tableTime;
            if (count >= m) break;
        }

        return count;
    }
}