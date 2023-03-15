import java.util.*;
import java.io.*;

class Main {

    int t, n, m;
    int[] a = new int[1000];
    int[] b = new int[1000];
    ArrayList<Integer> aList = new ArrayList<>();
    ArrayList<Integer> bList = new ArrayList<>();
    long answer = 0;
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                aList.add(sum);
            }
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += b[j];
                bList.add(sum);
            }
        }

        Collections.sort(aList);
        Collections.sort(bList);

        for (int aSum : aList) {
            answer += countByRange(t - aSum, t - aSum);
        }

        System.out.println(answer);
    }

    public int countByRange(int leftValue, int rightValue) {
        int leftIndex = lowerBound(leftValue, 0, bList.size() - 1);
        int rightIndex = upperBound(rightValue, 0, bList.size() - 1);

        return rightIndex - leftIndex;
    }

    public int lowerBound(int value, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (bList.get(mid) >= value) end = mid - 1;
            else start = mid + 1;
        }

        return start;
    }

    public int upperBound(int value, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (bList.get(mid) <= value) start = mid + 1;
            else end = mid - 1;
        }

        return start;
    }
}