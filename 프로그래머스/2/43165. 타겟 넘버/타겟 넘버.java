import java.util.*;
class Solution {
    static int[] pm;
    static int tn, answer = 0;
    public int solution(int[] numbers, int target) {
        pm = numbers.clone();
        tn = target;
        dfs(0, 0);
        return answer;
    }
    public void dfs(int idx, int acc){
        if(idx == pm.length){
            if(acc == tn) answer++;
            return;
        }
        dfs(idx+1, acc+pm[idx]);
        dfs(idx+1, acc-pm[idx]);
    }
}