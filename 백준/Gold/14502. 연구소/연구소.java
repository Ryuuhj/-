import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, maxArea = 0; //세로, 가로
    static List<Pos> space = new ArrayList<>();
    static List<Pos> virus = new ArrayList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    private static class Pos {
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x; int y;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0)
                    space.add(new Pos(i, j));
                else if(map[i][j] == 2)
                    virus.add(new Pos(i, j));
            }
        }
        setWall(map, -1, 0);
        System.out.println(maxArea);
    }

    private static void setWall(int[][] map, int idx, int cnt) {
        if(cnt == 3){
            maxArea = Math.max(maxArea, getMaxArea(map));
            return;
        }
        for (int i = idx + 1; i < space.size(); i++) {
            Pos p = space.get(i);
            map[p.x][p.y] = 1;
            setWall(map, i, cnt + 1);
            map[p.x][p.y] = 0;
        }
    }

    private static int getMaxArea(int[][] map) {
        int[][] tmpMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            tmpMap[i] = map[i].clone();
        }
        //바이러스 퍼뜨리기
        Queue<Pos> queue = new LinkedList<>(virus);
        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || tmpMap[nx][ny] != 0) continue;
                tmpMap[nx][ny] = 2;
                queue.add(new Pos(nx, ny));
            }
        }
        return calSafeZone(tmpMap);
    }

    private static int calSafeZone(int[][] tmpMap) {
        int area = 0;
        for (int i = 0; i < N; i++) {
            for (int n : tmpMap[i]) {
                if(n == 0) area++;
            }
        }
        return area;
    }
}