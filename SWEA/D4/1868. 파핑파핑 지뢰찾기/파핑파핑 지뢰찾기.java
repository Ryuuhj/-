import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    static final int[][] dn = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    static int N, nx, ny, cnt;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Pos> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }

            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.') { //지뢰 없는 칸 클릭
                        getC(i, j);
                    }
                }
            }
            for (int i = 0; i < N; i++) { //나머지 단일로 눌러야 하는 칸 찾아 처리
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] == '.') {
                        cnt++;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static void getC(int x, int y) {
        if(visited[x][y] || !isClear(x, y)) return;
        ++cnt; //클릭 카운팅
        queue.clear();
        
        queue.offer(new Pos(x, y));
        visited[x][y] = true;
        
        while (!queue.isEmpty()) { //주변 연쇄 처리
            Pos p = queue.poll();
            
            for (int i = 0; i < 8; i++) { //맞닿은 8칸 처리
                nx = p.x + dn[i][0];
                ny = p.y + dn[i][1];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == '.') {
                    visited[nx][ny] = true; //선 방문처리
                    if(isClear(nx, ny)) //0이면 인접 칸들도 연쇄적 숫자표시 필요(그 외는 굳이 처리할 필요 X 방문처리만)
                        queue.offer(new Pos(nx, ny));
                }
            }
        }
    }

    private static boolean isClear(int x, int y) {
        int bomb = 0;
        int nx, ny;
        for (int i = 0; i < 8; i++) {
            nx = x + dn[i][0];
            ny = y + dn[i][1];
            if(nx > -1 && nx < N && ny > -1 && ny < N && map[nx][ny] == '*') ++bomb;
        }
        return bomb == 0; //0 표시면 true, 아니면 false
    }


    private static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}