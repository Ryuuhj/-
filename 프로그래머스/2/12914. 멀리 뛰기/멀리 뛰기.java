class Solution {
    public long solution(int n) {
        if(n <= 2)
            return n;
        
        long[] ans = new long[n+1];
        ans[1] = 1; ans[2] = 2;
        for(int i = 3; i <= n; i++){
            ans[i] = (ans[i-1] + ans[i-2]) % 1234567;
        }
        
        return ans[n];
    }
}