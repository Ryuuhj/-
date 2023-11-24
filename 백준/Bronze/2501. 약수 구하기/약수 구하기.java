import java.util.Scanner;

public class Main {
    static int cnt, N, K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) cnt++;
            if (cnt == K) {
                System.out.println(i);
                break;
            }
        }
        if(cnt < K)
            System.out.println(0);
    }
}