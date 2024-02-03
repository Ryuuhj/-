import java.util.*;
class Solution {
    static boolean[][] canWin;
    static int[][] result;
    static boolean[] visit;
    public int solution(int n, int[][] results) {
        int answer = 0;
        canWin = new boolean[n+1][n+1]; //r -> c가 이기면 true
        result = new int[n+1][2]; //[i][0] = i가 이긴 횟수 [i][1] = i가 진 횟수
        for(int[] result : results){
            canWin[result[0]][result[1]] = true;
        }
        for(int i = 1; i<= n; i++){
            visit = new boolean[n+1];
            dfs(i, i, n);
        }
        for(int[] WL : result){
            if(WL[0] + WL[1] == n - 1) answer++;
        }
        return answer;
    }
    static void dfs(int start, int next, int n){
        for(int i = 1; i<= n; i++){
            if(canWin[next][i] && !visit[i]){
                visit[i] = true;
                result[start][0]++;
                result[i][1]++;
                dfs(start, i, n);
            }
        }
    }
}