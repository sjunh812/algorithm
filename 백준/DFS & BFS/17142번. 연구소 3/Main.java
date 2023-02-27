import java.util.*;
import java.io.*;

class Main {

  int n, m;
  int[][] graph = new int[50][50];
  boolean[][] visited = new boolean[50][50];
  ArrayList<Node> viruses = new ArrayList<>(); 
  int blankCnt = 0;
  int remainBlankCnt = 0;

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        int x = Integer.parseInt(st.nextToken());
        if (x == 0) blankCnt++;
        if (x == 2) viruses.add(new Node(i, j, 0));  
        graph[i][j] = x;
      }
    }

    // 활성할 바이러스 고르기 (조합)
    Combination comb = new Combination(viruses.size(), m);
    comb.combination(0, 0);
    ArrayList<ArrayList<Integer>> virusComb = comb.getResult();

    // BFS
    int answer = Integer.MAX_VALUE;
    for (ArrayList<Integer> virusList : virusComb) {
      int time = bfs(virusList);
      if (time != -1) answer = Math.min(answer, time);
      visited = new boolean[50][50];
      remainBlankCnt = 0;
    }

    if (answer == Integer.MAX_VALUE) System.out.println(-1);
    else System.out.println(answer);
  }

  public int bfs(ArrayList<Integer> virusList) {
    int time = 0;
    
    Queue<Node> q = new LinkedList<>();
    for (int index : virusList) {
      Node virus = viruses.get(index);
      q.offer(new Node(virus.getX(), virus.getY(), 0));
      visited[virus.getX()][virus.getY()] = true;
    }

    while (!q.isEmpty()) {
      Node node = q.poll();
      int x = node.getX();
      int y = node.getY();
      int dist = node.getDistance();

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
          if (!visited[nx][ny] && (graph[nx][ny] == 0 || graph[nx][ny] == 2)) {
            if (graph[nx][ny] == 0)  {
              remainBlankCnt++;
              time = Math.max(time, dist + 1);
            }
            q.offer(new Node(nx, ny, dist + 1));
            visited[nx][ny] = true;
          }
        }
      }
    }

    if (blankCnt != remainBlankCnt) time = -1;
    
    return time;
  }
}

class Combination {

  private int n;
  private int r;
  private int[] now;
  private ArrayList<ArrayList<Integer>> result;

  public Combination(int n, int r) {
    this.n = n;
    this.r = r;
    now = new int[r];
    result = new ArrayList<ArrayList<Integer>>();
  }

  public void combination(int depth, int target) {
    if (depth == r) {
      ArrayList<Integer> temp = new ArrayList<>();
      for (int i : now) {
        temp.add(i);
      }
      result.add(temp);
      
      return;
    }

    if (target == n) return;

    now[depth] = target;
    combination(depth + 1, target + 1);
    combination(depth, target + 1);
  }

  public ArrayList<ArrayList<Integer>> getResult() {
    return this.result;
  }
}

class Node {

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
}