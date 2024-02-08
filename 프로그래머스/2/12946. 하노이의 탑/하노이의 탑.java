import java.util.*;

class Solution {
    static List<int[]> move = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        int[][] answer = new int[move.size()][2];
        for(int i = 0; i < move.size(); i++){
            answer[i] = move.get(i);
        }
        return answer;
    }
    
    private void hanoi(int n, int start, int end, int via) {
        if(n == 1) {
            move.add(new int[]{start, end});
            return;
        }
        hanoi(n-1, start, via, end);
        move.add(new int[]{start, end});
        hanoi(n-1, via, end, start);
    }
}