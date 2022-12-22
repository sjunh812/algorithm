import java.util.*;
import java.io.*;

class Main {

  int n;  // 지도의 세로 크기(행)
  int m;  // 지도의 가로 크기(열)
  int[][] map;  // 지도

  // 바이러스 이동 방향(상, 하, 좌, 우)
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};

  int result = 0;  // 안전 영역 크기의 최댓값
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 지도의 세로, 가로 크기 N, M 입력 받기
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    // 지도 그리기
    map = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 벽 세우기
    buildWall(map, 0);

    // 안전 영역의 최댓값 출력 하기
    System.out.println(result);
  }

  // 벽 세우기(무조건 3개)
  private void buildWall(int[][] map, int count) {
    if (count == 3) {  // 벽을 3개 세울 때
      checkSafetyArea(map); 
      return;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 0) {  // 빈 칸일 때
          map[i][j] = 1;
          buildWall(map, count + 1);
          map[i][j] = 0;
        }
      }
    }
  }

  // 벽을 모두 세우고 바이러스가 모두 퍼졌을 때, 안전 영역 크기 계산
  private void checkSafetyArea(int[][] map) {
    int size = 0;
    int[][] newMap = new int[n][m];  // 바이러스가 퍼진 뒤의 새로운 지도

    // 지도 복사
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        newMap[i][j] = map[i][j];
      }
    }

    // 바이러스 퍼지기
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dfs(newMap, i, j);
      }
    }

    // 안전 영역 크기 계산
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (newMap[i][j] == 0) size++;
      }
    }

    // 안전 영역 크기 최댓값 계산
    result = Math.max(result, size);
  }

  private boolean dfs(int[][] map, int x, int y) {
    // 바이러스가 퍼질 수 없는 때
    if (map[x][y] != 2) return false;

    // 4방향에 대해 바이러스가 퍼질 수 있는지 검사
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      // 바이러스가 퍼질 곳이 지도 범위 내에 있을 때
      if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
        // 빈 칸일 때, 바이러스 퍼짐
        if (map[nx][ny] == 0) {
          map[nx][ny] = 2;  // 바이러스 방문 처리
          dfs(map, nx, ny);
        }
      }
    }

    return true;
  }
}