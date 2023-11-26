package silver;

import java.util.Scanner;

public class Main_1292 {
    static int[] nums;
    static int A, B, cnt, val, sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        sum = 0; cnt = 0;
        for (int v = 1; ; v++) {
            for (int interCnt = 1; interCnt <= v; interCnt++) {
                cnt++;
                if(cnt >= A && cnt <= B) sum += v;
            }
            if(cnt > B) break;
        }
        System.out.println(sum);
    }
}
