package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11053 {
    static int N, num, max;
    static int[] maxLength = new int[1001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            max = 0;
            for (int j = 0; j < num; j++)
                max = Math.max(max, maxLength[j]);
            maxLength[num] = max + 1;
        }
        System.out.println(Arrays.stream(maxLength).max().getAsInt());
    }
}
