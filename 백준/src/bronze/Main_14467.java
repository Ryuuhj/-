package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14467 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cows = new int[11];
        int crossCount = 0;
        Arrays.fill(cows, -1);
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int side = Integer.parseInt(st.nextToken());
            if(cows[idx] == -1)
                cows[idx] = side;
            else if(cows[idx] != side){
                crossCount++;
                cows[idx] = side;
            }
        }
        System.out.println(crossCount);
    }
}
