package gold;

import java.util.Scanner;

public class Main_2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        dp[0] = 1;
        for (int i = 2; i <= N; i += 2) {
            dp[i] = dp[i-2] * 3;
            if(i == 2) continue;
            for (int j = 0; j < i-2; j+= 2) {
                dp[i] += (dp[j] * 2);
            }
        }
        System.out.println(dp[N]);
    }
}
