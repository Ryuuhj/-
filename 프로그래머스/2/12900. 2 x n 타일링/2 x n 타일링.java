class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];
        if(n == 1)
            return 1;
        dp[0] = 1; dp[1] = 1;
        for(int i = 2; i<= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007; //세로 1개 경우 + 가로 2개 경우
        }
        return dp[n];
    }
}