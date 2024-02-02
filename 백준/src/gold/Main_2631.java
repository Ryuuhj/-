package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2631 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp, 1);

        for (int i = 1; i < N; i++) {
            for (int j = i-1; j >= 0; j--) {
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }
        int LIS = Arrays.stream(dp).max().getAsInt();
        System.out.println(N - LIS); //최장 오름차순에 포함된 번호 빼고 모두 이동해야 함
    }
}
