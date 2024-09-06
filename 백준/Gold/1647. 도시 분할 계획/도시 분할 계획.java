import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Edge[] edges = new Edge[M];
		
		parents = new int[N+1];
		for (int i = 1; i < N+1; i++) 
			parents[i] = i;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(from, to, cost);
		}
		
		Arrays.sort(edges);
		
		long totalCost = 0;
		int edgeCnt = 0;
		if(N > 2) {
			for(Edge e : edges) {
				if(union(e.from, e.to)) { //두 도시 연결
					totalCost += e.cost;
					if(++edgeCnt == N-2) break;
				}
			}
		}
		System.out.println(totalCost);
		
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a, int b) {
		int rA = find(a);
		int rB = find(b);
		if(rA == rB) return false;
		parents[rB] = rA;
		return true;
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		int cost;
		
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
}
