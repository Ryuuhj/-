import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 *   시간 : 172ms   메모리 : 21216 KB
 */

public class Main {	
	static int N, M, ans = Integer.MAX_VALUE;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static char[][] map;
	static boolean[][][] min;
	static int sx, sy;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		min = new boolean[128][N][M];
		
		
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = row.charAt(j);
				if(map[i][j] == '0') {
					sx = i; sy = j;
                }
			}
		}
		
		Queue<Node> queue = new LinkedList<>();
		min[0][sx][sy] = true;
		queue.add(new Node(sx, sy, 0, 0));
		
		int nx, ny;
        outer:
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				nx = now.x + dx[dir];
				ny = now.y + dy[dir];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == '#') continue;
				if(map[nx][ny] == '1') {
					ans = Math.min(ans, now.m + 1);
					break outer;
				}
				int tk = now.keys;
				
				if(Character.isAlphabetic(map[nx][ny])) {
					if(Character.isLowerCase(map[nx][ny])) { //열쇠인 경우
						tk = tk | 1 << ((int)map[nx][ny] - 96); // 열쇠 저장
					}
					else if((tk & 1 << ((int)map[nx][ny] - 64)) == 0) continue; //문인데 열쇠 없는 경우 -> 스킵
				}
				if(min[tk][nx][ny]) continue;
				
				//최소인 경우 갱신
				min[tk][nx][ny] = true;
				
				queue.add(new Node(nx, ny, tk, now.m+1));
			}
		}
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		
	}
	
	static class Node {
		int x, y, keys, m;
		Node(int x, int y, int keys, int m){
			this.x = x;
			this.y = y;
			this.keys = keys;
			this.m = m;
		}
	}

}
