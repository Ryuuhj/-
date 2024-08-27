import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[][][] minCnt;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[] horseDx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] horseDy = {-1, 1, -2, 2, -2, 2, -1, 1};
	
	static class Node {
		int x, y;
		int horseMove;
		int totalMove;
		Node(int x, int y, int horseMove, int totalMove) {
			super();
			this.x = x;
			this.y = y;
			this.horseMove = horseMove;
			this.totalMove = totalMove;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		minCnt = new int[K+1][H][W];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i = 0; i <= K; i++) {
			for (int j = 0; j < H; j++) {
				Arrays.fill(minCnt[i][j], Integer.MAX_VALUE);
			}
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 0, 0));
		minCnt[0][0][0] = 0;
		int nx,ny;
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			int h = now.horseMove;
			int t = now.totalMove;
			//말 잔여 횟수가 있다면 말 진행
			if(h < K) {
				for (int dir = 0; dir < 8; dir++) {
			        nx = now.x + horseDx[dir];
			        ny = now.y + horseDy[dir];
			        
			        if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == 0) {
			            if (t + 1 < minCnt[h + 1][nx][ny]) {
			                minCnt[h + 1][nx][ny] = t + 1;
			                queue.add(new Node(nx, ny, h + 1, t + 1));
			            }
			        }
			    }
			}
			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == 1 ||t+1 >= minCnt[h][nx][ny]) continue;
				minCnt[h][nx][ny] = t+1;
				queue.add(new Node(nx, ny, h, t+1));
			}
		}

		int ans = Integer.MAX_VALUE;
		
		
		for (int i = 0; i <= K; i++) {
			ans = Math.min(ans, minCnt[i][H-1][W-1]);
		}
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

}
