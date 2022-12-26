import java.util.*;
import java.io.*;

class Main {

  int n;  // 땅의 크기
  
  // 연합을 이루는 인접한 두 나라의 인구 차이 범위
  int l;
  int r;

  int[][] population;  // 나라별 인구 수
  int result = 0;  // 인구 이동 횟수

  // 인접한 나라의 이동 방향
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    l = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    // 나라별 인구 수 채우기
    population = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        population[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    while (true) {
      int[][] visited = new int[n][n];
      int unionCnt = 0;
      
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          ArrayList<ArrayList<Integer>> union = new ArrayList<>();
          dfs(union, visited, i, j);
          if (union.size() > 1) {
            // System.out.println("연합 국가 수 : " + union.size());
            updatePopulation(union);
            unionCnt++;
          }
        }
      }

      if (unionCnt == 0) break;
      else result++;
    }

    System.out.println(result);
  }

  private void dfs(ArrayList<ArrayList<Integer>> union, int[][] visited, int x, int y) {
    if (visited[x][y] == 1) return;

    ArrayList<Integer> temp = new ArrayList<>();
    temp.add(x);
    temp.add(y);
    union.add(temp);
    visited[x][y] = 1;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
        if (visited[nx][ny] == 0) {
          int difference = Math.abs(population[x][y] - population[nx][ny]);
          if (difference >= l && difference <= r) dfs(union, visited, nx, ny);
        }
      }
    }
  }

  private void updatePopulation(ArrayList<ArrayList<Integer>> union) {
    int sum = 0;
    
    for (int i = 0; i < union.size(); i++) {
      int x = union.get(i).get(0);
      int y = union.get(i).get(1);
      sum += population[x][y];
    }

    int balance = sum / union.size();
    
    for (int i = 0; i < union.size(); i++) {
      int x = union.get(i).get(0);
      int y = union.get(i).get(1);
      population[x][y] = balance;
    }
  }
}