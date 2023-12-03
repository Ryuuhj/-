import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder(number);
        int idx = 0, cnt = k;
        while (true){
            if(cnt == 0 || idx >= answer.length()-1) break;
            if(answer.charAt(idx) < answer.charAt(idx+1)) {
                answer.deleteCharAt(idx);
                cnt--;
                idx = Math.max(idx - 1, 0);
            }else
                idx++;
        }
        if(cnt != 0){
            return answer.substring(0, answer.length() - cnt);
        }
        return answer.toString();
    }
}