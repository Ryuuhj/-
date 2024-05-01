package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_14888 {
    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[] A, operator;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        operator = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(A[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int tmp, int idx) {
        if(idx == N){
            min = Math.min(tmp, min);
            max = Math.max(tmp, max);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(operator[i] == 0)
                continue;
            operator[i]--;
            int next = calculate(i, tmp, A[idx]);
            dfs(next, idx + 1);
            operator[i]++;
        }
    }

    private static int calculate(int op, int n1, int n2) {
        switch (op) {
            case 0: //덧셈
                return n1 + n2;
            case 1: //뺄셈
                return n1 - n2;
            case 2:
                return n1 * n2;
            case 3:
                return n1 / n2;
        }
        return 0;
    }
}
