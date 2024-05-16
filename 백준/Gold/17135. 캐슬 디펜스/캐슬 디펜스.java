import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N, M, D, maxKill = 0;
	static List<int[]> enemies = new ArrayList<>();
	static int ivy = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					enemies.add(new int[] {i, j});
			}
		}
		int[] archerPos = new int[3];
		setArcher(0, 0, archerPos);
		System.out.println(maxKill);
	}

	private static void setArcher(int idx, int cnt, int[] archerPos) {
		if(cnt == 3) {
			ivy++;
			maxKill = Math.max(maxKill, playGames(archerPos));
			return;
		}
		for (int i = idx; i < M; i++) {
			archerPos[cnt] = i;
			setArcher(idx+1, cnt+1, archerPos);
		}
		
	}
	private static List<int[]> copy(List<int[]> list) {
		List<int[]> tmp = new ArrayList<>();
		for(int[] p : list) {
			tmp.add(new int[] {p[0], p[1]});
		}
		return tmp;
	}

	private static int playGames(int[] archerPos) {
		int[][] cMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cMap[i][j] = map[i][j];
			}
		}
		//적 위치 복사
		List<int[]> eList = copy(enemies);
		int cnt = 0;
		//archer위치 기준으로 제거
		while(true) {
			//적 없으면 멈춤
			if(eList.isEmpty()) break;
			Set<int[]> target = new HashSet<>();
			//궁수 3명 한 명씩 돌아가며 처리
			for (int l = 0; l < 3; l++) {
				PriorityQueue<Enemy> pq = new PriorityQueue<Main.Enemy>();
				boolean[][] kill = new boolean[N][M];
				int ay = archerPos[l];
				//가능한 적들 저장
				for(int[] e : eList) {
					int dist = Math.abs(N - e[0]) + Math.abs(ay - e[1]);
					if(dist <= D)
						pq.add(new Enemy(e[0], e[1], dist));	
				}
				//제일 가까운 적 죽임
				if(!pq.isEmpty()) {
					Enemy e = pq.poll();
					if(!kill[e.x][e.y]) {
						target.add(new int[] {e.x, e.y});
						kill[e.x][e.y] = true; 
					}
				}
			}
			//3명의 목표물 삭제
			int k = 0;
			for(int[] t : target) {
				//System.out.printf("<<%d %d>> x : %d, y: %d\n",ivy, k++, t[0], t[1]);
				for (int i = eList.size()-1; i >= 0; i--) {
					if(t[0] == eList.get(i)[0] && t[1] == eList.get(i)[1]) {
						eList.remove(i);
						cnt++;
						break;
					}
				}
			}
			//한 칸 이동
			for (int i = eList.size()-1; i >= 0; i--) {
				eList.get(i)[0] += 1;
				if(eList.get(i)[0] == N) 
					eList.remove(i);
			}
		}
		return cnt;
	}
	

	private static class Enemy implements Comparable<Enemy>{
		int x, y;
		int dist;
		
		Enemy(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Enemy o) {
			if(this.dist == o.dist)
				return this.y - o.y;
			return this.dist - o.dist;
		}
	}
}
