package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_14499 {
    static int[] nextBase = {0, 3, 4, 2, 5}; //시작 위치 윗면 1, 동쪽 3 기준
    static int[][] map;
    static int[][] roll = {{0, 0},{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; //동서북남
    static Map<Integer, Integer> diceNum = new HashMap<>();
    static int now = 6; //주사위 시작 바닥 = 6
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //지도 크기
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        // 시작 좌표
        int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken());
        // 명령 개수
        int K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        now = 6;
        while (K-- > 0) {
            int dir = Integer.parseInt(st.nextToken());
            int nx = x + roll[dir][0];
            int ny = y + roll[dir][1];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                continue;
            sb.append(rollDice(nx, ny, dir)).append("\n");
            x = nx; y = ny;
        }
        System.out.print(sb);
    }

    private static int rollDice(int x, int y, int dir) {
        //next 값 정의
        int next = nextBase[dir];
        int upper = 7 - next;
        //주사위를 dir 방향으로 굴리기
        if (dir <= 2) {
            nextBase[3 - dir] = now;
            nextBase[dir] = 7 - now;
        } else {
            nextBase[7 - dir] = now;
            nextBase[dir] = 7 - now;
        }
        //주사위 돌림 -> 다음 밑면 기준 값 갱신 후 윗면 출력
        if (map[x][y] == 0 && diceNum.containsKey(next)) { //이동한 칸이 0인 경우 -> 바닥면의 수 복사됨
            map[x][y] = diceNum.get(next);
        } else {//이동한 칸이 0이 아닌 경우 -> 바닥면에 복사된 뒤 0으로
            diceNum.put(next, map[x][y]);
            map[x][y] = 0; //갱신 후 map은 0으로 변경
        }
        now = next;
        return diceNum.getOrDefault(upper, 0);
    }
}
