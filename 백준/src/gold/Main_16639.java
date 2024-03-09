package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_16639 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] max = new int[N][N];
        int[][] min = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(max[i], Integer.MIN_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }
        char[] in = br.readLine().toCharArray();
        for (int i = 0; i < N; i += 2) {//연산자 건너 뛰기
            //숫자만 max[i][i], min[i][i]에 저장
            max[i][i] = in[i] - '0';
            min[i][i] = in[i] - '0';
        }
        //i~j 까지 합 => 합(i~k) op 합(k+1 ~ j)로 나타냄
        for (int j = 2; j < N; j += 2) {
            for (int i = 0; i < N - j; i += 2) { // j부터 떨어진 정도 (구간 길이)
                for (int k = 2; k <= j; k+=2) { //중간에 분할 기준
                    char op = in[i + k - 1]; //숫자 뒤에 있는 것 기준 연산자
                    int[] tmp = new int[4];
                    tmp[0] = calculate(min[i][i + k - 2], min[i + k][i + j], op);
                    tmp[1] = calculate(max[i][i + k - 2], min[i + k][i + j], op);
                    tmp[2] = calculate(min[i][i + k - 2], max[i + k][i + j], op);
                    tmp[3] = calculate(max[i][i + k - 2], max[i + k][i + j], op);
                    Arrays.sort(tmp);
                    min[i][i + j] = Math.min(min[i][i + j], tmp[0]);
                    max[i][i + j] = Math.max(max[i][i + j], tmp[3]);
                }
            }
        }
        //0 ~ N까지 구간합 최대
        System.out.println(max[0][N - 1]);
    }

    private static int calculate(int n1, int n2, char op) {
        switch (op) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
        }
        return 0;
    }
}
