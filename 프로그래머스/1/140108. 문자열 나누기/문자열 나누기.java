import java.util.*;
class Solution {
    public int solution(String s) {
        char x = s.charAt(0);
        int len = s.length();
        int[] cnt = new int[2];
        int answer = 1;
        for(int i=0; i < len; i++){
            if(s.charAt(i) == x)
                cnt[0]++;
            else
                cnt[1]++;
            if(cnt[0] == cnt[1]){ //같은 경우 문자열 분리
                if(i < len -1){
                    answer++;
                    cnt = new int[2];
                    x = s.charAt(i+1);
                }
            }
        }
        return answer;
    }
}