import java.util.*;
class Solution {
    static int n, m, nx, ny;
    static int[][] move = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int[][] answer;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(answer[i], Integer.MAX_VALUE);
        }
        answer[0][0] = 1;
        bfs(maps);
        return answer[n-1][m-1] == Integer.MAX_VALUE ? -1 : answer[n-1][m-1]; //최소 2칸 필요
    }
    public void bfs(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0] == n-1 && now[1] == m-1) continue;
            for(int[] d : move){
                nx = now[0] + d[0];
                ny = now[1] + d[1];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx][ny] == 0) continue;
                if(answer[now[0]][now[1]] + 1 < answer[nx][ny]){
                    answer[nx][ny] = answer[now[0]][now[1]] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}