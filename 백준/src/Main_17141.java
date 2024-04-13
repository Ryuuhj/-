import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17141 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int minTime = Integer.MAX_VALUE, empty;
    static List<Pos> existVirus = new ArrayList<>();
    static Stack<Pos> selectedVirus = new Stack<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) //바이러스 위치 리스트에 추가
                    existVirus.add(new Pos(i, j, 0));
                else if(map[i][j] == 0)
                    empty++;
            }
        }
        empty += existVirus.size();////선택되지 않은 바이러스 자리는 빈칸 취급 하므로 바이러스 개수까지 포함해서 카운팅 해 줘야 함!

        for (int i = 0; i < existVirus.size(); i++) {
            selectedVirus = new Stack<>();
            selectedVirus.push(existVirus.get(i));
            selectVirus(i + 1, 1);
        }

        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }

    private static void selectVirus(int start, int cnt) {
        if (cnt == M) { //모두 선택한 경우 시뮬레이션 시작
            spreadVirus();
            return;
        }
        if(start >= existVirus.size())
            return;
        for (int i = start; i < existVirus.size(); i++) {
            selectedVirus.push(existVirus.get(i));
            selectVirus(i + 1, cnt + 1);
            selectedVirus.pop();
        }
    }

    private static void spreadVirus() {
        //bfs + selectVirusSET 활용해 시뮬레이션
        Queue<Pos> queue = new LinkedList<>(selectedVirus);
        Stack<Pos> tmp = new Stack<>();
        tmp.addAll(selectedVirus);
        visited = new boolean[N][N];
        int cnt = selectedVirus.size();
        int maxTime = 0;
        while (!tmp.isEmpty()) {
            Pos pos = tmp.pop();
            visited[pos.x][pos.y] = true;
            queue.add(pos);
        }

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            maxTime = Math.max(maxTime, now.time);

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] == 1)
                    continue;
                visited[nx][ny] = true;
                cnt++;
                queue.add(new Pos(nx, ny, now.time + 1));
            }
        }
        //빈칸 모두 채웠을 경우에만 시간 갱신
        minTime = empty == cnt ? Math.min(minTime, maxTime) : minTime;
    }


    private static class Pos {
        int x;
        int y;
        int time;

        Pos(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.time = t;
        }
    }

}

