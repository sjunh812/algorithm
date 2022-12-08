import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private int turnLeft(int direction) {
    direction--;
    if (direction == -1) direction = 3;
    
    return direction;
  }
  
  private void solution() throws Exception {
    // 방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화 
    int[][] d = new int[50][50];
    // 전체 맵 정보
    int[][] arr = new int[50][50];

    // 북, 동, 남, 서 방향 정의
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // N, M을 공백을 기준으로 구분하여 입력받기
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 현재 캐릭터의 x 좌표, y 좌표, 방향을 입력 받기
    // x = 북쪽으로부터 떨어진 칸의 개수
    // y = 서쪽으로부터 떨어진 칸의 개수
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st2.nextToken());
    int y = Integer.parseInt(st2.nextToken());
    int direction = Integer.parseInt(st2.nextToken());
    d[x][y] = 1;  // 현재 좌표 방문 처리

    // 전체 앱 정보를 입력 받기 
    for (int i = 0; i < n; i++) {
      StringTokenizer st3 = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st3.nextToken());
      }
    }

    // 시뮬레이션 시작
    int cnt = 1;
    int turnTime = 0;
    while (true) {
      // 왼쪽으로 회전
      direction = turnLeft(direction);
      int nx = x + dx[direction];
      int ny = y + dy[direction];
      // 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
      if (d[nx][ny] == 0 && arr[nx][ny] == 0) {
        d[nx][ny] = 1;
        x = nx;
        y = ny;
        cnt++;
        turnTime = 0;
      } else {
        turnTime++;
      }

      if (turnTime == 4) {
        nx = x - dx[direction];
        ny = y - dy[direction];
        
        if (arr[nx][ny] == 0) {  // 뒤로 갈 수 있다면 이동하기
          x = nx;
          y = ny;
        } else {  // 뒤가 바다로 막혀있는 경우
          break;
        }
        
        turnTime = 0;
      }
    }

    System.out.println(cnt);
  }

  private void mySolution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // n x m 맵 
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 캐릭터 위치(x, y) 및 방향
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st2.nextToken());
    int y = Integer.parseInt(st2.nextToken());
    int direction = Integer.parseInt(st2.nextToken());

    // 맵 그리기
    int[][] map = new int[n][m];  // 바다 및 육지 정보가 담긴 맵
    int[][] route = new int[n][m];  // 캐릭터 방문 여부를 체크하기 위한 맵
    route[x][y] = 1;  // 처음 캐릭터가 위치한 칸 방문 체크
    for (int i = 0; i < n; i++) {
      StringTokenizer st3 = new StringTokenizer(br.readLine());
      
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st3.nextToken());
      }
    }

    // 방향에 따른 전진 경로(후진 경로는 -1을 곱해주면 됨.)
    // 북 동 남 서
    int[] dx = {-1, 0, 1, 0};  // 행
    int[] dy = {0, 1, 0, -1};  // 열

    int result = 1;
    System.out.println("(" + x + "," + y + ")");
    
    while (true) {
      boolean case2 = false;
      
      for (int i = direction - 1; i >= direction - 4; i--) {
        int index;
        if (i < 0) index = i + 4;
        else index = i;
        
        int nx = x + dx[index];
        int ny = y + dy[index];

        if (route[nx][ny] == 0 && map[nx][ny] == 0) {
          case2 = true;
          route[nx][ny] = 1;
          x = nx;
          y = ny;
          direction = index;
          result++;
          
          System.out.println("(" + x + "," + y + ")");
          
          break;
        }
      }

      if (!case2) {  // 네 방향 모두 이미 가본 칸이거나, 바다로 되어있는 경우 → 한 칸 뒤로
        int nx = x - dx[direction];
        int ny = y - dy[direction];

        if (map[nx][ny] == 0) {
          x = nx;
          y = ny;         
        } else {  // 움직임을 멈춘다.
          break;
        }
      }
    }

    System.out.println(result);
  }
}