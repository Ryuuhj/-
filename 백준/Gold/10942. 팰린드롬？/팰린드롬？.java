import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] s = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean[][] dp = new boolean[N + 1][N + 1];
        int M = Integer.parseInt(br.readLine());

        for (int i = 1; i < N+1; i++) {
            dp[i][i] = true;
            if(i < N && s[i] == s[i+1])
                dp[i][i+1] = true;
        }

        for (int k = 2; k <= N-1; k++) {
            for (int i = 1; i <= N-k; i++) {
                if(s[i] == s[i+k])
                    dp[i][i + k] = dp[i + 1][i + k - 1];
            }
        }
        StringBuilder sb = new StringBuilder();

        while (M--> 0) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(dp[S][E] ? 1 : 0).append("\n");
        }

        System.out.println(sb);

    }
}