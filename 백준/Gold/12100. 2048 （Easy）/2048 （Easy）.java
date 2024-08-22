import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, maxBlock = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(board, 1, 1);
        System.out.println(maxBlock);
    }
    private static void dfs(int[][] board, int cnt, int max){
        if(cnt > 5){
            maxBlock = Math.max(maxBlock, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] cBoard = new int[N][N];
            move(board, cBoard, i);
            int tmpMax = getMax(cBoard);

            dfs(cBoard, cnt + 1, tmpMax);
        }

    }

    private static void move(int[][] board, int[][] cBoard, int dir) {
        Queue<Integer> queue = new LinkedList<>();
        int idx, block;
        switch (dir) {
            case 0: //위로 이동
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(board[j][i] != 0)
                            queue.add(board[j][i]);
                    }
                    idx = 0;
                    while (!queue.isEmpty()) {
                        block = queue.poll();
                        if(cBoard[idx][i] == 0)
                            cBoard[idx][i] = block;
                        else if (cBoard[idx][i] == block) {
                            cBoard[idx++][i] *= 2;
                        } else {
                            cBoard[++idx][i] = block;
                        }
                    }
                }
                break;
            case 1: //왼쪽
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (board[i][j] != 0)
                            queue.add(board[i][j]);
                    }
                    idx = 0;
                    while (!queue.isEmpty()) {
                        block = queue.poll();
                        if(cBoard[i][idx] == 0)
                            cBoard[i][idx] = block;
                        else if (cBoard[i][idx] == block) {
                            cBoard[i][idx++] *= 2;
                        } else {
                            cBoard[i][++idx] = block;
                        }
                    }
                }
                break;
            case 2: //아래
                for (int i = 0; i < N; i++) {
                    for (int j = N - 1; j >= 0; j--) {
                        if(board[j][i] != 0)
                            queue.add(board[j][i]);
                    }
                    idx = N-1;
                    while (!queue.isEmpty()) {
                        block = queue.poll();
                        if(cBoard[idx][i] == 0)
                            cBoard[idx][i] = block;
                        else if (cBoard[idx][i] == block) {
                            cBoard[idx--][i] *= 2;
                        } else {
                            cBoard[--idx][i] = block;
                        }
                    }
                }
                break;
            case 3: // 오른쪽
                for (int i = 0; i < N; i++) {
                    for (int j = N - 1; j >= 0; j--) {
                        if(board[i][j] != 0) queue.add(board[i][j]);
                    }
                    idx = N-1;
                    while (!queue.isEmpty()) {
                        block = queue.poll();
                        if(cBoard[i][idx] == 0)
                            cBoard[i][idx] = block;
                        else if (cBoard[i][idx] == block) {
                            cBoard[i][idx--] *= 2;
                        } else {
                            cBoard[i][--idx] = block;
                        }
                    }
                }
                break;
        }
    }

    private static int getMax(int[][] board) {
        int tmp = 0;
        for(int[] b : board){
            tmp = Math.max(tmp, Arrays.stream(b).max().getAsInt());
        }
        return tmp;
    }
}
