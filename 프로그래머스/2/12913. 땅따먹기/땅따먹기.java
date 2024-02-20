import java.util.*;
class Solution {
    int solution(int[][] land) {
        int N = land.length;
        int[][] answer = new int[N][4];
        
        answer[0] = land[0].clone();
        for(int i = 1; i < N; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    if(j == k) continue;
                    answer[i][j] = Math.max(answer[i][j], answer[i-1][k] + land[i][j]); 
                }
            }
        }
        return Arrays.stream(answer[N-1]).max().getAsInt();
    }
}