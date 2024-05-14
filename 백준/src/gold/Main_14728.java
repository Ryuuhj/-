package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14728 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] subject = new int[N][2];
        for (int i = 0; i < subject.length; i++) {
            st = new StringTokenizer(br.readLine());
            subject[i][0] = Integer.parseInt(st.nextToken()); //K
            subject[i][1] = Integer.parseInt(st.nextToken()); //S
        }
        int[][] dp = new int[N+1][T+1];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= T; j++) {
                dp[i+1][j] = dp[i][j];
                if(j >= subject[i][0]) {
                    int K = subject[i][0];
                    int S = subject[i][1];
                    dp[i+1][j] = Math.max(dp[i][j-K] + S, dp[i+1][j]);
                }
            }
        }
        System.out.println(Arrays.stream(dp[N]).max().getAsInt());
    }
}
