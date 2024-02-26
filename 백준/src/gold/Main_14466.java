package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14466 {
    static int N, K, R;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] dirIdx = {{0, 2, 0}, {3, 0, 1}, {0, 0, 0}};
    static int[][][] field;
    static boolean[][] cows;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        field = new int[N+1][N+1][4]; //방향 idx
        cows = new boolean[N + 1][N + 1];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken()); int sY = Integer.parseInt(st.nextToken());
            int eX = Integer.parseInt(st.nextToken()); int eY = Integer.parseInt(st.nextToken());
            //start - end 방향
            int sDir = dirIdx[eX - sX + 1][eY - sY + 1];//s -> e
            int eDir = dirIdx[sX - eX + 1][sY - eY + 1];//e -> s
            field[sX][sY][sDir] = -1;
            field[eX][eY][eDir] = -1;
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows[x][y] = true;
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(cows[i][j]) {
                    int cnt = bfs(i, j);
                    answer += (K - 1 - cnt);
                }
            }
        }
        System.out.println(answer/2);
    }

    private static int bfs(int i, int j) {
        boolean[][] visited = new boolean[cows.length][cows.length];
        Queue<Pos> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.add(new Pos(i, j));
        int encounter = 0;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            for (int k = 0; k < 4; k++) {
                if(field[now.x][now.y][k] == -1)
                    continue;
                int nx = now.x + dir[k][0];
                int ny = now.y + dir[k][1];
                if(nx < 1 || nx > N || ny < 1 || ny > N || visited[nx][ny])
                    continue;
                visited[nx][ny] = true;
                queue.add(new Pos(nx, ny));
                if(cows[nx][ny])
                    encounter++;
            }
        }
        return encounter;
    }
    private static class Pos {
        int x; int y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
