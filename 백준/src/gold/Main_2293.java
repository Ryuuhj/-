package gold;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2293 {
    static int n, k, value;
    static List<Integer> coin;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); k = sc.nextInt();
        coin = new ArrayList<>();
        while (n-- > 0) {
            value = sc.nextInt();
            if(value <= k) coin.add(value);
        }
        dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 0; i < coin.size(); i++) {
            value = coin.get(i);
            for (int j = coin.get(i); j <= k; j++) {
                dp[j] += dp[j - value];
            }
        }
        System.out.println(dp[k]);
    }
}
