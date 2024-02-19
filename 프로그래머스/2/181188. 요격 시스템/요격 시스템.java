import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int last = 0;
        Arrays.sort(targets, (t1, t2) -> t1[1] - t2[1]);
        
        for(int[] t : targets){
            if(t[0] >= last){
                last = t[1];
                answer++;
            }
        }
        return answer;
    }
}