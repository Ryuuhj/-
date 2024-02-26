package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9252 {
    static Stack<Character> stack = new Stack<>();
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String str1 = br.readLine();
        int len1 = str1.length();
        String str2 = br.readLine();
        int len2 = str2.length();
        //세로 str1, 가로 str2
        dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            char c = str1.charAt(i-1);
            for (int j = 1; j <= len2; j++) {
                if (c == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    continue;
                }
                //일치하지 않는 경우 위/왼쪽 값들 중 최대
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        ans.append(dp[len1][len2]).append("\n");

        printLSC(len1, len2, str1, str2);
        while (!stack.empty()) {
            ans.append(stack.pop());
        }
        System.out.println(ans);
    }

    private static void printLSC(int x, int y, String str1, String str2) {
        if(x == 0 || y == 0)
            return;
        //일치하는 글자 => LCS의 일부
        if (str1.charAt(x - 1) == str2.charAt(y - 1)) {
            stack.push(str1.charAt(x - 1));
            printLSC(x - 1, y - 1, str1, str2); //둘다 1칸 전으로 옮김
        }else {
            if(dp[x][y-1] > dp[x-1][y]) //일치하는 글자가 더 많은 곳으로 옮김
                printLSC(x, y - 1, str1, str2);
            else
                printLSC(x - 1, y, str1, str2);
        }
    }
}
