package bronze;

import java.util.Scanner;

public class Main_2460 {
    static int passenger, max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        max = 0; passenger = 0;
        for (int i = 0; i < 10; i++) {
            passenger += (-sc.nextInt() + sc.nextInt());
            max = Math.max(passenger, max);
        }
        System.out.println(max);
    }
}
