import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

  public static void main(String[] args) {
    int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
    int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
    
    new Main().solution(key, lock);
  }

  public int[][] rotateMatrixBy90Degree(int[][] a) {
    int n = a.length;
    int m = a[0].length;
    int[][] result = new int[n][m];  // 결과 리스트

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        result[j][n - i - 1] = a[i][j];
      }
    }

    return result;
  }

  public boolean check(int[][] newLock) {
    int lockLength = newLock.length / 3;

    for (int i = lockLength; i < lockLength * 2; i++) {
      for (int j = lockLength; j < lockLength * 2; j++) {
        if (newLock[i][j] != 1) {
          return false;
        }
      }
    }

    return true;
  }

  public boolean solution(int[][] key, int[][] lock) {
    int n = lock.length;
    int m = key.length;
    // 자물쇠의 크기를 기존의 3배로 변환
    int[][] newLock = new int[n * 3][n * 3];
    // 새로운 자물쇠의 중앙 부분에 기존의 자물쇠 넣기
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        newLock[i + n][j + n] = lock[i][j];
      }
    }

    // 4가지 방향에 대해서 확인
    for (int rotation = 0; rotation < 4; rotation++) {
      key = rotateMatrixBy90Degree(key);

      for (int x = 0; x < n * 2; x++) {
        for (int y = 0; y < n * 2; y++) {
          // 자물쇠에 열쇠를 끼워 넣기
          for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
              newLock[x + i][x + j] += key[i][j];
            }
          }

          // 새로운 자물쇠에 열쇠가 정확히 들어 맞는지 검사
          if (check(newLock)) return true;

          // 자물쇠에서 열쇠를 다시 빼기
          for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
              newLock[x + i][x + j] -= key[i][j];
            }
          }
        }
      }
    }

    return false;
  }
  
  private int[][] myRotateKey(int[][] key) {
    int[][] newKey = new int[key.length][key.length];
      
    // 90도 회전
    // 1. x축 대칭
    // 2. y = x 대칭
    for (int i = 0; i < key.length; i++) {
      for (int j = 0; j < key[i].length; j++) {
          newKey[j][key.length - i - 1] = key[i][j];
      }
    }
    
    return newKey;
  }
  
  private boolean myCheck(int[][] arr, int len) {
    // 열쇠로 자물쇠를 열 수 있는지 판별
    // 자물쇠 안 원소가 모두 1 이어야 한다.
    for (int i = len - 1; i < 2 * len - 1; i++) {
      for (int j = len - 1; j < 2 * len - 1; j++) {
          if (arr[i][j] != 1) return false;
      }
    }
    
    return true;
  }
  
  public boolean mySolution(int[][] key, int[][] lock) {
    int keyLen = key.length;  // 열쇠 길이
    int lockLen = lock.length;  // 자물쇠 길이
    int[][] arr = new int[3 * lockLen - 2][3 * lockLen - 2];  // 완전 탐색이 가능한 배열 생성
    
    // 새로 만든 배열에 자물쇠 값 넣어주기
    for (int i = 0; i < lock.length; i++) {
      for (int j = 0; j < lock.length; j++) {
          arr[lockLen - 1 + i][lockLen - 1 + j] = lock[i][j];
      }
    }
    
    // 왼쪽 상단부터 열쇠를 대입해서 확인
    // 자물쇠에 들어있는 칸이 모두 1이면 됨!
    for (int i = 0; i <= arr.length - keyLen; i++) {
      for (int j = 0; j <= arr.length - keyLen; j++) {
        // 회전 가능한 4 방향 모두 비교
        for (int k = 0; k < 4; k++) {
          key = myRotateKey(key); // 90도 회전
          
          // 배열에 열쇠 값 넣기
          for (int m = 0; m < key.length; m++) {
            for (int p = 0; p < key[m].length; p++) {
                arr[i + m][j + p] += key[m][p];
            }
          }
          
          if (myCheck(arr, lockLen)) return true;
          
          // 배열에 열쇠 값 빼기
          for (int m = 0; m < key.length; m++) {
            for (int p = 0; p < key[m].length; p++) {
                arr[i + m][j + p] -= key[m][p];
            }
          }
        }
      }
    }
    
    return false;
  }
}