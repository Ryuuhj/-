package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_9251 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[1].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) //문자가 일치할 경우 그 전 최대(대각선 값)
                    dp[i][j] = dp[i-1][j-1] +1;
                else //일치하지 않을 경우 가능한 최대 경우의 수 끌어옴 (str1에서 바로 전 최대 값 / str2에서 바로 전 최대 값)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(Arrays.stream(dp[dp.length-1]).max().getAsInt());
    }
}
