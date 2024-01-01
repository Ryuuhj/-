package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_10026 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    static Set<Character> set = new HashSet<>();
    static char[][] paint;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        set.add('R');
        set.add('G');
        paint = new char[N][];
        for (int i = 0; i < N; i++) {
            paint[i] = br.readLine().toCharArray();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bfs(false)).append(" ");
        sb.append(bfs(true));
        System.out.println(sb);
    }

    private static int bfs(boolean isCB) {
        Queue<Pos> queue = new LinkedList<>();
        visit = new boolean[N][N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j]){
                    cnt++;
                    search(isCB, i, j, queue);
                }
            }
        }
        return cnt;
    }

    private static void search(boolean isCB, int x, int y, Queue<Pos> queue) {
        char color = paint[x][y];
        visit[x][y] = true;
        queue.add(new Pos(x, y));

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny]){
                    if ((isCB && set.contains(color) && set.contains(paint[nx][ny]))
                            || paint[nx][ny] == color) {
                        queue.add(new Pos(nx, ny));
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }

    private static class Pos {
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x; int y;
    }
}
