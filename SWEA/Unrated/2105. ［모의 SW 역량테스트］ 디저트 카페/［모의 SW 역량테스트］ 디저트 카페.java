import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int N, answer, sx, sy;
    static int[][] map;
    static boolean[] used = new boolean[101];
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            Arrays.fill(used, false);

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = -1;
            for (int i = 0; i < N-2; i++) {
                for (int j = 1; j < N-1; j++) {
                    sx = i; sy = j;
                    used[map[i][j]] = true;
                    dfs(i, j, 1,  0);
                    used[map[i][j]] = false;
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y, int cnt, int preDir) {
        for (int i = preDir; i < Math.min(preDir+2, 4); i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx == sx && ny == sy) {
                answer = Math.max(answer, cnt);
                return;
            }
            //범위 초과하거나 이미 들른 점일 경우
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || used[map[nx][ny]])  continue;
            used[map[nx][ny]] = true;
            dfs(nx, ny, cnt+1, i);
            used[map[nx][ny]] = false;
        }
    }
}