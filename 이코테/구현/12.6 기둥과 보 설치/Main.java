class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        int[][] grid = new int[n + 1][n + 1];
        int count = 0;
        
        for (int i = 0; i < build_frame.length; i++) {
            int[] frame = build_frame[i];
            int x = frame[0];
            int y = frame[1];
            boolean isVertical = frame[2] == 0;
            boolean isAdd = frame[3] == 1;
            
            if (isVertical) {
                if (isAdd) {    // 기둥 추가
                    if (y == 0 
                        || grid[x][y] >= 1
                        || (x > 0 && grid[x - 1][y] % 2 == 1))
                    {   
                        // 1. 바닥은 기둥 설치 가능
                        // 2. 기둥이나 보 위에 기둥 설치 가능
                        grid[x][y + 1] += 2;
                        count++;
                    }
                } else {    // 기둥 삭제          
                    // 1. (x - 1, y + 1, 보) 확인
                    if (x > 0 && grid[x - 1][y + 1] == 1) {
                        if (x == 1) continue;
                        if (grid[x - 2][y + 1] % 2 != 1 || grid[x][y + 1] % 2 != 1) continue;
                    } 
                    // 2. (x, y + 1, 기둥) 확인
                    if (y + 2 <= n && grid[x][y + 2] >= 2 && grid[x][y + 1] == 2) {
                        if (x == 0) continue;
                        if (grid[x - 1][y + 1] % 2 != 1) continue;
                    }               
                    // 3. (x, y + 1, 보) 확인
                    if (grid[x][y + 1] == 3 && grid[x + 1][y + 1] < 2) {
                        if (grid[x + 1][y + 1] == 0) continue;
                        if (x == 0) continue;
                        if (grid[x - 1][y + 1] % 2 != 1) continue;
                    }
                    
                    grid[x][y + 1] -= 2;
                    count--;
                    
                }
            } else {
                if (isAdd) {    // 보 추가
                    if (grid[x][y] == 2 
                        || grid[x + 1][y] >= 2
                        || (x > 0 && grid[x - 1][y] % 2 == 1 && grid[x + 1][y] % 2 == 1)) 
                    {
                        // 1. 기둥 위 보 설치 가능
                        // 2. 양 옆이 보이면 보 설치 가능
                        // 3. 오른쪽이 기둥이면 보 설치 가능
                        grid[x][y]++;
                        count++;
                    }
                } else {    // 보 삭제
                    // 1. (x - 1, y, 보) 확인
                    if (x > 0 && grid[x - 1][y] == 1 && grid[x][y] == 1) {
                        continue;
                    }
                    // 2. (x, y, 기둥) 확인
                    if (y + 1 <= n && grid[x][y + 1] >= 2 && grid[x][y] == 1) {
                        if (x == 0) continue;
                        if (grid[x - 1][y] % 2 != 1) continue;       
                    }               
                    // 3. (x + 1, y, 기둥) 확인
                    if (y + 1 <= n && x + 1 <= n && grid[x + 1][y + 1] >= 2) {
                        if (grid[x + 1][y] == 0) continue;
                    }  
                    // 4. (x + 1, y, 보) 확인
                    if (x + 1 <= n && grid[x + 1][y] == 1) {
                        if (x + 2 <= n && grid[x + 2][y] < 2) continue;
                    }
                    
                    grid[x][y]--;
                    count--;
                }
            }
        }
        
        int[][] answer = new int[count][3];
        int index = 0;
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (j + 1 <= n && grid[i][j + 1] >= 2) {
                    answer[index][0] = i;
                    answer[index][1] = j;
                    answer[index++][2] = 0;
                } 
                if (grid[i][j] % 2 == 1) {
                    answer[index][0] = i;
                    answer[index][1] = j;
                    answer[index++][2] = 1;
                }
            }
        }
        
        return answer;
    }
}