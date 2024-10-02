import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	final static int INF = (int)1e8;
	static int N;
	static int[][] dp, W;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		for (int i = 0; i < N; i++) {
			W[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		dp = new int[N][(1<<N)];
			
		int ans = explore(0, 1);
		System.out.println(ans);
	}

	private static int explore(int now, int state) {
		if(state == (1 << N) - 1) {
			if(W[now][0] == 0) return INF;
			return W[now][0];
		}
		if(dp[now][state] > 0)
			return dp[now][state];
		
		
		dp[now][state] = INF;
		for (int i = 0; i < N; i++) {
			if(W[now][i]==0) continue;
			if((state & 1<<i)>0) continue; 
			dp[now][state] = Math.min(dp[now][state], explore(i, state | (1 << i)) + W[now][i]);
		}
		return dp[now][state];
	}

}
