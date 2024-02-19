import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        StringBuilder sb = new StringBuilder(s);
        int idx = 0;
        while(sb.length() > 1){
            //0 제거
            answer[1] += deleteZero(sb);
            //이진법 변환
            answer[0]++;
            sb = transBinary(sb.length());  
        }
        return answer;
    }

    private int deleteZero(StringBuilder sb){
        int dCnt = 0;
        int idx = 0;
        while(true){
            if(idx >= sb.length())
                break;
            char c = sb.charAt(idx);
            if(c == '0'){
                dCnt++;
                sb.deleteCharAt(idx);
                continue;
            }
            idx++;
        }
        return dCnt;
    }
    private StringBuilder transBinary(int num){
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            sb.insert(0, num % 2);
            num /= 2;
        }
        return sb;
    }
}