import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int R, C, M, answer;
	static Shark[][] map;
	static ArrayList<Shark> aliveSharks;
	static boolean[] died = new boolean[10001];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[] pair = {1, 0, 3, 2};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark[R][C];
		aliveSharks = new ArrayList<>(M);
		
		int r, c, s, d, z;
		while(M--> 0) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken()) - 1;
			z = Integer.parseInt(st.nextToken());
			Shark shark = new Shark(r, c, s, d, z);
			aliveSharks.add(shark);
			map[r][c] = shark;
		}
		
		//C초만큼 이동
		for (int time = 0; time < C; time++) {
			//상어 잡기
			huntShark(time);
			//상어 이동
			moveShark();
		}
		System.out.println(answer);
		
	}

	private static void huntShark(int cur) {
		//현재 map에서 cur열에 가장 가까운 상어 죽임
		for (int i = 0; i < R; i++) {
			if(map[i][cur] != null) {
				answer += map[i][cur].z;
				aliveSharks.remove(map[i][cur]);
				map[i][cur] = null;
				return;
			}
		}
	}

	private static void moveShark() {
		//상어무게를 index로 visited 배열 만들어서 겹치는 경우 해당 무게를 true 처리 해줌
		Shark[][] temp = new Shark[R][C];
		
		//남은 상어 이동
		for(Shark shark : aliveSharks) {
			int dist = shark.s % (2*(shark.d < 2 ? R : C) - 2);
			int dir = shark.d;
			
			int nx = shark.r;
			int ny = shark.c;
			
			for (int i = 0; i < dist; i++) {
				nx += dx[dir];
				ny += dy[dir];
				
				if(nx < 0 || nx >= R) {
					dir = pair[dir];
					nx += dx[dir]*2;
				}else if(ny < 0 || ny >= C) {
					dir = pair[dir];
					ny += dy[dir]*2; //범위 넘은거 처리
				}
			}
			shark.d = dir;
			shark.r = nx;
			shark.c = ny;
			
			if(temp[nx][ny] == null || temp[nx][ny].z < shark.z) {
				temp[nx][ny] = shark;
			}
			
		}
		//기존판과 비교하며 있는것만 다시 넣음
		aliveSharks.clear();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(temp[i][j] != null)
					aliveSharks.add(temp[i][j]);
			}
		}
		map = temp;
	}

	static class Shark {
		int r, c, s, d, z;

		Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

}
