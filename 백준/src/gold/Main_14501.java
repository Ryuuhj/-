package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14501 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N+1][2];
        int[] dp = new int[N+2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            int idx = i + schedule[i][0];
            if(idx > N+1) continue;
            dp[i] = Math.max(dp[i - 1], dp[i]); //i-1번째 실행 안하고 넘긴 경우
            dp[idx] = Math.max(dp[i] + schedule[i][1], dp[idx]);
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
