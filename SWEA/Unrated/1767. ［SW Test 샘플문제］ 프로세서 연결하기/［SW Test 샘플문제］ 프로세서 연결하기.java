import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, maxCore, minLine;
    static int[][] map;
    static List<Pos> core;
    static int[][] dm = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void backtracking(int depth, int cCnt, int accLine) {
        if(depth == core.size()) {
            if(maxCore == cCnt) {
                minLine = Math.min(minLine, accLine);
            }else if(maxCore < cCnt) {
                maxCore = cCnt;
                minLine = accLine;
            }
            return;
        }

        int x = core.get(depth).x;
        int y = core.get(depth).y;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x, ny = y;
            int cnt = 0;
            if(isPossible(x, y, dir)){ //전선 연결 가능한 경우
                while (true){
                    nx += dm[dir][0];
                    ny += dm[dir][1];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N)
                        break;
                    map[nx][ny] = 2;
                    cnt++;
                }
                backtracking(depth+1, cCnt+1, accLine + cnt);
                //다시 복구
                nx = core.get(depth).x;
                ny = core.get(depth).y;
                for (int i = 0; i < N; i++) {
                    nx += dm[dir][0];
                    ny += dm[dir][1];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                    map[nx][ny] = 0;
                }
            }else{
                backtracking(depth+1, cCnt, accLine);
            }
        }
    }

    private static boolean isPossible(int x, int y, int dir) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            x += dm[dir][0];
            y += dm[dir][1];
            if(x < 0 || y < 0 || x >= N || y >= N)
                break;
            if(map[x][y] != 0)
                return false;
            cnt++;
        }
        return cnt != 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            core = new ArrayList<>();
            maxCore = 0; minLine = Integer.MAX_VALUE;
            StringTokenizer st;
            //map 저장
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        //전선 연결 가능하지 않은 경우 (벽면에 붙어있는 경우) 제외
                        if (i == 0 || j == 0 || i == N - 1 || j == N - 1) continue;
                        core.add(new Pos(i, j));
                    }
                }
            }

            backtracking(0, 0, 0);

            sb.append(minLine).append("\n");
        }

        System.out.println(sb);
    }

    static class Pos {
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}