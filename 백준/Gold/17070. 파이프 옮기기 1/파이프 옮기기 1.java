import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] move = {{1, 1}, {0, 1}, {1, 0}};
	static String[][] map;
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new String[N+1][N+1];
		for (int i = 1; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = st.nextToken();
			}
		}
		//최종 목적지에 1이 들어있는 경우 예외처리 해야 함
		int answer = 0;
		if(map[N][N].equals("0"))
			answer = bfs(new Pipe(1, 2, 1));
		System.out.println(answer);
	}
	private static int bfs(Pipe start) {
		Queue<Pipe> queue = new LinkedList<>();
		int cnt = 0;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Pipe now = queue.poll();
			for (int nDir = 0; nDir < 3; nDir++) {
				if(nDir * now.dir == 2) continue;
				int nx = now.x + move[nDir][0];
				int ny = now.y + move[nDir][1];
			
				if(isAvailable(nx, ny, nDir)) {
					if(nx == N && ny == N) {
						cnt++;
						continue;
					}
					queue.add(new Pipe(nx, ny, nDir));
					//System.out.printf("x: %d, y: %d, dir : %d\n", nx, ny, nDir);
				}
				
			}
		}
		
		return cnt;
	}
	private static boolean isAvailable(int x, int y, int dir) {
		if(dir == 0) {//대각선 방향의 경우
			if(x > N || y > N || x < 2 || y < 2 || map[x-1][y-1].equals("1") || map[x-1][y].equals("1") || map[x][y-1].equals("1") || map[x][y].equals("1"))
				return false;
		}else if(dir == 1) { //가로 방향
			if(y > N || x > N || map[x][y].equals("1"))
				return false;
		}else {
			if(x > N || y > N || map[x][y].equals("1"))
				return false;
		}
		return true;
	}
	private static class Pipe{
		int x, y;
		int dir;
		
		Pipe(int x, int y, int dir){
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
}
