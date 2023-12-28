package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5525 {
    static int N, M, tmpN = 0, cnt = 0;
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();
        for (int i = 1; i < M - 1; ) {
            if(S.charAt(i-1) == 'I' && S.charAt(i) == 'O' && S.charAt(i+1) == 'I'){
                tmpN++;
                if(tmpN == N){
                    tmpN--;
                    cnt++;
                }
                i += 2;
                continue;
            }
            tmpN = 0;
            i++;
        }
        System.out.println(cnt);
    }
}