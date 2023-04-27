import java.util.*;
import java.io.*;

class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    int h, w;
    char[][] arr = new char[100][100];
    int[][] targets = new int[2][2];
    int[][][] dp = new int[100][100][4];
    int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());    // 열
        h = Integer.parseInt(st.nextToken());    // 행

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        int targetIndex = 0;        
        for (int i = 0; i < h; i++) {
            String line = br.readLine();
            for (int j = 0; j < w; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'C') {
                    targets[targetIndex][0] = i;
                    targets[targetIndex++][1] = j;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            dijkstra(targets[0][0], targets[0][1], i);
        }

        System.out.println(answer);
    }

    public void dijkstra(int x, int y, int direction) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, y, direction, 0));
        dp[x][y][direction] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            x = node.getX();
            y = node.getY();
            int dir = node.getDirection();
            int mirrors = node.getMirrors();

            if (dp[x][y][dir] < mirrors) continue;

            if (x == targets[1][0] && y == targets[1][1]) {
                answer = Math.min(answer, mirrors);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < h && ny >= 0 && ny < w && arr[nx][ny] != '*') {
                    int nextMirrors = mirrors;
                    if (dir != i) nextMirrors++;

                    if (dp[nx][ny][i] > nextMirrors) {
                        dp[nx][ny][i] = nextMirrors;
                        pq.offer(new Node(nx, ny, i, nextMirrors));
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node> {

    private int x;
    private int y;
    private int direction;    // 0:상, 1:하, 2:좌, 3:우
    private int mirrors;

    public Node(int x, int y, int direction, int mirrors) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.mirrors = mirrors;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getDirection() {
        return this.direction;
    }

    public int getMirrors() {
        return this.mirrors;
    }

    @Override
    public int compareTo(Node other) {
        return this.mirrors - other.mirrors;
    }
}