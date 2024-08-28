import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, K;
	static int[][] map;
	static PriorityQueue<Cell> pq = new PriorityQueue<>();
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N+K+1][M+K+1];
			pq.clear();
			
			int sx = K/2+1;
			int sy = K/2+1;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[sx+i][sy+j] = Integer.parseInt(st.nextToken());
					if(map[sx+i][sy+j] != 0)
						pq.offer(new Cell(sx+i, sy+j, 0, map[sx+i][sy+j]));
				}	
			}
			
			N = N+K+1; 
			M = M+K+1;
			
			//k초 동안 돌리면서 이동
			HashSet<Cell> temp = new HashSet<>();
			while(K--> 0) {
				while(!pq.isEmpty()) {
					Cell cur = pq.poll();
					
					// 지금 세포가 x면 (활성화 직후)
					if(cur.time == cur.X) {
						
						//1칸씩 확장 -> 확장한 세포들 set에 넣기 (기존 값이 존재하지 않는다면)
						for (int dir = 0; dir < 4; dir++) {
							int nr = cur.r + dr[dir];
							int nc = cur.c + dc[dir];
							if(nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] != 0) continue;
							map[nr][nc] = cur.X;
							temp.add(new Cell(nr, nc, 0, cur.X));
						}
					} //비활성화 OR 번식 후 활성화 상태인 경우 -> 시간 증가 후 거르기
					cur.increaseTime();
					if(cur.time >= cur.X*2) continue;
					temp.add(cur);
				}
				
				//모든 작업 끝난 후 pq에 다시
				pq.addAll(temp);
				temp.clear();
			}
			sb.append("#").append(tc).append(" ").append(pq.size()).append("\n");
			
		} 
		System.out.println(sb);

	}
	
	static class Cell implements Comparable<Cell> {
		int r, c, time, X;

		Cell(int r, int c, int time, int X) {
			this.r = r;
			this.c = c;
			this.time = time;
			this.X = X;
		}

		@Override
		public int compareTo(Cell o) {
			return o.X - this.X;
		}
		
		void increaseTime() {
			this.time += 1;
		}
	}
}