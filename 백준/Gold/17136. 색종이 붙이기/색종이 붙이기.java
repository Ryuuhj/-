import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int emptyCnt = 0, minCnt = Integer.MAX_VALUE;
	static int[] cp = new int[5];
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) 
					emptyCnt++;
			}
		}
		dfs(0, 0);
		System.out.println(minCnt == Integer.MAX_VALUE ? -1 : minCnt);
	}
	private static void dfs(int sx, int cnt) {
		if(minCnt <= Arrays.stream(cp).sum() || emptyCnt < cnt)
			return;
		if(cnt == emptyCnt) {
			minCnt = Math.min(minCnt, Arrays.stream(cp).sum());
			return;
		}
		
		for (int i = sx; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(map[i][j] != 1) continue;
				for (int k = 0; k < 5; k++) {
					if(cp[k] < 5 && canBeCovered(map, i, j, k)) {
						cp[k]++;
						change(i, j, k, -1);
						dfs(i, cnt + (k+1)*(k+1));
						change(i, j, k, 1);
						cp[k]--;
					}
				}
				return;
			}
		}
	}
	
	private static void change(int x, int y, int k, int val) {
		for(int i = x; i <= x + k; i++) {
			for (int j = y; j <= y + k; j++) {
				map[i][j] = val;
			}
		}
		
	}
	private static boolean canBeCovered(int[][] map, int x, int y, int k) {
		for (int i = x; i <= x + k; i++) {
			for (int j = y; j <= y + k; j++) {
				if(i < 0 || i >= 10 || j < 0 || j >= 10 || map[i][j] != 1)
					return false;
			}
		}
		return true;
	}

}
