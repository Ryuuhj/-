package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main_2217 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] rope = new Integer[N];
        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope, Collections.reverseOrder());

        int maxWeight = 0;
        for (int i = 0; i < N; i++) {
            int tmp = rope[i] * (i + 1);
            maxWeight = Math.max(maxWeight, tmp);
        }
        System.out.println(maxWeight);
    }
}
