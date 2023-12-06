package silver;

import java.util.Scanner;

public class Main_2609 {
    static int A, B, gcd;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        A = sc.nextInt();
        B = sc.nextInt();
        gcd = getGCD(A, B);
        sb.append(gcd).append("\n").append((A / gcd) * (B / gcd) * gcd);
        System.out.println(sb);
    }
    private static int getGCD(int a, int b) {
        if(a % b == 0) return b;
        return getGCD(b, a % b);
    }
}
