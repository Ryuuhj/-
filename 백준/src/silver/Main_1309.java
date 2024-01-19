package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1309 {
    final static int mod = 9901;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[N + 1][3];
        Arrays.fill(dp[1], 1);
        for (int k = 2; k <= N; k++) {
            dp[k][0] = (dp[k - 1][0] + dp[k - 1][1] + dp[k - 1][2]) % mod;
            dp[k][1] = (dp[k - 1][0] + dp[k - 1][2]) % mod;
            dp[k][2] = (dp[k - 1][0] + dp[k - 1][1]) % mod;
        }
        System.out.println(Arrays.stream(dp[N]).sum() % mod);
    }
}
