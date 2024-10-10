import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static boolean[][] check;
	final static int MAX = Integer.MAX_VALUE >> 2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc < t+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			check = new boolean[N][N];
			
			while(M--> 0) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken())-1;
				int e = Integer.parseInt(st.nextToken())-1;
				check[s][e] = true;
			}
			
			for (int i = 0; i < N; i++) {
				check[i][i] = true;
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(check[i][k] && check[k][j])
							check[i][j] = true;
					}
				}
				
			}
			int ans = 0;
			for (int i = 0; i < N; i++) {
				boolean flag = true;
				for (int j = 0; j < N; j++) {
					if(!check[j][i] && !check[i][j]) {
						flag = false;
						break;
					}
				}
				if(flag) ++ans;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
