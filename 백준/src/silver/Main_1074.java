package silver;

import java.util.Scanner;

public class Main_1074 {
    static int[] dx = {0, 0, 1, 1};
    static int[] dy = {0, 1, 0, 1};
    static int tx, ty, x2, y2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tx = sc.nextInt();
        ty = sc.nextInt();
        N = (int) Math.pow(2, N);
        divide(0, 0, 0 , N);
    }

    private static void divide(int x, int y,int now, int n) {
        if(n == 1) return;
        int iUnit = n / 2;
        int valUnit = (n / 2) * (n / 2);
        x2 = x + n-1; y2 = y + n-1;
        if(!(x <= tx && y <= ty && tx <= x2 && ty <= y2)) return;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i] * iUnit;
            int ny = y + dy[i] * iUnit;
            int next = now + valUnit * i;
            if(nx == tx && ny == ty) {
                System.out.println(next);
                System.exit(0);
            }
            divide(nx, ny, next, iUnit);
        }
    }
}
