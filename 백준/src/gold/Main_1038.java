package gold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_1038 {
    static List<Long> numbers = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N < 10) {
            System.out.println(N);
            return;
        } else if (N >= 1023) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < 10; i++) {
            search(1, i);
        }
        Collections.sort(numbers);
        System.out.println(numbers.get(N));
    }

    private static void search(int idx, long acc) {
        if(idx > 10) return;
        numbers.add(acc);
        for (int i = 0; i < acc % 10; i++) {
            search(idx + 1, acc * 10 + i);
        }
    }
}
