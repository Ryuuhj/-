package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_14425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> S = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            S.add(br.readLine());
        }
        while (M-- > 0) {
            String input = br.readLine();
            if(S.contains(input))
                cnt++;
        }
        System.out.println(cnt);
    }
}
