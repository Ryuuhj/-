package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2229 {
    static int min, max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            min = 10001; max = 0;
            //제일 끝 숫자부터 하나씩 분할된 그룹에 넣어가며 최댓값 갱신함
            for (int j = i; j > 0; j--) {
                min = Math.min(score[j], min);
                max = Math.max(score[j], max);
                dp[i] = Math.max(dp[i], dp[j - 1] + max - min);
                //기존에 존재하는 그룹들의 전체 조 적합도 + i번째 수 포함하는 그룹의 적합도 가 최대인 경우 갱신
            }
        }
        System.out.println(dp[N]);
    }
}
