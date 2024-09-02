import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, start;
	static int[][] W;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			start = i;
			visited[i] = true;
			dfs(i, 1, 0);
			visited[i] = false;
		}
	
		System.out.println(answer);
	}
	private static void dfs(int cur, int cnt, int cost) {
		if(cnt > N) {
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(cnt == N && W[cur][start] != 0) {
				answer = Math.min(answer, cost + W[cur][start]);
				return;
			}
			
			if(W[cur][i] == 0 || visited[i]) continue;
			
			visited[i] = true;
			dfs(i, cnt+1, cost+W[cur][i]);
			visited[i] = false;
		}
	}


}
