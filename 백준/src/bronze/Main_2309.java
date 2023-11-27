package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309 {
    static boolean[] list;
    static int[] dwarf;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dwarf = new int[9];
        list = new boolean[9];
        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
        }
        total = Arrays.stream(dwarf).sum();
        Arrays.sort(dwarf);
        loopo:
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (dwarf[i] + dwarf[j] == (total - 100)) {
                    list[i] = list[j] = true;
                    break loopo;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if(!list[i]) System.out.println(dwarf[i]);
        }
    }

}
