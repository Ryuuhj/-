package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11057 {
    static int N;
    static long[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new long[N][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        if(N != 1) {
            for (int i = 1; i < N; i++) {
                dp[i][0] = 1;
                for (int j = 1; j <= 9; j++) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
                }
            }
        }
        long ans = Arrays.stream(dp[N-1]).sum() % 10007;
        System.out.println(ans);
    }
}
