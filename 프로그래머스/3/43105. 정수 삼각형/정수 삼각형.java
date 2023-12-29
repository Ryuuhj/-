import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        int[][] dp = new int[len][triangle[len - 1].length];
        dp[0][0] = triangle[0][0];
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + triangle[i + 1][j]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + triangle[i + 1][j + 1]);
            }
        }
        return Arrays.stream(dp[len - 1]).max().getAsInt();
    }
}