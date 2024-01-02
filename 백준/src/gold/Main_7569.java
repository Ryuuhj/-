package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569 {
    static int N, M, H;
    static int[][][] storage;
    static int[][] move = {{0, 0, 1}, {0, -1, 0}, {0, 0, -1}, {0, 1, 0}, {1, 0, 0}, {-1, 0, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        storage = new int[H][N][M];
        Queue<Tomato> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    storage[i][j][k] = Integer.parseInt(st.nextToken());
                    if(storage[i][j][k] == 1)
                        queue.add(new Tomato(i, j, k));
                }
            }
        }
        bfs(queue);
        int answer = 1;
        loopA:
        for (int[][] plate : storage) {
            for (int[] line : plate) {
                for (int tomato : line) {
                    if(tomato == 0){
                        answer = 0;
                        break loopA;
                    }
                    answer = Math.max(answer, tomato);
                }
            }
        }
        System.out.println(answer - 1);
    }

    private static void bfs(Queue<Tomato> queue) {
        while (!queue.isEmpty()) {
            Tomato now = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nz = now.z + move[i][0];
                int nx = now.x + move[i][1];
                int ny = now.y + move[i][2];
                if (nz >= 0 && nz < H && nx >= 0 && nx < N && ny >= 0 && ny < M && storage[nz][nx][ny] == 0) {
                    storage[nz][nx][ny] = storage[now.z][now.x][now.y] + 1;
                    queue.add(new Tomato(nz, nx, ny));
                }
            }
        }
    }

    private static class Tomato {
        int z; int x; int y;

        Tomato(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
}
