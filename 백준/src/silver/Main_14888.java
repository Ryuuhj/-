package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_14888 {
    static int N, min, max;
    static int[] leftCnt, nums;
    // +, -, *, /

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        leftCnt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        min = Integer.MAX_VALUE; max = Integer.MIN_VALUE;
        dfs(1, nums[0]);
        System.out.println(max +"\n" + min);
    }

    private static void dfs(int idx, int acc) {
        if(idx >= N){
            min = Math.min(min, acc);
            max = Math.max(max, acc);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (leftCnt[i] > 0) {
                leftCnt[i]--;
                dfs(idx+1, cal(acc, nums[idx], i));
                leftCnt[i]++;
            }
        }
    }
    private static int cal(int acc, int num, int op) {
        switch (op){
            case 0:
                return acc + num;
            case 1:
                return acc - num;
            case 2:
                return acc * num;
            case 3:
                return acc / num;
        }
        return -1;
    }
}
