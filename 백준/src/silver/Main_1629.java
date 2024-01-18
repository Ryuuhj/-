package silver;

import java.util.Scanner;

public class Main_1629 {
    static int C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt(); int B = sc.nextInt(); C = sc.nextInt();
        System.out.println(power(A % C, B));
    }

    private static long power(long a, int b) {
        if (b == 1) return a % C;
        long tmp = power(a, b / 2);
        if (b % 2 == 0)
            return tmp * tmp % C;
        else
            return (tmp * tmp % C) * a % C;
    }
}
