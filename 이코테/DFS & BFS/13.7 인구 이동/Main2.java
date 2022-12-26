import java.util.*;
import java.io.*:

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

class Main2 {

  // 땅의 크기(N), L, R
  public int n, l, r;
  public int totalCount = 0;

  // 전체 나라의 정보(N x N)
  public int[][] graph = new int[50][50];
  public int[][] unions = new int[50][50];

  public int[] dx = {-1, 0, 1, 0};
  public int[] dy = {0, -1, 0, 1};
  
  public static void main(String[] args) throws Exception {
    new Main2().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    n = Integer.parseInt(st.nextToken());
    l = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    // 더 이상 인구 이동을 할 수 없을 때까지 반복
    while (true) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          unions[i][j] = -1;
        }
      }

      int index = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (unions[i][j] == -1) {  // 해당 나라가 아직 방문 처리되지 않았다면 
            bfs(i, j, index);
            index++;
          }
        }
      }

      // 모든 인구 이동이 끝난 경우 (연합의 개수가 전체 나라의 개수가 될 때)
      if (index == n * n) break;
      
      totalCount++;
    }

    // 인구 이동 횟수 출력
    System.out.println(totalCount);
  }

  public void bfs(int x, int y, int index) {
    // (x, y)의 위치와 연결된 나라(연합) 정보를 담는 리스트
    ArrayList<Position> united = new ArrayList<>();
    united.add(new Position(x, y));
    // 너비 우선 탐색(BFS)을 위한 큐 라이브러리 사용
    Queue<Position> q = new LinkedList<>();
    q.offer(new Position(x, y));

    unions[x][y] = index; // 현재 연합의 번호 할당
    int summary = graph[x][y];  // 현재 연합의 전체 인구 수
    int count = 1;  // 현재 연합의 국가 수

    while (!q.isEmpty()) {
      Position pos = q.poll();
      x = pos.getX();
      y = pos.getY();
      // 현재 위치에서 4가지 방향을 확인하며
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        // 바로 옆에 있는 나라를 확인하여
        if (nx >= 0 && nx < n && ny >= 0 && ny < n && unions[nx][ny] == -1) {
          // 옆에 있는 나라와 인구 차이가 L명 이상, R명 이하라면
          int gap = Math.abs(graph[nx][ny] - graph[x][y]);

          if (l <= gap && gap <= r) {
            q.offer(new Position(nx, ny));
            // 연합에 추가하기
            united.add(new Position(nx, ny));
            unions[nx][ny] = index;
            summary += graph[nx][ny];
            count++;
          }
        }
      }
    }

    // 연합 국가끼리 인구를 분배
    for (int i = 0; i < united.size(); i++) {
      x = united.get(i).getX();
      y = united.get(i).getY();
      graph[x][y] = summary / count;
    }
  }
}