class Solution {
    
    public String solution(String p) {
        return dfs(p);
    }
    
    public String dfs(String s) {
        String tmp = "";
        if (s.isEmpty()) return tmp;
        
        // 문자열을 u, v로 각각 분리
        String[] uv = divide(s);
        String u = uv[0];
        String v = uv[1];
        
        // u가 "올바른 괄호 문자열" 인지 확인
        if (correct(u)) {
            tmp = u + dfs(v);
        } else {
            tmp += "(";
            tmp += dfs(v);
            tmp += ")";
            tmp += newU(u);
        }
        
        return tmp;
    }
    
    // 문자열을 "균형잡힌 괄호 문자열" u, v로 분리
    public String[] divide(String s) {
        String[] result = {"", ""};
        int left = 0;
        int right = 0;
        boolean u = true;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (u) {
                if (c == '(') left++;
                else right++;
                
                if (left == right) u = false;
                result[0] += c;
            } else {
                result[1] += c;
            }
        }
        
        return result;
    }
    
    // 문자열이 "올바른 괄호 문자열" 인지 확인
    public boolean correct(String s) {
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') left++;
            else right++;
            
            if (right > left) return false;
        }
        
        return left == right;
    }
    
    // 문제 조건 4-4
    public String newU(String u) {
        String result = "";
        
        if (u.length() > 3) {
            for (int i = 1; i < u.length() - 1; i++) {
                char c = u.charAt(i);
                
                if (c == '(') result += ")";
                else result += "(";
            }
        }
        
        return result;
    }
}