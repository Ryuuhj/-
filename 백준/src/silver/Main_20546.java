package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_20546 {
    static int[] base;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cash = Integer.parseInt(br.readLine());
        int[] jusik = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        base = new int[2];
        Arrays.fill(base, cash);

        int bnp = getBNP(jusik);
        int timing = getTIMING(jusik);
        if(bnp > timing)
            System.out.println("BNP");
        else if (bnp < timing)
            System.out.println("TIMING");
        else
            System.out.println("SAMESAME");
    }

    private static int getBNP(int[] jusik) {
        int jCnt = 0;
        for (int i = 0; i < jusik.length; i++) {
            if(base[0] >= jusik[i]){
                jCnt += base[0] / jusik[i];
                base[0] %= jusik[i];
            }
        }
        return base[0] + (jCnt * jusik[13]);
    }

    private static int getTIMING(int[] jusik) {
        int jCnt = 0;
        int up = 0, down = 0;
        for (int i = 1; i < jusik.length; i++) {
            if(jusik[i-1] < jusik[i]){
                if(up == 0)
                    down = 0;
                up++;
            }
            if(jusik[i-1] > jusik[i]){
                if(down == 0)
                    up = 0;
                down++;
            }
            if(up >= 3){
                base[1] += jCnt * jusik[i];
                jCnt = 0;
            } else if (down >= 3) {
                jCnt += base[1] / jusik[i];
                base[1] %= jusik[i];
            }
        }
        return base[1] + (jCnt * jusik[13]);
    }
}
