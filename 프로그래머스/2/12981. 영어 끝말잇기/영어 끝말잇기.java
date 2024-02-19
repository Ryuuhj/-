import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 1};
        int turn = 2;
        Set<String> set = new HashSet<>();
        char lastChar = words[0].charAt(words[0].length()-1);
        set.add(words[0]);
        
        for(int i = 1; i < words.length; i++){
            String word = words[i];
            
            if(word.charAt(0) != lastChar || set.contains(word)){
                answer[0] = turn;
                break;
            }
            turn++;
            lastChar = word.charAt(word.length() - 1);
            set.add(word);
            
            if(turn > n){
                answer[1]++;
                turn = 1;
            }
        }

        answer[1] = answer[0] == 0 ? 0 : answer[1];

        return answer;
    }
}