import java.util.*;
import java.io.*;

class Main {

    static final long INF = Long.MAX_VALUE;
    
    int n, m, k;
    ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    long[][] dp = new long[10001][21];
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
            Arrays.fill(dp[i], INF);
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향 도로
            graph.get(a).add(new Node(b, 0, c));
            graph.get(b).add(new Node(a, 0, c));
        }

        dijkstra(1);

        long answer = INF;

        // 도로의 개수가 포장할 수 있는 도로의 개수보다 작은 경우가 있음.
        for (int i = 0; i <= k; i++) {
            answer = Math.min(answer, dp[n][i]);
        }
        
        System.out.println(answer);
    }

    public void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0, 0));
        dp[start][0] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getNumber();
            int wrap = node.getWrap();
            long dist = node.getDistance();

            if (dp[now][wrap] < dist) continue;
            
            for (Node nextNode : graph.get(now)) {
                int next = nextNode.getNumber();
                long cost = nextNode.getDistance() + dist;

                if (dp[next][wrap] > cost) {
                    dp[next][wrap] = cost;
                    pq.offer(new Node(next, wrap, cost));
                }

                if (wrap < k && dp[next][wrap + 1] > cost - nextNode.getDistance()) {
                    dp[next][wrap + 1] = cost - nextNode.getDistance();
                    pq.offer(new Node(next, wrap + 1, cost - nextNode.getDistance()));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {

    private int number;
    private int wrap;
    private long distance;

    public Node(int number, int wrap, long distance) {
        this.number = number;
        this.wrap = wrap;
        this.distance = distance;
    }

    public int getNumber() {
        return this.number;
    }

    public int getWrap() {
        return this.wrap;
    }

    public long getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node other) {
        return Long.compare(this.distance, other.distance);
    }
}