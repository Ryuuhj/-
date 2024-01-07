package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940 {
    static int n, m, k;
    static Pos start;
    static int[][] map, answer;
    static int[][] move = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        answer = new int[n][m];
        for (int[] arr : answer)
            Arrays.fill(arr, -1);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                k = Integer.parseInt(st.nextToken());
                if (k == 2)
                    start = new Pos(i, j);
                else if(k == 0)
                    answer[i][j] = 0;
                map[i][j] = k;
            }
        }
        bfs(start);

        for (int[] row : answer) {
            for (int c : row) {
                sb.append(c).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(Pos start) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(start);
        answer[start.x][start.y] = 0;
        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + move[i][0];
                int ny = now.y + move[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || answer[nx][ny] >= 0) continue;
                queue.add(new Pos(nx, ny));
                answer[nx][ny] = answer[now.x][now.y] + 1;
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
