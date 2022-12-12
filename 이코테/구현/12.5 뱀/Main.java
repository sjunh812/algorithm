import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

  public static void main(String[] args) throws Exception {
    new Main().mySolution();
  }

  private void mySolution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());  // 보드의 크기
    int k = Integer.parseInt(br.readLine());  // 사과의 개수
    int[][] board = new int[n + 2][n + 2];

    // 보드에 사과(1) 표시하기
    for (int i = 0; i < k; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int row = Integer.parseInt(st.nextToken());
      int column = Integer.parseInt(st.nextToken());

      board[row][column] = 1;
    }

    int l = Integer.parseInt(br.readLine());  // 뱀의 방향 변환 횟수
    Queue<TransDirection> transDirections = new LinkedList<>();  // 뱀의 방향 변환 정보를 담은 큐

    // 뱀의 방향 변환 정보 저장하기
    for (int i = 0; i < l; i++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      int second = Integer.parseInt(st2.nextToken());
      String direction = st2.nextToken();

      transDirections.offer(new TransDirection(second, direction));
    }


    // 오른쪽(0), 아래(1), 왼쪽(2), 위(3) 
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    // 뱀의 몸통 정보
    ArrayList<SnackBody> snackBodies = new ArrayList<>();
    snackBodies.add(new SnackBody(1, 1, 0));

    int x = 1;  // 현재 보드의 열
    int y = 1;  // 현재 보드의 행
    int result = 0;   

    // 게임 시작
    while (true) {
      result++;  // 시간(초) 갱신
      
      SnackBody head = snackBodies.get(0);  // 이동 전 뱀의 머리
      int nx = x + dx[head.getDirection()];  // 이동할 열
      int ny = y + dy[head.getDirection()];  // 이동할 행

      if (nx == 0 || ny == 0 || nx > n || ny > n) {  // 이동한 칸이 벽인 경우
        break;
      } else {
        x = nx;  
        y = ny;
        snackBodies.add(0, new SnackBody(x, y, head.getDirection()));
        
        if (board[ny][nx] == 1) {  // 이동한 칸에 사과가 있는 경우
          board[ny][nx] = 0;
        } else {  // 이동한 칸에 사과가 없는 경우
          boolean finishFlag = false;
          SnackBody newHead = snackBodies.get(0);  // 이동 후 뱀의 머리

          for (int i = 1; i < snackBodies.size(); i++) {
            SnackBody body = snackBodies.get(i);
    
            if (newHead.getX() == body.getX() && newHead.getY() == body.getY()) {  // 뱀의 머리와 몸통이 부딪힘
              finishFlag = true;
              break;
            }
          }
    
          if (finishFlag) break; 
          
          snackBodies.remove(snackBodies.size() - 1);
        }
      } 
                                                                     
      // 뱀의 방향 변환 정보 갱신
      TransDirection trans = transDirections.peek();
      SnackBody newHead = snackBodies.get(0); 
      if (trans != null && result == trans.getSecond()) {
        int curDirection = newHead.getDirection();       
        newHead.setDirection(transDirections.poll().getDirection(curDirection));
      }

      // 뱀 위치 출력
      System.out.println();
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          int b = board[i][j];
          boolean flag = false;
          
          for (int m = 0; m < snackBodies.size(); m++) {
            SnackBody body = snackBodies.get(m);

            if (i == body.getY() && j == body.getX()) {
              System.out.print("x");
              flag = true;
              break;
            }
          }

          if (!flag) System.out.print(b);
        }
        
        System.out.println();
      }
      System.out.println();
    }

    // 결과 출력
    System.out.println(result);
  }
}

class TransDirection {

  private int second;
  private String direction;

  public TransDirection(int second, String direction) {
    this.second = second;
    this.direction = direction;
  }

  public int getSecond() {
    return this.second;
  }

  public int getDirection(int curDirection) {
    if (direction.equals("L")) {
      if (curDirection == 0) return 3;
      else return curDirection - 1;
    } else {
      if (curDirection == 3) return 0;
      else return curDirection + 1;
    }
  }
}

class SnackBody {

  private int x;
  private int y;
  private int direction;

  public SnackBody(int x, int y, int direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
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

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setDirection(int direction) {
    this.direction = direction;
  }
}