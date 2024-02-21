import java.util.*;
class Solution {
    char[] skills;
    public int solution(String skill, String[] skill_trees) {
        skills = skill.toCharArray();
        //skill안 문자를 포함하지 않은 경우 처리
        String regex = "[^"+ skill + "]"; 
        int answer = 0;
        for(String s : skill_trees){
            String tmp = s.replaceAll(regex, ""); //스킬 트리에 해당하는 문자만 남겨놓고
            if(tmp.equals("")){
                answer++;
                continue;
            }
            if(isCorrect(tmp))
                answer++;
        }
        return answer;
    }
    private boolean isCorrect(String tmp) {
        int idx = 0;
        for(char s : tmp.toCharArray()){
            if(skills[idx] == s){
                idx++;
                continue;
            }
            return false;
        }
        return true;
    }
}