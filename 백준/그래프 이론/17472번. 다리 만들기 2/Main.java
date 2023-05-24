import java.util.*;
import java.io.*;

class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    int n, m;
    int[][] graph = new int[10][10];
    boolean[][] visited = new boolean[10][10];
    int island = 1;
    ArrayList<Node> bridges = new ArrayList<>();
    int[] parent = new int[7];
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 나누기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    islandBFS(i, j);
                }
            }
        }

        // 연결할 수 있는 다리 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    if (graph[i][j] != 0) {
                        bridgeBFS(i, j, k, graph[i][j]);
                    }
                }
            }
        }

        // 거리가 짧은 순으로 다리 정렬
        Collections.sort(bridges);

        // 최소 신장 트리를 위해 parent 배열 초기화
        for (int i = 1; i < island; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        
        for (Node bridge : bridges) {
            int a = bridge.getX();
            int b = bridge.getY();
            int distance = bridge.getDistance();

            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                answer += distance;
            }
        }

        boolean flag = true;
        for (int i = 1; i < island; i++) {
            if (findParent(i) != 1) {
                flag = false;
                break;
            }
        }
        
        if (!flag) {
            System.out.println("-1");
        } else {
            System.out.println(answer);
        }
    }

    public void islandBFS(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));
        visited[x][y] = true;
        graph[x][y] = island;

        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            int dist = node.getDistance();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && graph[nx][ny] == 1) {
                        graph[nx][ny] = island;
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny, dist + 1));
                    }
                }
            }
        }

        island++;    // 섬 번호 증가
    }

    public void bridgeBFS(int x, int y, int direction, int start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            int dist = node.getDistance();
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] != island) {
                if (graph[nx][ny] == 0) {
                    q.offer(new Node(nx, ny, dist + 1));
                } else if (dist > 1) {
                    int end = graph[nx][ny];
                    bridges.add(new Node(start, end, dist));
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public int findParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }
}

class Node implements Comparable<Node> {

    private int x;
    private int y;
    private int distance;

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node other) {
        return this.distance - other.distance;
    }
}