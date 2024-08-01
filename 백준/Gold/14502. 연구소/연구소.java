import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, maxSafeArea;
    static int[][] map;
    static List<Pos> bsList, virusList;
    static int[][] dm = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        bsList = new ArrayList<>();
        virusList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    bsList.add(new Pos(i, j));
                else if (map[i][j] == 2)
                    virusList.add(new Pos(i, j));
            }
        }

        setWall(0, 0);

        System.out.println(maxSafeArea);

    }

    private static void setWall(int index, int cnt) {
        if (cnt == 3) {
            spreadVirus(); //바이러스 퍼트리기 + 안전 영역 측정
            return;
        }
        if (index == bsList.size())
            return;

        int x = bsList.get(index).x;
        int y = bsList.get(index).y;

        map[x][y] = 1;
        setWall(index + 1, cnt + 1);
        map[x][y] = 0;
        setWall(index + 1, cnt);
    }

    private static int getSafeArea(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    private static void spreadVirus() {
        Queue<Pos> queue = new LinkedList<>(virusList);
        int[][] tmpMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            tmpMap[i] = map[i].clone();
        }

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dm[dir][0];
                int ny = now.y + dm[dir][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || tmpMap[nx][ny] != 0) continue;
                tmpMap[nx][ny] = 2;
                queue.add(new Pos(nx, ny));
            }
        }
        maxSafeArea = Math.max(maxSafeArea, getSafeArea(tmpMap));
   

    }

    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
