package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6064 {
    static int M, N, x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1; //M=x , N=y인 경우 나머지값 0 방지
            int gcd = getGCD(M, N);
            int lcm = (M / gcd) * (N / gcd) * gcd;
            int ans = -1;
            for (int k = x; k <= lcm; k += M) {
                if(k % N == y){
                    ans = k + 1;
                    break;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    private static int getGCD(int m, int n) {
        if(n == 0) return m;
        return getGCD(n, m % n);
    }

}
