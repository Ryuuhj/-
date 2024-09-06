import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		long[][][] dp = new long[N+1][N+1][3];
		int[][] map = new int[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(map[N][N] == 1) {
			System.out.println(0);
		}else {
			
			for (int i = 2; i < N+1 ; i++) {
				if(map[1][i] == 1) break;
				dp[1][i][0] = 1;
			}
			
			for (int i = 2; i <= N; i++) {
				for (int j = 3; j <= N; j++) {
					if(map[i][j] == 1) continue;
					
					dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
					if(map[i-1][j] != 1 && map[i][j-1] != 1 && map[i-1][j-1] != 1) //근접 4칸 중 한곳에라도 벽이 있으면 아예 진행 불가능함!
						dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
					dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];
					
				}
			}
			
			System.out.println(Arrays.stream(dp[N][N]).sum());
		}
	}
}
