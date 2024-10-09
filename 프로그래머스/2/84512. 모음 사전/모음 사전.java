import java.util.*;
class Solution {
    static int answer = 0;
    static String target;
    static boolean flag = false;
    static String[] alpha = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        target = word;
        
        for(int i = 0; i < 5; i++){
            dfs(alpha[i], 1);
        }
        
        return answer;
    }
    
    private void dfs(String cur,int length){
        if(flag || length > 5) return;
        answer++;
        if(cur.equals(target)){
            flag = true;
            return;
        }
        for(int i = 0; i < 5; i++){
            dfs(cur + alpha[i], length+1);
        }
    }
}