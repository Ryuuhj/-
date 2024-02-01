package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_14889 {
    static StringTokenizer st;
    static int N, ans = Integer.MAX_VALUE;
    static int[][] power;
    static ArrayList<Integer> start = new ArrayList<>();
    static ArrayList<Integer> link = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        power = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                power[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        explore(0, 0, 1);
        System.out.println(ans);
    }

    private static void explore(int sSize, int lSize, int player) {
        if (player > N) {
            if(lSize != sSize) return;
            int tmp = Math.abs(calScore(sSize, start) - calScore(lSize, link));
            ans = Math.min(ans, tmp);
            return;
        }
        start.add(player);
        explore(sSize+1, lSize, player + 1);
        start.remove(sSize);
        link.add(player);
        explore(sSize, lSize + 1, player + 1);
        link.remove(lSize);
    }

    private static int calScore(int size, ArrayList<Integer> list) {
        int sum = 0;
        if(size <= 1)
            return size == 0 ? 0 : list.get(0);

        for (int i = 0; i < size - 1; i++) {
            int p1 = list.get(i);
            for (int j = i + 1; j < size; j++) {
                int p2 = list.get(j);
                sum += (power[p1][p2] + power[p2][p1]);
            }
        }
        return sum;
    }
}
