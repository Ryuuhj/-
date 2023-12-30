package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {
    static int N, M;
    static int[][] storage;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Tomato> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        storage = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                storage[i][j] = Integer.parseInt(st.nextToken());
                if(storage[i][j] == 1){
                    queue.add(new Tomato(i, j));
                }
            }
        }
        bfs();
        int ans = 1;
        loopA:
        for (int[] tomatoes : storage) {
            for (int t : tomatoes) {
                if(t == 0){
                    ans = 0;
                    break loopA;
                }
                ans = Math.max(ans, t);
            }
        }
        System.out.println(ans - 1);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Tomato now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && storage[nx][ny] == 0) {
                    storage[nx][ny] = storage[now.x][now.y] + 1;
                    queue.add(new Tomato(nx, ny));
                }
            }
        }
    }

    private static class Tomato {
        int x;
        int y;
         Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
