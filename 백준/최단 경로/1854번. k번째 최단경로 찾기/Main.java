import java.util.*;
import java.io.*;

class Main {

    static final long INF = Long.MAX_VALUE;

    int n, m, k;
    ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    ArrayList<PriorityQueue<Long>> dp = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
            dp.add(new PriorityQueue<Long>(Collections.reverseOrder()));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        dijkstra(1);

        for (int i = 1; i <= n; i++) {
            if (dp.get(i).size() != k) {
                bw.write("-1\n");
            } else {
                bw.write(dp.get(i).peek() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dp.get(start).add(0L);

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getNumber();
            long dist = node.getDistance();
            
            for (Node nextNode : graph.get(now)) {
                int next = nextNode.getNumber();
                long cost = nextNode.getDistance() + dist;

                if (dp.get(next).size() < k) {
                    dp.get(next).offer(cost);
                    pq.offer(new Node(next, cost));
                } else if (dp.get(next).peek() > cost) {
                    dp.get(next).poll();
                    dp.get(next).offer(cost);
                    pq.offer(new Node(next, cost));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {

    private int number;
    private long distance;

    public Node(int number, long distance) {
        this.number = number;
        this.distance = distance;
    }

    public int getNumber() {
        return this.number;
    }

    public long getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node other) {
        return Long.compare(this.distance, other.distance);
    }
}