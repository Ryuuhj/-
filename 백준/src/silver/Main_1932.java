package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1932 {
    static int N;
    static int[][] numTri;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numTri = new int[N][N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i + 1; j++) {
                numTri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                numTri[i][j] = Math.max(numTri[i - 1][j - 1], numTri[i - 1][j]) + numTri[i][j];
            }
        }

        System.out.println(Arrays.stream(numTri[N-1]).max().getAsInt());
    }
}
