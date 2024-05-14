package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1535 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] health = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] joy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] dp = new int[N+1][100]; //100이면 죽은거니까 99까지
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 100 ; j++) {
                dp[i+1][j] = dp[i][j];
                if(j - health[i] >= 0)
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j-health[i]] + joy[i]);
            }
        }
        System.out.println(Arrays.stream(dp[N]).max().getAsInt());

    }
}

