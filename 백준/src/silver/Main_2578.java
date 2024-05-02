package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_2578 {
    static int bingo = 0;
    static int[] rows = {0, 5, 5, 5, 5, 5};
    static int[] columns = {0, 5, 5, 5, 5, 5};
    static int[] cross = {5, 5}; //[0] 1,1 - 5,5 방향 대각선, [1] 1,5 - 5,1 방향 대각선
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Pos> board = new HashMap<>();
        StringTokenizer st;
        int answer = 25;

        //보드 세팅
        for (int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                board.put(Integer.parseInt(st.nextToken()), new Pos(i, j));
            }
        }
        //사회자가 5줄에 걸쳐 번호 부름
        loopOut:
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                Pos p = board.get(num);
                if(getBingo(p, i, j)) {
                    answer = i * 5 + j;
                    break loopOut;
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean getBingo(Pos p, int i, int j) {
        //1. rows, cols 에서 해당하는 부분 개수-1
        if(rows[p.r] == 1)
            bingo++;
        rows[p.r]--;

        if(columns[p.c] == 1)
            bingo++;
        columns[p.c]--;

        //대각선 체크
        if(p.r == p.c) {
            cross[0]--;
            if (cross[0] == 0)
                bingo++;
        }
        if(p.r + p.c == 6) {
            cross[1]--;
            if (cross[1] == 0)
                bingo++;
        }

        if(bingo >= 3)
            return true;

        return false;
    }

    private static class Pos {
        int r, c;
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
