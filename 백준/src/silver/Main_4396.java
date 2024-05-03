package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_4396 {
    static int[][] around = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    static char[][] map;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        String[][] output = new String[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        //입력값
        boolean pushBomb = false; //지뢰 누른지
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if(input[j] == '.'){
                    output[i][j] = ".";
                } else{ //x인 경우
                    if(!pushBomb && map[i][j] == '*')
                        pushBomb = true;
                    if(map[i][j] == '.'){
                        output[i][j] = checkBombCount(i, j);
                    }
                }
            }
        }
        if(pushBomb)
            drawBomb(map, output);
        StringBuilder sb = new StringBuilder();
        for (String[] row : output) {
            for (String e : row) {
                sb.append(e);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void drawBomb(char[][] map, String[][] output) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == '*')
                    output[i][j] = "*";
            }
        }
    }

    private static String checkBombCount(int i, int j) {
        int cnt = 0;
        for (int k = 0; k < 8; k++) {
            int ni = i + around[k][0];
            int nj = j + around[k][1];
            if(ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
            if(map[ni][nj] == '*')
                cnt++;
        }
        return String.valueOf(cnt);
    }
}
