package silver;

import java.util.Scanner;

public class Main_11726 {
    static int[] tiles;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tiles = new int[n + 1];
        tiles[0] = 1; tiles[1] = 1;
        if(n != 1) {
            for (int i = 2; i <= n; i++) {
                tiles[i] = (tiles[i - 1] + tiles[i - 2]) % 10007;
            }
        }
        System.out.println(tiles[n]);
    }
}
