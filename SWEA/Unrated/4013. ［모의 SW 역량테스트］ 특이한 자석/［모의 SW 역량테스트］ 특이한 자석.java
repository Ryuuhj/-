import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    static int[][] magnet; //1 ~ 4번 자석 8개 번호 저장
    static int[] top, dir;
    static int K, answer;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc < T+1; tc++) {
            sb.append("#").append(tc).append(" ");
            top = new int[5];
            magnet = new int[5][8];
            dir = new int[5];
            visited = new boolean[5];
            K = Integer.parseInt(br.readLine());
            for (int i = 1; i < 5; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    magnet[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                checkSpin(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                //회전 체크 후 해당하는 자석 모두 회전
                spin();
            }
            //최종 답
            int ans = 0;
            for (int i = 1; i < 5; i++) {
                ans += magnet[i][top[i]] * Math.pow(2, i - 1);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void spin() {
        for (int i = 1; i < 5; i++) {
            if(dir[i] == 0) continue;
            if(dir[i] == 1)//시계
                top[i] = (top[i] + 7) % 8;
            else
                top[i] = (top[i] + 1) % 8;
            dir[i] = 0;
            visited[i] = false;
        }
    }

    private static void checkSpin(int now, int d) {
        if(now < 1 || now > 4) return;
        visited[now] = true;
        dir[now] = d;
        if(now - 1 > 0 && !visited[now-1]){ //왼쪽
            if(magnet[now][(top[now] + 6) % 8] != magnet[now-1][(top[now-1] +2)%8])
                checkSpin(now - 1, d * -1);
        }

        if(now+1 < 5 && !visited[now+1]){
            if(magnet[now][(top[now]+2)%8] != magnet[now+1][(top[now+1]+6)%8])
                checkSpin(now + 1, d * -1);
        }
    }
}