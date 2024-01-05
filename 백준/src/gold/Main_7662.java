package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_7662 {
    static int T, k;
    static String[] cmd;
    static PriorityQueue<Integer> pq, rPq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            k = Integer.parseInt(br.readLine());
            cmd = br.readLine().split(" ");

        }
    }
}
