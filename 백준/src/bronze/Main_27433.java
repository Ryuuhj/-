package bronze;

import java.util.Scanner;

public class Main_27433 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        long ans = factorial(N);
        System.out.println(ans);
    }

    private static long factorial(int n) {
        if(n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}
