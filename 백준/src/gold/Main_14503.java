package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503 {
    static int[] dir = {0, 3, 2, 1}; //반시계로 설정해주기 위해 바꿈
    static String[][] map;
    static int N, M, nr, nc, d, nextD;
    //북 - 서 - 남 - 동
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static boolean[][] cleaned;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        cleaned = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        nr = Integer.parseInt(st.nextToken()); nc = Integer.parseInt(st.nextToken());
        d = dir[Integer.parseInt(st.nextToken())];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split(" ");
        }
        int ans = getClean();
        System.out.println(ans);
    }

    private static int getClean() {
        int cnt = 0;
        loopOuter:
        while (true) {
            //1. 현재 칸 청소 안됐으면 하기
            if(map[nr][nc].equals("0") && !cleaned[nr][nc]) {
                cleaned[nr][nc] = true;
                cnt++;
            }
            //2-1. 현재 칸 동서남북 중 0 있는지 검사
            for (int i = 1; i <= 4; i++) {
                nextD = (d + i) % 4;
                int nextR = nr + dr[nextD];
                int nextC = nc + dc[nextD];
                if(map[nextR][nextC].equals("0") && !cleaned[nextR][nextC]){
                    nr = nextR; nc = nextC;
                    d = nextD;
                    continue loopOuter;
                }
            }
            //2-2. 현재 칸 주변 4칸 모두 청소된 경우
            nextD = (d+2)%4;
            nr += dr[nextD];
            nc += dc[nextD];
            if(map[nr][nc].equals("1")) break; //후진 후 벽이면 멈춤
        }
        return cnt;
    }
}
