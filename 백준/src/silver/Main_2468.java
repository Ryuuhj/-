package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468 {
    static int[][] move = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int minH = Integer.MAX_VALUE, maxH = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, map[i][j]);
                minH = Math.min(minH, map[i][j]);
            }
        }
        int answer = 1;
        for (int i = minH; i < maxH; i++) {
            answer = Math.max(answer, getSafeCnt(i));
        }
        System.out.println(answer);
    }

    private static int getSafeCnt(int height) {
        visited = new boolean[N][N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > height && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(height, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void bfs(int height, int x, int y) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y));
        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + move[i][0];
                int ny = now.y + move[i][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] <= height || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.add(new Pos(nx, ny));
            }
        }
    }

    private static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
