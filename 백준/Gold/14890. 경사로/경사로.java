import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int cnt = 0;
        //column 방향, row 방향 길 탐색
        for (int i = 0; i < N; i++) {
            if (checkCol(i))//col 방향
                cnt++;
            if(checkRow(i))
                cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean checkRow(int c) {
        boolean[] used = new boolean[N];
        for (int r = 0; r < N - 1; r++) {
            int diff = map[r][c] - map[r + 1][c];
            if(Math.abs(diff) >= 2)
                return false;
            if (diff == -1) { //다음게 더 높은 경우 -> r포함 L개
                for (int i = 0; i < L; i++) {
                    if (r - i < 0 || used[r - i])
                        return false;
                    else if (map[r][c] != map[r - i][c])
                        return false;
                    used[r - i] = true;
                }
            } else if (diff == 1) { //다음게 더 큰 경우 -> r포함 L개
                for (int i = 1; i <= L; i++) {
                    if (r + i >= N || used[r + i])
                        return false;
                    else if (map[r][c] - 1 != map[r + i][c])
                        return false;
                    used[r + i] = true;
                }
            }
        }
        return true;
    }

    private static boolean checkCol(int r) {
        boolean[] used = new boolean[N];
        for (int c = 0; c < N - 1; c++) {
            int diff = map[r][c] - map[r][c + 1]; //현재 - 다음
            if(Math.abs(diff) >= 2)
                return false;
            if(diff == -1){ //다음 계단이 더 높아지는 경우
                for (int i = 0; i < L; i++) { //현재 포함 뒤로 L개 계단
                    if (c - i < 0 || used[c - i])
                        return false;
                    else if (map[r][c] != map[r][c - i])
                        return false;
                    used[c - i] = true;
                }
            } else if (diff == 1) {
                for (int i = 1; i <= L; i++) { //현재 제외 다음 L개
                    if (c + i >= N || used[c + i])
                        return false;
                    else if (map[r][c] - 1 != map[r][c + i])
                        return false;
                    used[c + i] = true;
                }
            }
        }
        return true;
    }

}
