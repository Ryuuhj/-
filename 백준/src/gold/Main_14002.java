package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N];

        int maxCnt = 0, lastIdx = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > maxCnt) { //LIS의 길이, 마지막 원소 인덱스 구하기용
                maxCnt = dp[i];
                lastIdx = i;
            }
        }
        System.out.println(maxCnt);

        StringBuilder tmp = new StringBuilder();
        tmp.append(A[lastIdx]).append(" ");
        maxCnt--;

        for (int i = lastIdx - 1; i >= 0; i--) {
            if(dp[i] == maxCnt && A[i] < A[lastIdx]){
                tmp.insert(0, A[i] + " ");
                maxCnt--;
            }
        }

        System.out.print(tmp);
    }
}
