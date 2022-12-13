import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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

class Combination {

  private int n;
  private int r;
  private int[] now;  // 현재 조합
  private ArrayList<ArrayList<Position>> result;  // 모든 조합

  public Combination(int n, int r) {
    this.n = n;
    this.r = r;
    this.now = new int[r];
    this.result = new ArrayList<ArrayList<Position>>();
  }

  public void combination(ArrayList<Position> arr, int depth, int index, int target) {
    if (depth == r) {
      ArryList<Position> temp = new ArrayList<>();

      for (int i = 0; i < now.length; i++) {
        temp.add(arr.get(now[i]));
      }

      return;
    }

    if (target == n) return;

    now[index] = target;
    combination(arr, depth + 1, index + 1, target + 1);
    combination(arr, depth, index, target + 1)
  }
  
  public ArrayList<ArrayList<Position>> getResult() {
    return this.result;
  }
}

class Main2 {

  public static int n, m;
  public static int[][] arr = new int[50][50];
  public static ArrayList<Position> chicken = new ArrayList<>();
  public static ArrayList<Poistion> house = new ArrayList<>();

  public static int getSum(ArrayList<Poistion> candidates) {
    int result = 0;  
    // 모든 집에 대하여
    for (int i = 0; i < house.size(); i++) {
      int hx = house.get(i).getX();
      int hy = house.get(i).getY();
      // 가장 가까운 치킨집 찾기
      int temp =  (int) 1e9;

      for (int j = 0; j < chicken.size(); j++) {
        int cx = chicken.get(i).getX();
        int cy = chicken.get(i).getY();
        
        temp = Math.min(temp, Math.abs(hx - cx) + Math.abs(hy - cy));
      }
      // 가장 가까운 치킨집까지의 거리를 더하기
      result += temp;
    }
    // 치킨 거리의 합 반환
    return result;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    for (int r = 0; r < n; r++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      
      for (int c = 0; c < n; c++) {
        arr[r][c] = Integer.parseInt(st2.nextToken());
        if (arr[r][c] == 1) house.add(new Position(r, c));  // 일반집
        else if (arr[r][c] == 2) chicken.add(new Position(r, c));  // 치킨
      }
    }

    // 모든 치킨집 중에서 m개의 치킨집을 뽑는 조합 계산
    Combination comb = new Combination(chicken.size(), m);
    comb.combination(chicken, 0, 0, 0);
    ArraryList<ArrayList<Position>> chickenList = comb.getResult();

    // 치킨 거리의 합의 최소를 찾아 출력
    int result = (int) 1e9;
    for (int i = 0; i < chickenList.size(); i++) {
      result = Math.min(result, getSum(chickenList.get(i)));
    }
    System.out.println(result);
  }
}