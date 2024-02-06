import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Queue<String> card1 = new LinkedList<>(List.of(cards1));
        Queue<String> card2 = new LinkedList<>(List.of(cards2));
        int idx = 0;
        for(int i = 0; i < goal.length; i++){
            if(!card1.isEmpty() && card1.peek().equals(goal[i]))
                card1.poll();
            else if(!card2.isEmpty() && card2.peek().equals(goal[i]))
                card2.poll(); 
            else
                return "No";          
        }
        
        return answer;
    }
}
