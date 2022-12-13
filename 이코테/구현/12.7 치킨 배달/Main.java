import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

  int n;
  int m;
  ArrayList<ArrayList<Integer>> houses = new ArrayList<ArrayList<Integer>>();
  ArrayList<ArrayList<Integer>> chickens = new ArrayList<ArrayList<Integer>>();
  ArrayList<Integer> cityChickenDistances = new ArrayList<>();
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());  // 도시의 크기
    m = Integer.parseInt(st.nextToken());  // 폐업시키지 않을 치킨집의 최대 개수

    // 도시의 정보 입력 받기
    // 집과 치킨집의 정보(좌표)를 각각의 리스트에 담는다.
    for (int i = 1; i <= n; i++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      
      for (int j = 1; j <= n; j++) {
        int cityInfo = Integer.parseInt(st2.nextToken());
        ArrayList<Integer> coordinate = new ArrayList<>();
        coordinate.add(i);
        coordinate.add(j);
      
        if (cityInfo == 1) houses.add(coordinate);  // 1은 '집'
        else if (cityInfo == 2) chickens.add(coordinate);  // 2는 '치킨집'
      }
    }

    // 조합(nCr)
    // n = 총 치킨집 개수
    // r = 폐업시키지 않을 치킨집의 최대 개수(m)
    boolean[] visited = new boolean[chickens.size()];
    combination(chickens, visited, 0, m);

    // 나올 수 있는 모든 도시의 치킨 거리를 오름차순 정렬
    Collections.sort(cityChickenDistances);

    System.out.println(cityChickenDistances.get(0));
  }

  // 임의의 두 칸 사이의 거리 계산
  private int getDistance(int r1, int r2, int c1, int c2) {
    return Math.abs(r1 - r2) + Math.abs(c1 - c2);
  }

  // `도시의 치킨 거리` 구하기 = `치킨 거리`의 합
  private int getCityChickenDistance(boolean[] visited) {
    int cityChickenDistance = 0;
    
    for (int i = 0; i < houses.size(); i++) {
      int r1 = houses.get(i).get(0);
      int c1 = houses.get(i).get(1);
      int chickenDistance = n * n;
      
      for (int j = 0; j < chickens.size(); j++) {
        if (visited[j]) {
          int r2 = chickens.get(j).get(0);
          int c2 = chickens.get(j).get(1);
          int distance = getDistance(r1, r2, c1, c2);
        
          if (chickenDistance > distance) chickenDistance = distance;
        }
      }

      cityChickenDistance += chickenDistance;
    }
    
    System.out.println("도시의 치킨 거리 : " + cityChickenDistance);
    
    return cityChickenDistance;
  }

  // 조합
  private void combination(ArrayList<ArrayList<Integer>> arr, boolean[] visited, int start, int r) {
    if (r == 0) {
      cityChickenDistances.add(getCityChickenDistance(visited));
      return;
    }

    for (int i = start; i < chickens.size(); i++) {
      visited[i] = true;
      combination(arr, visited, i + 1, r - 1);
      visited[i] = false;
    }
  }
}