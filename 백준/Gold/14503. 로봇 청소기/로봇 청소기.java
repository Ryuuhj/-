import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, M;
    static int rX, rY, d;
    static boolean[][] cleaned;
    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        rX = Integer.parseInt(st.nextToken()); rY = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        String[][] map = new String[N][M];
        cleaned = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split(" ");
        }
        System.out.println(startCleaning(map));
    }

    private static int startCleaning(String[][] map) {
        int cnt = 0;

        while (true) {
            if(map[rX][rY].equals("0") && !cleaned[rX][rY]){ //청소 안돼있으면 선 청소
                cnt++;
                cleaned[rX][rY] = true;
            }
            //주변 4방향 탐색 -> 빈 칸 있으면 다시 1번, 없으면 후진
            if(!isPossible(map)) {
                rX -= move[d][0];
                rY -= move[d][1];
                if(map[rX][rY].equals("1"))
                    break;
            }
        }
        return cnt;
    }

    private static boolean isPossible(String[][] map) {
        for (int i = 1; i <= 4; i++) {
            int nextD = (d + 4 - i) % 4;
            int nextX = rX + move[nextD][0];
            int nextY = rY + move[nextD][1];
            if(map[nextX][nextY].equals("0") && !cleaned[nextX][nextY]){
                rX = nextX; rY = nextY;
                d = nextD;
                return true;
            }
        }
        return false;
    }
}