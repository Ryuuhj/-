import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
	static StringTokenizer st;
	static int[][] dp;
	static int N, M;
	static ArrayList<Node>[] edges;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		edges = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			edges[i] = new ArrayList<>();
		}
		int[] inDegree = new int[N+1];
	
		while(M--> 0) {
			st = new StringTokenizer(br.readLine());
			int res = Integer.parseInt(st.nextToken());
			int ig = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			edges[ig].add(new Node(res, cnt));
			inDegree[res]++;
		}
		
		//기본 부품 개수
		dp = new int[N+1][N+1];
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) {
				dp[i][i] = 1;
				queue.add(i);
			}
		}

		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			//연결된 부품들 누적합 + indegree하나 차감
			for(Node adj : edges[cur]) {
				for (int i = 1; i <= N; i++) {
					if(dp[cur][i] != 0)
						dp[adj.to][i] += dp[cur][i] * adj.cnt;
				}
				if(--inDegree[adj.to] == 0)
					queue.offer(adj.to);
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			if(dp[N][i] != 0)
				sb.append(i).append(" ").append(dp[N][i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static class Node {
		int to, cnt;
		
		Node(int to, int cnt){
			this.to = to;
			this.cnt = cnt;
		}
	}
}
