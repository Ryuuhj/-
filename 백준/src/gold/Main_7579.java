package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] task = new int[2][N + 1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            task[0][i] = Integer.parseInt(st1.nextToken());
            task[1][i] = Integer.parseInt(st2.nextToken());
        }
        int totalCost = Arrays.stream(task[1]).sum();
        int[] dp = new int[totalCost + 1];
        for (int i = 1; i <= N; i++) {
            int mem = task[0][i];
            int cost = task[1][i];
            for (int j = totalCost; j >= cost; j--) {
                dp[j] = Math.max(dp[j - cost] + mem, dp[j]);
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= totalCost; i++) {
            if (dp[i] >= M)
                minCost = Math.min(minCost, i);
        }
        System.out.println(minCost);
    }
}
