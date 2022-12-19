import java.util.*;
import java.io.*;

class Main {

  int n;  // 보드의 크기
  int result = 0;  // 최대 5번 이동시켜서 얻을 수 있는 가장 큰 블록

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    int[][] blocks = new int[n][n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      for (int j = 0; j < n; j++) {
        blocks[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    play(blocks, 0);

    System.out.println(result);
  }

  private void play(int[][] blocks, int depth) {
    if (depth == 5) {  // 이동 횟수가 5번을 초과하면 게임 종료  
      return;
    }
    
    // 4 방향에 대해 블록 이동시키기
    // 0 : 오른쪽, 1 : 왼쪽, 2 : 위쪽, 3 : 아래쪽
    for (int i = 0; i < 4; i++) {
      int[][] newBlocks = move(blocks, i);

      play(newBlocks, depth + 1);

      // 이동 후 만들 수 있는 최대 블록 계산
      for (int a = 0; a < n; a++) {
        for (int b = 0; b < n; b++) {
          if (newBlocks[a][b] > result) {
            result = newBlocks[a][b];
          }
        }
      }
    }
  }

  private int[][] move(int[][] blocks, int direction) {
    int[][] newBlocks = new int[n][n];
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        newBlocks[i][j] = blocks[i][j];
      }
    }
    
    if (direction == 0) {  // 오른쪽
      for (int i = 0; i < n; i++) {  
        int newIdx = n - 1;
        // 끝 열부터 첫 열까지 탐색
        for (int j = n - 1; j >= 0; j--) {
          if (blocks[i][j] == 0) continue;
          int next = j - 1;

          while (next >= 0) {
            if (blocks[i][next] != 0) {
              if (blocks[i][j] == blocks[i][next]) {
                newBlocks[i][newIdx--] = blocks[i][j] * 2;
              } else {
                newBlocks[i][newIdx--] = blocks[i][j];
                next = j;
              }
              break;
            }
            next--;
          }
          
          if (j == 0 || next == -1) newBlocks[i][newIdx--] = blocks[i][j];
          j = next;
        }
        // 블록 충돌 후, 남은 보드를 빈칸으로 채워준다
        for (int j = newIdx; j >= 0; j--) {
          newBlocks[i][j] = 0;
        }
      }
    }

    if (direction == 1) {  // 왼쪽
      for (int i = 0; i < n; i++) {  
        int newIdx = 0;
        // 끝 열부터 첫 열까지 탐색
        for (int j = 0; j <= n - 1; j++) {
          if (blocks[i][j] == 0) continue;
          int next = j + 1;

          while (next <= n - 1) {
            if (blocks[i][next] != 0) {
              if (blocks[i][j] == blocks[i][next]) {
                newBlocks[i][newIdx++] = blocks[i][j] * 2;
              } else {
                newBlocks[i][newIdx++] = blocks[i][j];
                next = j;
              }
              break;
            }
            next++;
          }

          if (j == n - 1 || next == n) newBlocks[i][newIdx++] = blocks[i][j];
          j = next;
        }
        // 블록 충돌 후, 남은 보드를 빈칸으로 채워준다
        for (int j = newIdx; j <= n - 1; j++) {
          newBlocks[i][j] = 0;
        }
      }
    }

    if (direction == 2) {  // 위쪽
      for (int j = 0 ; j <= n - 1; j++) {  
        int newIdx = 0;
        // 첫 행부터 끝 행까지 탐색
        for (int i = 0; i <= n - 1; i++) {
          if (blocks[i][j] == 0) continue;
          int next = i + 1;

          while (next <= n - 1) {
            if (blocks[next][j] != 0) {
              if (blocks[i][j] == blocks[next][j]) {
                newBlocks[newIdx++][j] = blocks[i][j] * 2;
              } else {
                newBlocks[newIdx++][j] = blocks[i][j];
                next = i;
              } 
              break;
            }
            next++;
          }
  
          if (i == n - 1 || next == n) newBlocks[newIdx++][j] = blocks[i][j]; 
          i = next;
        }
        // 블록 충돌 후, 남은 보드를 빈칸으로 채워준다
        for (int i = newIdx; i <= n - 1; i++) {
          newBlocks[i][j] = 0;
        }
      }
    }

    if (direction == 3) {  // 아래
      for (int j = 0 ; j <= n - 1; j++) {  
        int newIdx = n - 1;
        // 끝 행부터 첫 행까지 탐색
        for (int i = n - 1; i >= 0; i--) {
          if (blocks[i][j] == 0) continue;
          int next = i - 1;

          while (next >= 0) {
            if (blocks[next][j] != 0) {
              if (blocks[i][j] == blocks[next][j]) {
                newBlocks[newIdx--][j] = blocks[i][j] * 2;
              } else {
                newBlocks[newIdx--][j] = blocks[i][j];
                next = i;
              }          
              break;
            }
            next--;
          }

          if (i == 0 || next == -1) newBlocks[newIdx--][j] = blocks[i][j];
          i = next;
        }
        // 블록 충돌 후, 남은 보드를 빈칸으로 채워준다
        for (int i = newIdx; i >= 0; i--) {
          newBlocks[i][j] = 0;
        }
      }
    }

    return newBlocks;
  }
}