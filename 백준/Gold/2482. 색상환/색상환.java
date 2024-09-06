import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	final static int mod = 1000000003;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][N+1];
		
		for (int i = 1; i < N+1; i++) {
			dp[i][0] = 1;
			dp[i][1] = i;
		}
		
		for (int i = 3; i < N+1; i++) {
			for (int j = 2; j <= K; j++) {
				dp[i][j] = (dp[i-2][j-1] + dp[i-1][j]) % mod;
			}
		}
		
		//dp[n][k] 구하기 -> n번째 선택하는 경우 고려
		System.out.println((dp[N-3][K-1] + dp[N-1][K]) % mod);
	}
}