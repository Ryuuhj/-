package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460 {
    static int[][] move = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    static char[][] map;
    static int N, M;
    static Pos hole;
    static boolean[][][][] visited;
    //blue의 위치도 고려(red 냅두고 blue만 위치 조정 해야하는 경우 대비)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        Pos blue = null, red = null;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'R')
                    red = new Pos(i, j);
                else if(map[i][j] == 'B')
                    blue = new Pos(i, j);
                else if(map[i][j] == 'O')
                    hole = new Pos(i, j);
            }
        }
        int ans = bfs(red, blue, 0);
        System.out.println(ans);
    }

    private static int bfs(Pos startRed, Pos startBlue, int cnt) {
        Queue<Beads> queue = new LinkedList<>();
        visited = new boolean[N][M][N][M];
        visited[startRed.x][startRed.y][startBlue.x][startBlue.y] = true;
        queue.add(new Beads(startRed, startBlue, cnt));
        int minCnt = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Beads now = queue.poll();
            int curRx = now.red.x;
            int curRy = now.red.y;
            int curBx = now.blue.x;
            int curBy = now.blue.y;

            if(now.cnt >= 10)
                continue;

            for (int i = 0; i < 4; i++) {
                boolean redHole = false, blueHole = false;

                int nextRx = curRx;
                int nextRy = curRy;
                int nextBx = curBx;
                int nextBy = curBy;

                while (map[nextRx + move[i][0]][nextRy + move[i][1]] != '#') {
                    nextRx += move[i][0];
                    nextRy += move[i][1];

                    if(map[nextRx][nextRy] == 'O'){
                        redHole = true;
                        break;
                    }
                }
                while (map[nextBx + move[i][0]][nextBy + move[i][1]] != '#') {
                    nextBx += move[i][0];
                    nextBy += move[i][1];
                    if(map[nextBx][nextBy] == 'O'){
                        blueHole = true;
                        break;
                    }
                }

                if(blueHole) //파란 구슬 통과한 경우는 답에서 제외
                    continue;
                else if(redHole) {//정답
                    minCnt = Math.min(minCnt, now.cnt + 1);
                    continue;
                }
                //자리 겹치는 경우
                if (nextRx == nextBx && nextRy == nextBy) {
                    switch (i) {
                        case 0:
                            if(curRy < curBy)
                                nextRy -= move[i][1];
                            else
                                nextBy -= move[i][1];
                            break;
                        case 1:
                            if(curRx > curBx)
                                nextRx -= move[i][0];
                            else
                                nextBx -= move[i][0];
                            break;
                        case 2:
                            if (curRy > curBy)
                                nextRy -= move[i][1];
                            else
                                nextBy -= move[i][1];
                            break;
                        case 3:
                            if (curRx < curBx)
                                nextRx -= move[i][0];
                            else
                                nextBx -= move[i][0];
                            break;
                    }
                }
                //전에 방문한 적 없는 자리일 경우만 큐에 삽입
                if (!visited[nextRx][nextRy][nextBx][nextBy]) {
                    visited[nextRx][nextRy][nextBx][nextBy] = true;
                    queue.add(new Beads(new Pos(nextRx, nextRy), new Pos(nextBx, nextBy), now.cnt + 1));
                }
            }
        }
        return minCnt == Integer.MAX_VALUE ? -1 : minCnt;
    }

    private static class Beads{
        Pos red, blue;
        int cnt;

        Beads(Pos red, Pos blue, int cnt) {
            this.red = red;
            this.blue = blue;
            this.cnt = cnt;
        }
    }
    private static class Pos{
        int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
