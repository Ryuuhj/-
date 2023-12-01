package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2581 {
    static int M, N, sum, min;
    static boolean[] isPrime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        sum = 0;
        min = Integer.MAX_VALUE;
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                sum += i;
                min = Math.min(min, i);
            }
        }
        if (sum == 0)
            System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
