package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int[][] map;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1){
                    num++;
                    bfs(i, j, num);
                }
            }
        }
        if(num == 1) {
            System.out.println("0");
            return;
        }
        cnt = new int[num - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != 0){
                    cnt[map[i][j] - 2]++;
                }
            }
        }
        Arrays.sort(cnt);
        System.out.println(num-1);
        Arrays.stream(cnt).forEach(System.out::println);
    }

    private static void bfs(int i, int j, int num) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(i, j));
        map[i][j] = num;
        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nextX = now.x + dx[k];
                int nextY = now.y + dy[k];
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && map[nextX][nextY] == 1) {
                    queue.add(new Pos(nextX, nextY));
                    map[nextX][nextY] = num;
                }
            }
        }
    }
    private static class Pos {
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
