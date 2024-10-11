import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A, op;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        op = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        operation(A[0], 1);
        System.out.println(max);
        System.out.println(min);

    }

    private static void operation(int cur, int idx) {
        if(idx == N){
            min = Math.min(min, cur);
            max = Math.max(max, cur);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(op[i] > 0){
                op[i]--;
                operation(calculate(cur, A[idx], i), idx+1);
                op[i]++;
            }

        }
    }

    private static int calculate(int a, int b, int op) {
        if(op == 0)
            return a + b;
        else if (op == 1)
            return a - b;
        else if (op == 2)
            return a * b;
        else
            return a/b;
    }
}