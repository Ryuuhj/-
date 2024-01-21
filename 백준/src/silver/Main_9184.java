package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9184 {
    static int a, b, c;
    static int[][][] dp = new int[21][21][21];
    static String[] input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 20; k++) {
                    if(i == 0 || j == 0 || k == 0)
                        dp[i][j][k] = 1;
                    else if (i < j && j < k){
                        dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
                    }else
                        dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
                }
            }
        }
        while (true) {
            input = br.readLine().split(" ");

            if(input[0].equals("-1") && input[1].equals("-1") && input[2].equals("-1")) break;
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            c = Integer.parseInt(input[2]);

            //순서 주의...ㅡㅡ
            if(a <= 0 || b <= 0 || c <= 0)
                a = b = c = 0;
            else if(a > 20 || b > 20 || c > 20)
                a = b = c = 20;

            System.out.printf("w(%s, %s, %s) = %d\n", input[0], input[1], input[2], dp[a][b][c]);
        }
    }
}

