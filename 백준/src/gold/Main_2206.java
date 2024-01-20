package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206 {
    static int N, M, min;
    static char[][] map;
    static boolean[][][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[2][N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        min = bfs(new Pos(0, 0, 1, 0));
        System.out.println(min);
    }

    private static int bfs(Pos start) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(start);
        visit[0][start.x][start.y] = true;
        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            if(now.x == N-1 && now.y == M-1){
                return now.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[now.breakWall][nx][ny]) continue;
                if(map[nx][ny] == '1' && now.breakWall == 1) continue; //벽 있음 + 이미 한 번 부숨
                if(map[nx][ny] == '1' && now.breakWall == 0){ //벽 있음 + 부술 기회 있음
                    queue.add(new Pos(nx, ny, now.cnt + 1, 1)); //부순거 표시
                    visit[1][nx][ny] = true;
                    continue;
                }
                if (map[nx][ny] == '0') {
                    queue.add(new Pos(nx, ny, now.cnt + 1, now.breakWall));
                    visit[now.breakWall][nx][ny] = true;
                }
            }
        }
        return -1;
    }

    private static class Pos {
        int x; int y; int cnt; int breakWall;

        Pos(int x, int y, int cnt, int breakWall) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.breakWall = breakWall;
        }
    }
}
