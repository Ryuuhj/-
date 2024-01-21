package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15651 {
    static int N, M;
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder(" ".repeat(M * 2));
        getSeq(sb, 0);
        System.out.println(ans);
    }

    private static void getSeq(StringBuilder sb, int length) {
        if(length == M * 2){
            ans.append(sb.toString()).append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            sb.setCharAt(length, (char) (i + '0'));
            getSeq(sb, length+2);
        }
    }
}
