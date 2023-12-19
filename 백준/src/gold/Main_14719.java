package gold;

import java.util.Scanner;

public class Main_14719 {
    static int H, W, total;
    static int[] block, leftMax, rightMax;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        block = new int[W];
        total = 0;
        for (int i = 0; i < W; i++) {
            block[i] = sc.nextInt();
        }
        getMax();
        for (int i = 1; i < W - 1; i++) {
            //양 사이드 중 작은 것 - 본인 비교 => 본인이 더 크면 X 더 작으면 작은 것 만큼 +
            int tmp = Math.min(leftMax[i], rightMax[i]);
            if (tmp > block[i]) {
                total += (tmp - block[i]);
            }
        }
        System.out.println(total);
    }

    private static void getMax() {
        leftMax = new int[W];
        leftMax[0] = block[0];
        rightMax = new int[W];
        rightMax[W - 1] = block[W - 1];
        for (int i = 1; i < W; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], block[i-1]);
        }
        for (int i = W - 2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], block[i + 1]);
        }
    }
}
