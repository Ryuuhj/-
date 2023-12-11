package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579 {
    static int N;
    static int[] stairs;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N + 1];
        dp = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        if(N == 1){
            System.out.println(stairs[1]);
            return;
        }
        dp[1][0] = dp[1][1] = stairs[1];
        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + stairs[i];
            dp[i][1] = dp[i - 1][0] + stairs[i];
        }
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}
