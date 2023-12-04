package bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_3460 {
    static int T, n, lsb;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = sc.nextInt();
        while (T-- > 0) {
            n = sc.nextInt();
            lsb = 0;
            while (n != 0){
                if(n % 2 == 1)
                    bw.write(lsb+" ");
                n /= 2;
                lsb++;
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
