package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9048 {
    static int[] coins, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            coins = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int M = Integer.parseInt(br.readLine());
            dp = new int[M + 1];
            dp[0] = 1;
            for (int c : coins) {
                for (int base = M - c; base >= 0; base--) {
                    if(dp[base] == 0) continue; //의미 없음
                    for (int i = 1; i <= M / c; i++) {
                        int newVal = base + c * i;
                        if (newVal > M) break; //이후는 계속 범위 초과할테니
                        dp[newVal] += dp[base];
                    }
                }
            }
            //M만드는 모든 방법의 수
            sb.append(dp[M]).append("\n");
        }
        System.out.print(sb);
    }
}
