package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1978 {
    static int N, pCnt;
    static boolean[] isPrime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        isPrime = new boolean[1001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(1000); i++) {
            if(isPrime[i]) {
                for (int j = i * 2; j <= 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        N = sc.nextInt();
        pCnt = 0;
        while (N-- > 0) {
            if(isPrime[sc.nextInt()]) pCnt++;
        }
        System.out.println(pCnt);
    }
}
