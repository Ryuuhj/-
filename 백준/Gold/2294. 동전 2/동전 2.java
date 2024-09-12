import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k + 1];
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin);
        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int c = coin[i];
            if(c > k) break;

            for (int j = c; j <=k ; j++) {
                dp[j] = Math.min(dp[j - c] + 1, dp[j]);
            }
        }
        System.out.println(dp[k] == Integer.MAX_VALUE - 1 ? -1 : dp[k]);
    }
}
