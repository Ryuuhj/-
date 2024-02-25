package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1303 {
    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int tmpCnt, N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] field = new char[M][N];
        for (int i = 0; i < M; i++) {
            field[i] = br.readLine().toCharArray();
        }
        boolean[][] visited = new boolean[M][N];
        int wScore = 0, bScore = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    tmpCnt = 0;
                    dfs(i, j, visited, field);
                    tmpCnt *= tmpCnt;
                    if(field[i][j] == 'W')
                        wScore += tmpCnt;
                    else
                        bScore += tmpCnt;
                }
            }
        }
        System.out.printf("%d %d", wScore, bScore);
    }

    private static void dfs(int i, int j, boolean[][] visited, char[][] field) {
        visited[i][j] = true;
        tmpCnt++;

        for (int k = 0; k < 4; k++) {
            int nx = i + move[k][0];
            int ny = j + move[k][1];
            if(nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny] && field[i][j] == field[nx][ny])
                dfs(nx, ny, visited, field);
        }
    }

}
