package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1987 {
    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int R, C, maxCnt = 0;
    static char[][] board;
    static Set<Character> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }
        set.add(board[0][0]);
        explore(0, 0, 1);
        System.out.println(maxCnt);
    }

    private static void explore(int x, int y, int cnt) {

        for (int i = 0; i < 4; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C || set.contains(board[nx][ny])) continue;
            set.add(board[nx][ny]);
            explore(nx, ny, cnt + 1);
            set.remove(board[nx][ny]);
        }

        maxCnt = Math.max(cnt, maxCnt);
    }
}

