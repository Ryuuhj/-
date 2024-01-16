package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder(M);
        dfs(sb, 1, 0);
    }

    private static void dfs(StringBuilder sb, int last, int length) {
        if (length == M) {
            System.out.println(sb);
            return;
        }
        for (int i = last; i <= N; i++) {
            sb.append(i).append(" ");
            dfs(sb, i, length+1);
            sb.delete(sb.length() - 2, sb.length());
        }
    }
}
