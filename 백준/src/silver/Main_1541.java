package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split("-");
        int answer = parsing(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            answer -= parsing(nums[i]);
        }
        System.out.println(answer);
    }

    private static int parsing(String str) {
        if (str.contains("+"))
            return Arrays.stream(str.split("\\+")).mapToInt(Integer::parseInt).sum();
        return Integer.parseInt(str);
    }
}
