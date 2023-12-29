package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9461 {
    /* P배열 자료형 주의, 누적합 값은 int형 범위를 초과할 수 있다 */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] P = new long[101];
        P[1] = 1; P[2] = 1;
        for (int i = 3; i <= 100; i++) {
            P[i] = P[i - 2] + P[i - 3];
        }
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(P[N]).append("\n");
        }
        System.out.print(sb);
    }
}
