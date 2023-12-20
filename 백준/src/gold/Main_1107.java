package gold;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_1107 {
    static int pCnt, len, N, tmp;
    static ArrayList<String> button = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5"
            , "6", "7", "8", "9"));
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        len = (N + "").length();
        int M = sc.nextInt();
        while (M-- > 0) {
            button.remove(sc.nextInt()+"");
        }
        pCnt = Math.abs(N - 100);
        searchMin("", 0);
        System.out.println(pCnt);
    }

    private static void searchMin(String s, int length) {
        if (length >= 1) {
            tmp = Math.abs(N - Integer.parseInt(s)) + length;
            pCnt = Math.min(pCnt, tmp);
            if(length - 1 == len) return;
        }
        for (int i = 0; i < button.size(); i++) {
            searchMin(s + button.get(i), length + 1);
        }
    }
}
