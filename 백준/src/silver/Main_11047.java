package silver;

import java.util.Scanner;

public class Main_11047 {
    static int N;
    static int[] coins;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        long K = sc.nextLong();
        int cnt = 0;
        coins = new int[N];
        for (int i = N-1; i >= 0; i--) {
            coins[i] = sc.nextInt();
        }
        for (int coin : coins) {
            if(K / coin > 0){
                cnt += (K / coin);
                K %= coin;
                if(K == 0) break;
            }
        }
        System.out.println(cnt);
    }

}
