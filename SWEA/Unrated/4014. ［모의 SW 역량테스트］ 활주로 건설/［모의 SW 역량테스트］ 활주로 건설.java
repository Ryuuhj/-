import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static int N, X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		//int t = 1;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc < t + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = 0;

			outer:
			for (int r = 0; r < N; r++) {
				int start = 0, preValue = map[r][0];
				
				for (int c = 0; c < N; c++) {
					if (map[r][c] == preValue)
						continue;
					
					// map[r][c] != preValue (다음칸에서 값이 달라지는 경우)
					if (map[r][c] == preValue + 1 && (c - start) >= X) { // 다음칸이 높아질 때 && (이전까지) 누적 길이가 X 이상
						start = c;
						preValue = map[r][c];
						//System.out.printf("start : %d      preValue : %d\n", start, preValue);
					} else if (map[r][c] == preValue - 1) { // 다음칸이 낮아질 때 (다음칸 값이 x번 나와야 함)
						//System.out.printf("r : %d  c : %d \n", r, c);
						if (!checkPossible(r, c, true)) // map[r][c] 포함 연속된 X만큼 값이 동일한지 검사
							continue outer;
						//System.out.println("??");
						preValue = map[r][c];
						
						c += X-1; // X만큼 떨어진 곳에서 다시 시작
						start = c+1;
					} else {
						//System.out.printf("r : %d  c : %d \n", r, c);
						continue outer;
					}
					
				}
				ans++;
			}
			//System.out.println(ans);

			outer:
			for (int c = 0; c < N; c++) {
				int start = 0, preValue = map[0][c];
//				System.out.println();
//				System.out.printf("ans : %d\n",ans);
				
				for (int r = 0; r < N; r++) {
					//System.out.println(r);
					
					if (map[r][c] == preValue)
						continue;

					//System.out.println(r);
					if (map[r][c] == preValue + 1 && (r - start) >= X) { // 다음칸이 증가할 때
						start = r;
						preValue = map[r][c];
					} else if (map[r][c] == preValue - 1) { // 다음칸이 낮아질 때 (다음칸 값이 x번 나와야 함)
						if (!checkPossible(r, c, false)) // map[r][c] 포함 연속된 X만큼 값이 동일한지 검사
							continue outer;

						preValue = map[r][c];
						
						r += X - 1;
						start = r+1;
					} else
						continue outer;
				}
				//System.out.println(c);
				ans++;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean checkPossible(int r, int c, boolean hor) {
		int stand = map[r][c]; // 연속되어야 하는 값

		if (hor) { // 수평 방향인 경우'
			if (c + X > N)
				return false;
			for (int i = c; i < c + X; i++) {
				if (map[r][i] != stand)
					return false;
			}
		} else {
			if (r + X > N)
				return false;
			for (int i = r; i < r + X; i++) {
				if (map[i][c] != stand)
					return false;
			}
		}
		return true;
	}
}