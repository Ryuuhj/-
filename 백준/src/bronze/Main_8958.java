package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_8958 {
    static int score, accCnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            char[] input = br.readLine().toCharArray();
            score = 0; accCnt = 0;
            for (char c : input) {
                if(c == 'O'){
                    score += ++accCnt;
                }else {
                    accCnt = 0;
                }
            }
            sb.append(score).append("\n");
        }
        System.out.println(sb);
    }
}
