package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17435 {
    final static int log = (int) (Math.log(500000) / Math.log(2));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());

        int[][] f = new int[log+1][m + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            f[0][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= log; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = f[i-1][f[i-1][j]];
            }
        }

        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            for (int b = log; b > -1; b--) {
                int tmp = (1 << b); // 1101에서 제일 앞(2^3) 부터 검사
                if(n >= tmp){
                    n -= tmp; //일치하는 비트 지우고
                    x = f[b][x]; //x 업데이트
                    if(n == 0) break; //다 지웠으면 탈출
                }
            }
            sb.append(x).append("\n");
        }
        System.out.println(sb);
    }
}
