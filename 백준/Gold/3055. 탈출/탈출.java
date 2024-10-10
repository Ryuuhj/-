import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int[][] ans;
	static int R, C;
	static Pos hedgehog, biber;
	static List<Pos> water = new ArrayList<>();
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		ans = new int[R][C];

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'D')
					biber = new Pos(i, j, false);
				else if (map[i][j] == 'S')
					hedgehog = new Pos(i, j, false);
				else if (map[i][j] == '*')
					water.add(new Pos(i, j, true));
			}
		}

		bfs();
		System.out.println(ans[biber.x][biber.y] == 0 ? "KAKTUS" : ans[biber.x][biber.y]);

	}

	private static void bfs() {
		boolean[][] visited = new boolean[R][C];
		visited[hedgehog.x][hedgehog.y] = true;

		Queue<Pos> queue = new LinkedList<>(water);
		queue.add(hedgehog);
		
		while (!queue.isEmpty()) {
			// 큐에 들어있는건 고슴도치와 물 -> 이전 좌표를 참고해서 고슴도치/물 판별
			Pos pos = queue.poll();
			

			for (int i = 0; i < 4; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue;
				
				if (pos.isWater && map[nx][ny] != 'X' && map[nx][ny] != 'D' && map[nx][ny] != '*') { // 물인 경우
					map[nx][ny] = '*';
					queue.add(new Pos(nx, ny, true));
					
				}else if(!pos.isWater) { //고슴도치인 경우
					if(map[nx][ny] == '*' || map[nx][ny] =='X' || visited[nx][ny]) continue;
					ans[nx][ny] = ans[pos.x][pos.y] + 1;
					visited[nx][ny] = true;

					if(nx == biber.x && ny == biber.y) return;
					queue.add(new Pos(nx, ny, false));
				}
			}
		}

	}

	static class Pos {
		int x, y;
		boolean isWater;

		Pos(int x, int y, boolean w) {
			this.x = x;
			this.y = y;
			this.isWater = w;
		}
	}

}
