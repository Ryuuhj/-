package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11404 {
    final static int INF = Integer.MAX_VALUE;
    static int start, end, cost;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] edge = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(edge[i], INF);
            edge[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            edge[start][end] = Math.min(edge[start][end], cost); //최소비용 갱신
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(edge[i][k] != INF && edge[k][j] != INF)
                        edge[i][j] = Math.min(edge[i][k] + edge[k][j], edge[i][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (edge[i][j] == INF)
                    sb.append(0).append(" ");
                else
                    sb.append(edge[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
