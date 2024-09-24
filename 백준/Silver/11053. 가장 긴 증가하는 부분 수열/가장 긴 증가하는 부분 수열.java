import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 1);

        for (int i = 0; i < N; i++) {
            for (int j = i-1; j > -1; j--) {
                if(A[j] < A[i]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
