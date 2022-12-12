import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node {

  private int time;
  private String direction;

  public Node(int time, String direction) {
    this.time = time;
    this.direction = direction;
  }

  public int getTime() {
    return this.time;
  }

  public String getDirection() {
    return this.direction;
  }
}

class Position {

  private int x;
  private int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }
}

public class Main2 {

  public static int n, k, l;
  public static int[][] arr = new int[101][101];  // 맵 정보
  public static ArrayList<Node> info = new ArrayList<>();  // 방향 회전 정보

  // 처음에는 오른쪽을 보고 있으므로(동, 남, 서, 북)
  public static int[] dx = {0, 1, 0, -1};
  public static int[] dy = {1, 0, -1, 0};

  public static int turn(int direction, String c) {
    if (c == "L") direction = (direction == 0) ? 3 : direction - 1;
    else direction = (direction + 1) % 4;

    return direction;
  }

  public static int simulate() {
    int x = 1, y = 1;  // 뱀의 머리 위치 
    arr[x][y] = 2;  // 뱀이 존재하는 위치는 2로 표시
    int direction = 0;  // 처음에는 동쪽을 보고 있음
    int time = 0;  // 시작한 뒤에 지난 '초' 시간
    int index = 0;  // 다음에 회전할 정보
    // 뱀이 차지하고 있는 위치(꼬리가 앞)
    Queue<Position> q = new LinkedList<>();
    q.offer(new Position(x, y));

    while (true) {
      int nx = x + dx[direction];
      int ny = y + dy[direction];
      
      if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && arr[nx][ny] != 2) {  // 맵 범위 안에 있고, 뱀의 몸통이 없는 위치라면
        // 사과가 없다면 이동 후에 꼬리 제거
        if (arr[nx][ny] == 0) {
          arr[nx][ny] = 2;
          q.offer(new Position(nx, ny));
          Position prev = q.poll();  // 제거할 꼬리
          arr[prev.getX()][prev.getY()] = 0;
        }
        // 사과가 있다면 이동 후에 꼬리 그대로 두기
        if (arr[nx][ny] == 1) {
          arr[nx][ny] = 2;
          q.offer(new Position(nx, ny));
        }
      } else {  // 벽이나 뱀의 몸통과 부딪혔다면 
        time++;
        break;
      }

      // 다음 위치로 머리를 이동
      x = nx;
      y = ny;
      time++;
      if (index < l && time == info.get(index).getTime()) {  // 회전할 시간인 경우 회전
        direction = turn(direction, info.get(index).getDirection());
        index++;
      }
    }

    return time;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    k = Integer.parseInt(br.readLine());

    // 맵 정보(사과가 있는 곳은 1로 표시)
    for (int i = 0; i < k; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[a][b] = 1;
    }

    // 방향 회전 정보 입력
    l = Integer.parseInt(br.readLine());
    for (int i = 0; i < l; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      String c = st.nextToken();
      info.add(new Node(x, c));
    }

    System.out.println(simulate());
  }
}