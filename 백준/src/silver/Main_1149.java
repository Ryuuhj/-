package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1149 {
    static int N;
    static int[][] minCost;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        minCost = new int[N][3];
        int[] color = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        minCost[0][0] = color[0]; minCost[0][1] = color[1]; minCost[0][2] = color[2];
        for (int i = 1; i < N; i++) {
            color = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            minCost[i][0] = Math.min(minCost[i - 1][1], minCost[i - 1][2]) + color[0];
            minCost[i][1] = Math.min(minCost[i - 1][0], minCost[i - 1][2]) + color[1];
            minCost[i][2] = Math.min(minCost[i - 1][0], minCost[i - 1][1]) + color[2];
        }
        System.out.println(Arrays.stream(minCost[N-1]).min().getAsInt());
    }
}
