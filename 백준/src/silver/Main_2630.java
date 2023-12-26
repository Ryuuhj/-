package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2630 {
    static int N;
    static int[][] paper;
    static int[] cnt = {0, 0};
    static int[] dx = {0, 0, 1, 1};
    static int[] dy = {0, 1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][];
        for (int i = 0; i < N; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        dfs(new Pos(0, 0), new Pos(N - 1, N - 1), N);
        for(int n : cnt){
            System.out.println(n);
        }
    }

    private static void dfs(Pos s, Pos e, int len) {
        if (len == 1 || isSame(s, e, len)) {
            cnt[paper[s.x][s.y]]++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nL = len / 2;
            Pos nStart = new Pos(s.x + dx[i] * nL, s.y + dy[i] * nL);
            Pos nEnd = new Pos(nStart.x + nL - 1, nStart.y + nL - 1);
            dfs(nStart, nEnd, nL);
        }

    }

    private static boolean isSame(Pos s, Pos e, int len) {
        int color = paper[s.x][s.y];
        int x = s.x;
        int y = s.y;
        while (x <= e.x){
            if (paper[x][y] != color)
                return false;
            y++;
            if(y > e.y){
                y -= len;
                x++;
            }
        }
        return true;
    }

    private static class Pos{
        int x; int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
