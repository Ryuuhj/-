package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11052 {
    static int N;
    static int[] cardPack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        cardPack = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cardPack[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if(i > j) continue;
                dp[j] = Math.max(dp[j], dp[j - i] + cardPack[i]);
            }
        }
        System.out.println(dp[N]);
    }
}
