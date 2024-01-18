package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660 {
    static int N, M, x1, x2, y1, y2, pSum;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i][j - 1] + arr[i][j]; //각 행 별로 누적합
            }
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken()); y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken()); y2 = Integer.parseInt(st.nextToken());
            pSum = 0;
            for (int i = x1; i <= x2; i++) {
                pSum += (dp[i][y2] - dp[i][y1 - 1]);
            }
            sb.append(pSum).append("\n");
        }
        System.out.print(sb);
    }
}
