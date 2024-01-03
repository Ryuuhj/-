package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11403 {
    static int N;
    static int[][] edge, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        edge = new int[N][N];
        answer = new int[N][N];
        for (int i = 0; i < N; i++) {
            edge[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(edge[i][j] == 1) {
                    answer[i][j] = 1;
                    dfs(i, j);
                }
            }
        }
        for (int[] arr : answer) {
            for(int ans : arr){
                sb.append(ans).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int start, int now) {
        for (int k = 0; k < N; k++) {
            if (edge[now][k] == 1 && answer[start][k] != 1) { //사이클 방지용
                answer[now][k] = 1;
                answer[start][k] = 1;
                dfs(start, k);
            }
        }
    }
}
