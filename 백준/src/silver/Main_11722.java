package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11722 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] maxLength = new int[1001];

        //maxLength[idx] => idx의 숫자를 마지막으로 하는 감소 수열의 최대길이
        for (int i = 0; i < N; i++) {
            int num = A[i];
            int max = 0;
            for (int j = num + 1; j <= 1000; j++) {
                max = Math.max(max, maxLength[j]);
            }
            maxLength[num] = max + 1;
        }
        System.out.println(Arrays.stream(maxLength).max().getAsInt());
    }
}
