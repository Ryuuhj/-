package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_9465 {
    static int N;
    static int[][] sticker, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            sticker = new int[2][N];
            for (int i = 0; i < 2; i++) {
                sticker[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            dp = new int[2][N + 2];
            for (int i = 2; i < N + 2; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i - 2];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i - 2];
            }
            //끝 2줄 중 최댓값
            sb.append(Math.max(dp[0][N + 1], dp[1][N + 1])).append("\n");
        }
        System.out.println(sb);
    }
}
