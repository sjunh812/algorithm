import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
        
    ArrayList<ArrayList<Node>> spaces = new ArrayList<>();  // 블록을 넣은 빈칸의 좌표 리스트
    ArrayList<ArrayList<Node>> puzzles = new ArrayList<>(); // 블록의 좌표 리스트
    
    public int solution(int[][] game_board, int[][] table) {
        boolean[][] visitedGameBoard = new boolean[game_board.length][game_board.length];
        boolean[][] visitedTable = new boolean[table.length][table.length];
        
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board.length; j++) {
                if (!visitedGameBoard[i][j] && game_board[i][j] == 0) { // 빈칸(0)
                    bfs(i, j, game_board, visitedGameBoard, spaces, 0);
                }
                
                if (!visitedTable[i][j] && table[i][j] == 1) {  // 블록(1)
                    bfs(i, j, table, visitedTable, puzzles, 1);
                }
            }
        }
        
        return getFitPuzzleCount();
    }
    
    public int getFitPuzzleCount() {
        int count = 0;
        boolean[] usedPuzzles = new boolean[puzzles.size()];
        
        for (int i = 0; i < spaces.size(); i++) {
            ArrayList<Node> space = spaces.get(i);
            
            for (int j = 0; j < puzzles.size(); j++) {
                ArrayList<Node> puzzle = puzzles.get(j);
                
                if (space.size() == puzzle.size() && checkRotate(space, puzzle) && !usedPuzzles[j]) {
                    usedPuzzles[j] = true;
                    count += space.size();
                    break;
                }
            }
        }
        
        return count;
    }
    
    public boolean checkRotate(ArrayList<Node> space, ArrayList<Node> puzzle) {
        Collections.sort(space);
        
        for (int i = 0; i < 4; i++) {
            // 0: 원본  1: 90도  2: 180도 3: 270도
            Collections.sort(puzzle);
            
            int startX = puzzle.get(0).getX();
            int startY = puzzle.get(0).getY();
                        
            for (int j = 0; j < puzzle.size(); j++) {
                puzzle.get(j).setX(puzzle.get(j).getX() - startX);
                puzzle.get(j).setY(puzzle.get(j).getY() - startY);
            }
            
            boolean flag = true;
            
            for (int j = 0; j < space.size(); j++) {
                if (space.get(j).getX() != puzzle.get(j).getX() || space.get(j).getY() != puzzle.get(j).getY()) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                return true;
            } else {
                for (int j = 0; j < puzzle.size(); j++) {
                    int temp = puzzle.get(j).getX();
                    puzzle.get(j).setX(puzzle.get(j).getY());
                    puzzle.get(j).setY(-temp);
                }   
            }
        }
        
        return false;
    }
    
    public void bfs(
        int startX, 
        int startY, 
        int[][] arr, 
        boolean[][] visited, 
        ArrayList<ArrayList<Node>> list, 
        int check
    ) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startX, startY));
        visited[startX][startY] = true;
        
        ArrayList<Node> subList = new ArrayList<>();
        subList.add(new Node(0, 0));
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < visited.length && ny >= 0 && ny < visited.length) {
                    if (!visited[nx][ny] && arr[nx][ny] == check) {
                        q.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                        subList.add(new Node(nx - startX, ny - startY));
                    }
                }
            }
        }
        
        list.add(subList);
    }
}

class Node implements Comparable<Node> {
    
    private int x;
    private int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public int compareTo(Node other) {
        if (this.x == other.x) return this.y - other.y;
        return this.x - other.x;
    }
}