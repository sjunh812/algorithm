class Solution {
    
    static final int MAX = 0;
    static final int MIN = 1;
    
    int[] numbers;
    String[] operators;
    int[][][] dp;
    
    public int solution(String arr[]) {     
        numbers = new int[arr.length / 2 + 1];
        operators = new String[arr.length / 2];
        
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) numbers[i / 2] = Integer.parseInt(arr[i]);
            else operators[i / 2] = arr[i];
        }
        
        dp = new int[arr.length / 2 + 1][arr.length / 2 + 1][2];
        
        for (int i = 0; i <= arr.length / 2 ; i++) {
            for (int j = 0; j <= arr.length / 2; j++) {
                dp[i][j][0] = Integer.MIN_VALUE;
                dp[i][j][1] = Integer.MAX_VALUE;
            }
        }
        
        return dfs(0, arr.length / 2, MAX);
    }
    
    public int dfs(int start, int end, int flag) {
        if (start == end) {
            dp[start][end][flag] = numbers[start];
            return dp[start][end][flag];
        }
        
        if (dp[start][end][flag] != Integer.MAX_VALUE && dp[start][end][flag] != Integer.MIN_VALUE) {
            return dp[start][end][flag];
        }
        
        int result = flag == MAX ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        
        if (flag == MAX) {
            for (int i = start; i < end; i++) {
                String operator = operators[i];
                
                if (operator.equals("-")) { // (a - b) → a:최댓값, b:최솟값
                    result = Math.max(result, dfs(start, i, MAX) - dfs(i + 1, end, MIN));
                } else {    // (a + b) → a:최댓값, b:최댓값
                    result = Math.max(result, dfs(start, i, MAX) + dfs(i + 1, end, MAX));
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                String operator = operators[i];
                
                if (operator.equals("-")) { // -(a - b) → a:최솟값, b:최댓값
                    result = Math.min(result, dfs(start, i, MIN) - dfs(i + 1, end, MAX));
                } else {    // -(a + b) → a:최솟값, b:최솟값
                    result = Math.min(result, dfs(start, i, MIN) + dfs(i + 1, end, MIN));
                }
            }
        }
        
        dp[start][end][flag] = result;
        
        return dp[start][end][flag];
    }
}