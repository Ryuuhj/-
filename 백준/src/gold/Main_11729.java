package gold;

import java.util.Scanner;
//하노이 탑 2*hanoi(n-1) + 1
public class Main_11729 {
    static int N, cnt = 0;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt();
        hanoi(N, 1, 2, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }

    private static void hanoi(int rest, int start, int mid, int to) {
        if(rest == 1){
            sb.append(start).append(" ").append(to).append("\n");
            cnt++;
            return;
        }
        hanoi(rest - 1, start, to, mid);
        sb.append(start).append(" ").append(to).append("\n");
        cnt++;
        hanoi(rest - 1, mid, start, to);
    }
}
