import java.util.*;

class Solution {
    static int wh, w, h;
    public int[] solution(int brown, int yellow) {
        wh = brown/2 + 2;
        for(int i=1; i <= Math.sqrt(yellow); i++){
            if(yellow % i == 0){
                w = i+2;
                h = yellow/i + 2;
                if(w + h == wh) break;
            }
        }
        int[] answer = {Math.max(w, h), Math.min(w, h)};
        return answer;
    }
}