package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M;
    static int[][] maze;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            maze[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        bfs(0, 0);
        System.out.println(maze[N - 1][M - 1]);
    }

    //dfs로 하면 시간 초과
    private static void bfs(int x, int y) {
        Queue<Pos> queue = new LinkedList<>();
        visit[x][y] = true;
        queue.add(new Pos(x, y));
        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && maze[nx][ny] == 1 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    maze[nx][ny] = maze[now.x][now.y] + 1;
                    queue.add(new Pos(nx, ny));
                }
            }

        }
    }
    private static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


