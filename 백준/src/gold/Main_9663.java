package gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main_9663 {
    static int N, answer = 0;
    static int[] col;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N];
        Arrays.fill(col, -1);

        for (int i = 0; i < N; i++) {
            col[i] = 0;
            putQueen(0);
            col[i] = -1;
        }
        System.out.println(answer);
    }

    private static void putQueen(int r) {
        if(r == N-1){
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if(col[i] != -1) continue;
            if (isDiagonal(r + 1, i)) continue;
            col[i] = r + 1;
            putQueen(r + 1);
            col[i] = -1;
        }
    }

    private static boolean isDiagonal(int r, int c) {
        for (int i = 0; i < N; i++) {
            if(col[i] != -1){
                if(col[i]+i == r+c) return true;
                if(col[i] - i == r-c) return true;
            }
        }
        return false;
    }
}
