import java.util.*;
class Solution {
    static int[][] map = new int[101][101]; //2배
    static boolean[][] visit = new boolean[101][101];
    static int[][] move = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rec : rectangle) {
            fillEdge(rec[0]*2, rec[1]*2, rec[2]*2, rec[3]*2);
        }

        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }

    public int bfs(int cx, int cy, int ix, int iy) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(cx, cy, 0));
        visit[cx][cy] = true;
        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            if(now.x == ix && now.y == iy) {
                return now.distance / 2;
            }
            for (int[] d : move) {
                int nx = now.x + d[0];
                int ny = now.y + d[1];
                if(nx < 0 || nx > 100 || ny < 0 || ny > 100 || map[nx][ny] != 1 || visit[nx][ny]) continue;

                queue.add(new Pos(nx, ny, now.distance + 1));
                visit[nx][ny] = true;
            }
        }
        return -1;
    }

    public void fillEdge(int startX, int startY, int endX, int endY) {
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if(map[i][j] != 2) { //다른 사각형의 내부가 아닌 경우
                    if (i == startX || i == endX || j == startY || j == endY) { //사각형의 변일 경우 1로 표시
                        map[i][j] = 1;
                        continue;
                    }
                }
                map[i][j] = 2; //다른 겹치는 사각형의 모서리 지우기 + 내부는 2로 채움
            }
        }
    }

    class Pos {
        int x; int y; int distance;

        Pos(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}