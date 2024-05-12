package gold;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_2624 {
    static int T, k;
    static int[][] coin;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        k = sc.nextInt();
        coin = new int[k][2];
        for (int i = 0; i < k; i++) {
            coin[i][0] = sc.nextInt();
            coin[i][1] = sc.nextInt();
        }
        Arrays.sort(coin, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int[] dp = new int[T + 1];
        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            int value = coin[i][0];
            int cnt = coin[i][1];
            for (int j = T - value; j >= 0; j--) {
                if(dp[j] == 0) continue;
                for (int l = 1; l <= cnt; l++) {
                    int tmpSum = j + value * l;
                    if(tmpSum > T)
                        break;
                    dp[tmpSum] += dp[j];
                }
            }
        }
        System.out.println(dp[T]);
    }
}
