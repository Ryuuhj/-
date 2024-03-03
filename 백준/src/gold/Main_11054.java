package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11054 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] dp = new int[N][2];
        int[] maxLength = new int[2000];

        for (int i = 0; i < N; i++) {
            int num = S[i];
            for (int j = 0; j < num; j++) {
                maxLength[num] = Math.max(maxLength[num], maxLength[j] + 1);
            }
            dp[i][0] = maxLength[num];
        }

        maxLength = new int[2000];
        for (int i = N-1; i >= 0; i--) {
            int num = S[i];
            for (int j = 0; j < num; j++) {
                maxLength[num] = Math.max(maxLength[num], maxLength[j] + 1);
            }
            dp[i][1] = maxLength[num];
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (answer <= dp[i][0] + dp[i][1]) {
                answer = dp[i][0] + dp[i][1];
                if((dp[i][0] == 0 || dp[i][1] == 0))
                    answer++;
            }
        }

        System.out.println(answer - 1);
    }
}
