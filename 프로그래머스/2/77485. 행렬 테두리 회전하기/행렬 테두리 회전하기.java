import java.util.*;
class Solution {
    static int x, y, nx, ny;
    static int[][] arr;
    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Deque<Integer> dq;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        arr = new int[rows + 1][columns + 1];
        //초기화
        int k = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                arr[i][j] = k;
                k++;
            }
        }
        dq = new ArrayDeque<>();
        for (int i = 0; i < queries.length; i++) {
            answer[i] = spin(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }
        return answer;
    }
    public int spin(int sx, int sy, int ex, int ey) {
        int dir = 0;
        int min = Integer.MAX_VALUE;
        x = sx;
        y = sy;
        //테두리에 있는 숫자들 덱에 넣음
        do {
            dq.addLast(arr[x][y]);
            nx = x + move[dir][0];
            ny = y + move[dir][1];
            if (nx > ex || ny > ey || nx < sx || ny < sy) {
                dir = (dir + 1) % 4;
                x += move[dir][0];
                y += move[dir][1];
            } else {
                x = nx;
                y = ny;
            }
        } while (x != sx || y != sy);
        //한 칸씩 앞으로 옮김
        dq.addFirst(dq.pollLast());
        
        //이후 다시 처음부터 변경
        x = sx; y = sy;
        while (!dq.isEmpty()) {
            arr[x][y] = dq.pollFirst();
            min = Math.min(min, arr[x][y]);
            nx = x + move[dir][0];
            ny = y + move[dir][1];
            if (nx > ex || ny > ey || nx < sx || ny < sy) {
                dir = (dir + 1) % 4;
                x += move[dir][0];
                y += move[dir][1];
            } else {
                x = nx;
                y = ny;
            }
        }
        return min;
    }
}