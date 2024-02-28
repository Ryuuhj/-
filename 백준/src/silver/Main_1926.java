package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926 {
    static int n, m;
    static String[][] canvas;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        canvas = new String[n][m];

        for (int i = 0; i < n; i++) {
            canvas[i] = br.readLine().split(" ");
        }
        int cnt = 0, maxArea = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && canvas[i][j].equals("1")) {
                    cnt++;
                    maxArea = Math.max(maxArea, bfs(i, j, visited));
                }
            }
        }
        System.out.printf("%d\n%d\n", cnt, maxArea);
    }

    private static int bfs(int x, int y, boolean[][] visited) {
        Queue<Pos> queue = new LinkedList<>();
        int area = 1;
        visited[x][y] = true;
        queue.add(new Pos(x, y));
        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || canvas[nx][ny].equals("0"))
                    continue;
                area++;
                visited[nx][ny] = true;
                queue.add(new Pos(nx, ny));
            }
        }
        return area;
    }

    private static class Pos{
        int x; int y;

        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
