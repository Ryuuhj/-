import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	final static int INF = Integer.MAX_VALUE;
	static int[][] map;
	static int N;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Cell implements Comparable<Cell>{
		int x, y, loseCost;

		public Cell(int x, int y, int loseCost) {
			super();
			this.x = x;
			this.y = y;
			this.loseCost = loseCost;
		}

		@Override
		public int compareTo(Cell o) {
			return Integer.compare(this.loseCost, o.loseCost);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int num = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}	
			}
			
			sb.append("Problem ").append(num++).append(": ").append(getMinCost(new Cell(0, 0, map[0][0]))).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static int getMinCost(Cell start) {
		boolean[][] visited = new boolean[N][N];
		int[][] minCost = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minCost[i][j] = INF;
			}
		}
		PriorityQueue<Cell> pq = new PriorityQueue<>();
		pq.offer(start);
		minCost[start.x][start.y] = start.loseCost;
		
		while(!pq.isEmpty()) {
			Cell now = pq.poll();
			if(now.x == N-1 && now.y == N-1) return now.loseCost;
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || minCost[nx][ny] <= now.loseCost + map[nx][ny]) continue;
				visited[nx][ny] = true;
				minCost[nx][ny] = now.loseCost + map[nx][ny];
				pq.offer(new Cell(nx, ny, minCost[nx][ny]));
			}
			
		}
		return -1;
	}

}
