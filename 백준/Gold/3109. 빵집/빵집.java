import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int R, C, maxCnt;
	static char[][] map;
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1};
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			flag = false;
			dfs(i, 0);
		}
		
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			if(map[i][C-1] != '.')
				cnt++;
		}
		System.out.println(cnt);
	}

	private static void dfs(int r, int c) {
		if(flag)
			return;
		if(c == C-1) { //끝까지 도착한 경우
			flag = true;
//			for(char[] a : map) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println();
			return;
		}
		
		int nr, nc;
		for (int i = 0; i < 3; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(flag) return;
			if(nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] != '.') continue;
			
			map[nr][nc] = 'p';
			dfs(nr, nc);
			
		}
		
	}

}
