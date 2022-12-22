import java.util.*;
import java.io.*;

class Virus implements Comparable<Virus> {

  private int index;
  private int second;
  private int x;
  private int y;

  public Virus(int index, int second, int x, int y) {
    this.index = index;
    this.second = second;
    this.x = x;
    this.y = y;
  }

  public int getIndex() {
    return this.index;
  }

  public int getSecond() {
    return this.second;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  // 정렬 기준은 '번호가 낮은 순서'
  @Override
  public int compareTo(Virus other) {
    if (this.index < other.index) return -1;
    else return 1;
  }
}

public class Main2 {

  public int n, k;
  // 전체 보드 정보를 담는 배열
  public int[][] graph = new int[200][200];
  public ArrayList<Virus> viruses = new ArrayList<>();

  public int targetS, targetX, targetY;
  
  // 바이러스가 퍼져나갈 수 있는 4가지의 위치
  int[] dx = {-1, 0, 1, 0};
  int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws Exception {
    new Main2().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      
      for (int j = 0; j < n; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
        // 해당 위치에 바이러스가 존재하는 경우
        if (graph[i][j] != 0) {
          // (바이러스 종류, 시간, 위치 x, 위치 y) 삽입
          viruses.add(new Virus(graph[i][j], 0, i, j));
        }
      }
    }

    st = new StringTokenizer(br.readLine());
    targetS = Integer.parseInt(st.nextToken());
    targetX = Integer.parseInt(st.nextToken());
    targetY = Integer.parseInt(st.nextToken());
    
    // 오름차순 정렬 (낮은 번호의 바이러스가 먼저 증식하므로)
    Collections.sort(viruses);

    // 너비 우선 탐색(BFS) 진행
    bfs();

    // 결과 출력
    System.out.println(graph[targetX - 1][targetY - 1]);
  }
  
  public void bfs() {
    Queue<Virus> q = new LinkedList<>();
    for (Virus virus : viruses) {
      q.offer(virus);
    }

    while (!q.isEmpty()) {
      Virus virus = q.poll();
      // 정확히 second 만큼 초가 지나거나, 큐가 빌 때까지 반복
      if (virus.getSecond() == targetS) break;
      // 현재 노드에서 주변 4가지 위치를 각각 확인
      for (int i = 0; i < 4; i++) {
        int nx = virus.getX() + dx[i];
        int ny = virus.getY() + dy[i];
        // 해당 위치로 이동할 수 있는 경우
        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
          // 아직 방문하지 않은 위치라면, 그 위치에 바이러스 넣기
          if (graph[nx][ny] == 0) {
            graph[nx][ny] = virus.getIndex();
            q.offer(new Virus(virus.getIndex(), virus.getSecond() + 1, nx, ny));
          }
        }
      }
    }
  }
}