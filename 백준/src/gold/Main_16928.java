package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16928 {
    static int N;
    static int[] dice = {1, 2, 3, 4, 5, 6};
    static int[] snakeLadder = new int[101];
    static int[] minCnt = new int[101];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        Arrays.fill(minCnt, Integer.MAX_VALUE);
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            snakeLadder[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        bfs(1);
        System.out.println(minCnt[100]);
    }

    private static void bfs(int start) {
        Queue<Root> queue = new LinkedList<>();
        queue.add(new Root(start, 0));
        minCnt[start] = 0;
        while (!queue.isEmpty()) {
            Root now = queue.poll();
            for (int d : dice) {
                int nextPos = now.pos + d;
                if(nextPos > 100) break;
                nextPos = snakeLadder[nextPos] == 0 ? nextPos : snakeLadder[nextPos];
                if (minCnt[nextPos] > now.diceCnt + 1) {
                    queue.add(new Root(nextPos, now.diceCnt + 1));
                    minCnt[nextPos] = now.diceCnt + 1;
                }
            }
        }
    }
    private static class Root {
        int pos; int diceCnt;

        Root(int pos, int diceCnt) {
            this.pos = pos;
            this.diceCnt = diceCnt;
        }
    }
}
