import java.util.*;
class Solution {
    final static int MOD = 1000000007;
    static int[][] dp;
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n+1][m+1];
        
        for(int[] p : puddles){
            dp[p[1]][p[0]] = -1;
        }
        
        dp[1][1] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(dp[i][j] == -1) continue;
                if(i < n && dp[i+1][j] != -1)
                    dp[i+1][j] = (dp[i+1][j] + dp[i][j]) % MOD;
                if(j < m && dp[i][j+1] != -1)
                    dp[i][j+1] = (dp[i][j+1] + dp[i][j]) % MOD;    
            }
        }
        return dp[n][m];
    }
}