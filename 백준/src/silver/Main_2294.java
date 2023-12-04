package silver;

import java.util.*;

public class Main_2294 {
    static int n, k, tmp, answer, mod;
    static List<Integer> coin = new ArrayList<>();
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); k = sc.nextInt();
        dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            tmp = sc.nextInt();
            if(tmp <= k && !coin.contains(tmp)) coin.add(tmp);
        }
        Collections.sort(coin);
        for (int i = 0; i < coin.size(); i++) {
            tmp = coin.get(i);
            for (int j = tmp; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - tmp] + 1);
            }
        }
        System.out.println(dp[k] == Integer.MAX_VALUE-1 ? -1 : dp[k]);
    }
}
