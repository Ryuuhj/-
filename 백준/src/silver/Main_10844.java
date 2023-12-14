package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10844 {
    static long[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new long[N + 1][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        if(N != 1) {
            for (int i = 1; i < N; i++) {
                dp[i + 1][0] = dp[i][1];
                dp[i + 1][9] = dp[i][8];
                for (int j = 1; j < 9; j++) {
                    dp[i + 1][j] = (dp[i][j - 1] + dp[i][j + 1])%1000000000;
                }
            }
        }
        System.out.println(Arrays.stream(dp[N]).sum() % 1000000000);
    }
}
