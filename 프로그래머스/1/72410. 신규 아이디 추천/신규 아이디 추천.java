import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        //1. 소문자로 치환
        answer = new_id.toLowerCase();
        //2. 특정 문자 제외 제거
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        //3. 마침표 2번 이상 -> 1개로 치환
        answer = answer.replaceAll("\\.{2,}", ".");
        //4. 마침표가 처음이나 끝에 위치한다면 제거
        answer = answer.replaceAll("^\\.|\\.$", "");
        //5. 빈 문자열이면 a
        answer = answer.isEmpty() ? "a" : answer;
        //6. 길이 15까지만 잘라내기
        //6-1. 제거 후 .로 끝나면 제거
        if(answer.length() >= 16){
            if(answer.charAt(14) == '.')
                answer = answer.substring(0, 14);
            else
                answer = answer.substring(0, 15);
        }
        //7. 길이가 2자 이하면 마지막 문자 3 될때까지 반복
        int len = answer.length();
        if(len <= 2){
            String add = answer.substring(len-1, len);
            answer += add.repeat(3-len);
        }
        
        return answer;
    }
}