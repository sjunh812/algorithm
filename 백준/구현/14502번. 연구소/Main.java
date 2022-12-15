import java.util.*;
import java.io.*;

class Combination {

  private int n;
  private int m;
  private int r;
  private int max = 0;

  public int getMax() {
    return this.max;
  }
  
  public Combination(int n, int m, int r) {
    this.n = n;
    this.m = m;
    this.r = r;
  }
  
  public void combination(int[][] map, int start, int depth) {
    if (depth == r) {
      max = Math.max(max, getSafetyAreaCnt(map));     
      return;
    }

    for (int i = start; i < n * m; i++) {
      int x = i / m;
      int y = i % m;

      if (map[x][y] == 0) {
        map[x][y] = 1;
        combination(map, i + 1, depth + 1);
        map[x][y] = 0;
      }
    }
  }

  private int getSafetyAreaCnt(int[][] map) {
    int[][] newMap = new int[n][m];
    int cnt = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        newMap[i][j] = map[i][j];
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (newMap[i][j] == 2) spread(newMap, i, j); 
      }
    }
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (newMap[i][j] == 0) cnt++;
      }
    }

    return cnt;
  }

  private void spread(int[][] map, int x, int y) {
    if (x - 1 >= 0 && map[x - 1][y] == 0) {
      map[x - 1][y] = 2;
      spread(map, x - 1, y);
    } 
    if (x + 1 < n && map[x + 1][y] == 0) {
      map[x + 1][y] = 2;
      spread(map, x + 1, y);
    }
    if (y - 1 >= 0 && map[x][y - 1] == 0) {
      map[x][y - 1] = 2;
      spread(map, x, y - 1);
    }
    if (y + 1 < m && map[x][y + 1] == 0) {
      map[x][y + 1] = 2;
      spread(map, x, y + 1);
    }
  }
}

class Main {

  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] map = new int[n][m];

    for (int i = 0; i < n; i++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st2.nextToken());
      }
    }

    Combination comb = new Combination(n, m, 3);
    comb.combination(map, 0, 0);

    System.out.println(comb.getMax());
  }
}