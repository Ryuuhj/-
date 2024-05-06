import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] arriveTime = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(getAnswer(input[0], input[1], input[2], arriveTime)).append("\n");
        }
        System.out.println(sb);
    }

    private static String getAnswer(int N, int M, int K, int[] arriveTime) {
        Arrays.sort(arriveTime);
        for (int i = 0; i < N; i++) {
            if((arriveTime[i] / M) * K < i + 1)
                return "Impossible";
        }
        return "Possible";
    }
}