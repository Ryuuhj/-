package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3085 {
    static int[][] map;
    static int N, maxEat = 0;
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < N; j++) {
                switch (str.charAt(j)) {
                    case 'C':
                        map[i][j] = 0; break;
                    case 'P':
                        map[i][j] = 1; break;
                    case 'Z':
                        map[i][j] = 2; break;
                    case 'Y':
                        map[i][j] = 3; break;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-1; j++) {
                if(j + 1 < N){ //오른쪽 탐색
                    swap(i, j, i, j+1);
                    search(i, true);
                    search(j, false);
                    search(j+1, false);
                    swap(i, j, i, j+1);
                }
                if(i + 1 < N) {//아래 교환 후 탐색
                    swap(i, j, i+1, j);
                    search(i, true);
                    search(i+1, true);
                    search(j, false);
                    swap(i, j, i+1, j);
                }
            }
        }
        System.out.println(maxEat);
    }

    private static void search(int f, boolean isRow) {
        int[] tmpMax = {0, 0, 0, 0};
        int color, cnt = 1;
        if(isRow){
            //i == row
            color = map[f][0];
            for (int j = 1; j < N; j++) {
                if(color != map[f][j]){
                    tmpMax[color] = Math.max(tmpMax[color], cnt);
                    color = map[f][j];
                    cnt = 1;
                }else{
                    cnt++;
                }
            }
            tmpMax[color] = Math.max(tmpMax[color], cnt);
        }else{
            color = map[0][f];
            for (int j = 1; j < N; j++) {
                if(color != map[j][f]){
                    tmpMax[color] = Math.max(tmpMax[color], cnt);
                    color = map[j][f];
                    cnt = 1;
                }else{
                    cnt++;
                }
            }
            tmpMax[color] = Math.max(tmpMax[color], cnt);
        }
        maxEat = Math.max(Arrays.stream(tmpMax).max().getAsInt(), maxEat);
    }

    private static void swap(int r1, int c1, int r2, int c2) {
        int tmp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = tmp;
    }

}
