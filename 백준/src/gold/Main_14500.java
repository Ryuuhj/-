package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14500 {
    final static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; //변끼리 연결되어야 하므로 상하좌우 탐색만 가능
    static int N, M, max = Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[][] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                search(i, j, 1, arr[i][j]);
                visit[i][j] = false;
            }
        }
        System.out.println(max);
    }

    private static void search(int x, int y, int cnt, int sum) {
        if(cnt == 4){
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
                if (cnt == 2) {
                    visit[nx][ny] = true;
                    search(x, y, cnt + 1, sum + arr[nx][ny]);
                    visit[nx][ny] = false;
                }
                visit[nx][ny] = true;
                search(nx, ny, cnt + 1, sum + arr[nx][ny]);
                visit[nx][ny] = false;
            }
        }
    }

}
