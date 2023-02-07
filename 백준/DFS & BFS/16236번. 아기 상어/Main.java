import java.util.*;
import java.io.*;

class Main {

  int n;
  int[][] arr = new int[20][20];
  boolean[][] visited;
  ArrayList<Node> fishes;
  int sharkX, sharkY;
  int sharkSize = 2;

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  
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
        if (x == 9) {
          arr[i][j] = 0;
          sharkX = i;
          sharkY = j;
        }
      }
    }

    int answer = 0;
    int count = 0;
    int totalCount = 0;
    
    while (true) {
      visited = new boolean[20][20];
      fishes = new ArrayList<Node>();
      
      bfs(sharkX, sharkY);
      
      if (fishes.isEmpty()) break;
      
      Collections.sort(fishes);
      
      Node fish = fishes.get(0);
      sharkX = fish.getX();
      sharkY = fish.getY();
      
      answer += fish.getDistance();
      arr[sharkX][sharkY] = 0;
      count++;
      totalCount++;

      if (count == sharkSize) {
        sharkSize++;
        count = 0;
      }
    }

    if (totalCount == 0) System.out.println(0);
    else System.out.println(answer);
  }

  public void bfs(int x, int y) {
    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(x, y, 0));
    visited[x][y] = true;

    while (!q.isEmpty()) {
      Node node = q.poll();
      x = node.getX();
      y = node.getY();
      int dist = node.getDistance();
      
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        int cost = dist + 1;

        if (nx >= 0 & nx < n && ny >= 0 && ny < n) {
          if (!visited[nx][ny] && sharkSize >= arr[nx][ny]) {
            if (arr[nx][ny] != 0 && sharkSize > arr[nx][ny]) fishes.add(new Node(nx, ny, cost));  
            q.offer(new Node(nx, ny, cost));
            visited[nx][ny] = true;
          }
        }
      }
    }
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
    if (this.distance == other.distance) {
      if (this.x == other.x) return this.y - other.y;
      return this.x - other.x;
    } 
    return this.distance - other.distance;
  }
}