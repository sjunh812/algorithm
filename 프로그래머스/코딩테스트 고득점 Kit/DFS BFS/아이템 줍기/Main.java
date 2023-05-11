import java.util.*;

class Solution {
   
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};
    
    int[][] rectangle;
    int[][] visited = new int[51][51];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        this.rectangle = rectangle;
        
        for (int i = 0; i <= 50; i++) {
            Arrays.fill(visited[i], -1);
        }
        
        bfs(characterX, characterY);
        
        return visited[itemX][itemY];
    }
    
    public void bfs(int x, int y) {
        Queue<Character> q = new LinkedList<>();
        q.offer(new Character(x, y, 0));
        visited[x][y] = 0;
        
        while (!q.isEmpty()) {
            Character character = q.poll();
            x = character.getX();
            y = character.getY();
            int dist = character.getDistance();
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx > 0 && ny > 0 && nx < 51 && ny < 51 && visited[nx][ny] == -1 && checkRoute(x, y, nx, ny, i)) {
                    q.offer(new Character(nx, ny, dist + 1));
                    visited[nx][ny] = dist + 1;
                }
            }
        }
    }   
        
    public boolean checkRoute(int x, int y, int nx, int ny, int direction) {
        int count = 0;
        
        for (int i = 0; i < rectangle.length; i++) {     
            if (checkInside(rectangle[i], nx, ny)) {    // 직사각형 안
                return false;
            }
            
            if (checkEdge(rectangle[i], x, y) && checkEdge(rectangle[i], nx, ny)) { // 직사각형 모서리
                if (checkCorner(rectangle[i], nx, ny)) {    // 꼭짓점
                    count++;
                } else if (checkEdge(rectangle[i], nx + dx[direction], ny + dy[direction])) {   // 이동가능한 모서리
                    count++;
                } else {    // 불가능한 이동경로
                    return false;
                }
            }
        }
        
        return count != 0;
    }
    
    public boolean checkInside(int[] rectangle, int x, int y) {
        int rx1 = rectangle[0];
        int rx2 = rectangle[2];
        int ry1 = rectangle[1];
        int ry2 = rectangle[3];
        
        if (x > rx1 && x < rx2 && y > ry1 && y < ry2) {
            return true;
        }
        
        return false;
    }
    
    public boolean checkEdge(int[] rectangle, int x, int y) {
        int rx1 = rectangle[0];
        int rx2 = rectangle[2];
        int ry1 = rectangle[1];
        int ry2 = rectangle[3];
        
        if (x >= rx1 && x <= rx2 && y >= ry1 && y <= ry2) {
            if (x == rx1 || x == rx2 || y == ry1 || y == ry2) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean checkCorner(int[] rectangle, int x, int y) {        
        int rx1 = rectangle[0];
        int rx2 = rectangle[2];
        int ry1 = rectangle[1];
        int ry2 = rectangle[3];
        
        if ((x == rx1 && (y == ry1 || y == ry2)) || x == rx2 && (y == ry1 || y == ry2)) {
            return true;
        }
        
        return false;
    }
}

class Character {
    
    private int x;
    private int y;
    private int distance;
    
    public Character(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getDistance() {
        return this.distance;
    }
}