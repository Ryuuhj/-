package silver;

import java.util.Scanner;

public class Main_1003 {
    /*
    fib(3) = fib(2) + fib(1) = 1 1 + 0 1 = 1 2
    fib(4) = fib(3) + fib(2) = 1 2 + 1 1 = 2 3
    */
    static int n;
    static long[][] dp = new long[41][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        dp[0][0] = 1; dp[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        int T = sc.nextInt();
        while (T-- > 0) {
            n = sc.nextInt();
            sb.append(dp[n][0] + " " + dp[n][1] + "\n");
        }
        System.out.println(sb);
    }
}
