import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17142 {
    static int N, M, minTime = Integer.MAX_VALUE;
    static int[][] map, time;
    static boolean[][] visited;
    static List<Pos> virus = new ArrayList<>();
    static Stack<Pos> selectedVirus;
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
                if(map[i][j] == 2)
                    virus.add(new Pos(i, j));
            }
        }

        for (int i = 0; i < virus.size(); i++) {
            selectedVirus = new Stack<>();
            selectedVirus.push(virus.get(i));
            selectPos(i + 1, 1);
        }

        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }

    private static void selectPos(int start, int cnt) {
        if(cnt == M){
            spreadVirus();
            return;
        }
        if(start >= virus.size())
            return;

        for (int i = start; i < virus.size(); i++) {
            selectedVirus.push(virus.get(i));
            selectPos(i + 1, cnt + 1);
            selectedVirus.pop();
        }
    }

    private static void spreadVirus() {
        Queue<Pos> queue = new LinkedList<>();
        Stack<Pos> stack = new Stack<>();
        stack.addAll(selectedVirus);
        time = new int[N][N];
        visited = new boolean[N][N];
        int maxTime = 0;
        boolean noEmpty = true;

        while (!stack.isEmpty()){
            Pos tmp = stack.pop();
            visited[tmp.x][tmp.y] = true;
            queue.add(tmp);
        }

        while (!queue.isEmpty()) {
            Pos now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 1 || visited[nx][ny])
                    continue;

                visited[nx][ny] = true;
                time[nx][ny] = time[now.x][now.y] + 1;
                queue.add(new Pos(nx, ny));
            }
        }

        outerloop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0){
                     if(!visited[i][j]) { //빈칸인데 방문하지 않음 -> -1
                         noEmpty = false;
                         break outerloop;
                     } else if(time[i][j] > maxTime)  //빈칸일 경우 최대 시간 갱신
                         maxTime = time[i][j];

                }
            }
        }
        minTime = noEmpty ? Math.min(maxTime, minTime) : minTime;
    }

    private static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
