package silver;

import java.util.Scanner;

public class Main_1789 {
    static long S;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextLong();
        search(S, 0, 0);
    }

    private static void search(long S, int idx, long cnt) {
        if(S < 0){
            return;
        }
        if(S == 0){
            System.out.println(cnt);
            System.exit(0);
        }
        for (int i = idx+1; i <= S; i++) {
            search(S-i, i, cnt+1);
        }
    }
}
