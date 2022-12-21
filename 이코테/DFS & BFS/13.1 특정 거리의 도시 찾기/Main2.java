import java.util.*:
import java.io.*:

public class Main2 {

  // 도시의 개수, 도로의 개수, 거리 정보, 출발 도시 번호
  public int n, m, k, x;
  public ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  // 모든 도시에 대한 최단 거리 초기화
  public int[] d = new int[300001];

  public static void main(String[] args) throws Exception {
    new Main2().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());

    // 그래프 및 최단 거리 테이블 초기화
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Integer>());
      d[i] = -1;
    }

    // 모든 도로 정보 입력 받기
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
    }

    // 출발 도시까지의 거리는 0으로 설정
    d[x] = 0;

    // BFS를 이용해 각 도시별 최단 거리 계산
    bfs(x);

    // 최단 거리가 K인 모든 도시의 번호를 오름차순 입력
    boolean check = false;
    for (int i = 1; i <= n; i++) {
      if (d[i] == k) {
        System.out.println(i);
        check = true;
      }
    }

    // 만약 최단 거리가 K인 도시가 없다면, -1 출
    if (!check) System.out.println(-1);
  }

  public void bfs(int x) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(x);

    while (!q.isEmpty()) {
      int now = q.poll();
      // 현재 도시에서 이동할 수 있는 모든 도시 확인
      for (int i = 0; i < graph.get(now).size(); i++) {
        int nextNode = graph.get(now).get(i);
        // 아직 방문하지 않는 도시라면
        if (d[nextNode] == -1) {
          // 최단 거리 갱신
          d[nextNode] = d[now] + 1;
          q.offer(nextNode);
        }
      }
    }
  }
}