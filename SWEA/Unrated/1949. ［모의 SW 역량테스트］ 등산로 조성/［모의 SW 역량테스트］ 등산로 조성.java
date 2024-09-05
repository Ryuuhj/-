import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    static int N, K, answer;
    static int[][] map;
    static int[][][] maxCnt;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    
    static class Pos {
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visited = new boolean[N][N];
            
            HashSet<Pos> starts = new HashSet<>();
            int tmpMax = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] > tmpMax) {
                    	starts.clear();
                    	starts.add(new Pos(i, j));
                    	tmpMax = map[i][j];
                    }else if(map[i][j] == tmpMax)
                    	starts.add(new Pos(i, j));
                }
            }
            
            answer = 0;
            for(Pos start : starts) {
            	maxCnt = new int[2][N][N];
            	visited[start.x][start.y] = true; 
            	dfs(start.x , start.y, map[start.x][start.y], 1, 0); //cut = 0 (x) 1 (O)
            	visited[start.x][start.y] = false;
            }
            
            sb.append("#").append(tc).append(" ").append(answer).append("\n");

        }
        System.out.println(sb);
    }
	private static void dfs(int x, int y, int prev, int count, int cut) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
			else { 
				int tempCut = cut;
				int tPrev = prev;
				if(map[nx][ny] >= prev) { //깎아야 하는 경우
					if(cut != 0 || map[nx][ny] - K >= prev)
						continue; //이미 깎았거나 깎아도 안되는 경우
					tempCut = 1; //깎음
					tPrev = map[x][y] - 1; //map[nx][ny] = prev-1로 갱신
				}else  //안 깎아도 되는 
					tPrev = map[nx][ny];
				
				visited[nx][ny] = true;
				//maxCnt[tempCut][nx][ny] = Math.max(maxCnt[tempCut][nx][ny], count + 1);
				dfs(nx, ny, tPrev, count+1, tempCut); 
				visited[nx][ny] = false;
			}
		}
		answer = Math.max(answer, count);
	}
}