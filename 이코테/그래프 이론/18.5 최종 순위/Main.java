import java.util.*;
import java.io.*;

class Main {

  int t;  // 테스트 케이스 수
  int n;  // 팀의 수
  int m;  // 상대적인 등수가 바뀐 쌍의 수
  int[] indegree = new int[501];  //  모든 노드에 대한 진입차수
  public static boolean[][] graph = new boolean[501][501];  // 각 노드에 연결된 간선 정보를 담기 위한 배열
  
  public static void main(String[] args) throws Exception {
    new Main().solution();
  }

  public void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    t = Integer.parseInt(br.readLine());

    for (int tc = 0; tc < t; tc++) {
      Arrays.fill(indegree, 0);
      for (int i = 0; i < 501; i++) {
        Arrays.fill(graph[i], false);
      }
      
      n = Integer.parseInt(br.readLine());

      // 작년 순위 정보 입력
      StringTokenizer st = new StringTokenizer(br.readLine());
      ArrayList<Integer> lastRank = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int x = Integer.parseInt(st.nextToken());
        lastRank.add(x);
      }

      // 방향 그래프의 간선 정보 초기화
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          graph[lastRank.get(i)][lastRank.get(j)] = true;
          indegree[lastRank.get(j)]++;
        }
      }

      // 올해 변경된 순위 정보 입력
      m = Integer.parseInt(br.readLine());
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (graph[a][b]) {
          graph[a][b] = false;
          graph[b][a] = true;
          indegree[a]++;
          indegree[b]--;
        } else {
          graph[a][b] = true;
          graph[b][a] = false;
          indegree[a]--;
          indegree[b]++;
        }
      }

      // 위상 정렬(Topolgy Sort) 시작
      ArrayList<Integer> result = new ArrayList<>();
      Queue<Integer> q = new LinkedList<>();

      // 처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
      for (int i = 1; i <= lastRank.size(); i++) {
        if (indegree[i] == 0) q.offer(i);
      }

      boolean certain = true;  // 위상 정렬 결과가 오직 하나인지의 여부
      boolean cycle = false;  // 그래프 내 사이클이 존재하는지 여부

      // 정확히 노드의 개수만큼 반복
      for (int i = 0; i < n; i++) {
        // 큐가 비어 있다면 사이클이 발생했다는 의미
        if (q.isEmpty()) {
          cycle = true;
          break;
        }

        // 큐의 원소가 2개 이상이라면 가능한 정렬 결과가 여러 개라는 의미
        if (q.size() >= 2) {
          certain = false;
          break;
        }

        // 일반적인 상황(결과가 1개)
        int now = q.poll();
        result.add(now);
        for (int j = 1; j <= n; j++) {
          if (graph[now][j]) {
            indegree[j]--;
            // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
            if (indegree[j] == 0) q.offer(j);
          }
        }
      }

      // 위상 정렬을 수행한 결과 출력
      if (cycle) bw.write("IMPOSSIBLE");
      else if (!certain) bw.write("?");
      else {
        for (int i = 0; i < result.size(); i++) {
          bw.write(String.valueOf(result.get(i)));
          bw.write(" ");
        }
      }
      bw.write("\n");
    }

    bw.flush();
    bw.close();
  }
}