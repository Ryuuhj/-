package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1018 {
    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        //1 = W, -1 = B
        int[] wFirst = {1, -1, 1, -1, 1, -1, 1, -1};
        int[] bFirst = Arrays.stream(wFirst).map(i -> -1 * i).toArray();
        int[][] chess = new int[9][8];
        for (int i = 0; i < 9; i++) {
            if(i % 2 == 0)
                chess[i] = wFirst.clone();
            else
                chess[i] = bFirst.clone();
        }
        int[][] board = new int[M][N];
        for (int i = 0; i < M; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                board[i][j] = line[j] == 'W' ? 1 : -1;
            }
        }
        //보드에서 추출
        int min = Integer.MAX_VALUE;
        for (int r = 0; r < M - 7; r++) {
            for (int c = 0; c < N - 7; c++) {
                min = Math.min(min, explore(r, c, r + 8, c + 8, board, chess));
            }
        }
        System.out.println(min);
    }

    private static int explore(int sx, int sy, int ex, int ey, int[][] board, int[][] chess) {
        int wSum = 0;
        //W 시작인 경우
        for (int i = sx; i < ex; i++) {
            for (int j = sy; j < ey; j++) {
                if(board[i][j] * chess[i - sx][j - sy] == -1)
                    wSum++;
            }
        }
        int bSum = 0;
        //B 시작인 경우
        for (int i = sx; i < ex; i++) {
            for (int j = sy; j < ey; j++) {
                if(board[i][j] * chess[i - sx + 1][j - sy] == -1)
                    bSum++;
            }
        }
        return Math.min(wSum, bSum);
    }
}
