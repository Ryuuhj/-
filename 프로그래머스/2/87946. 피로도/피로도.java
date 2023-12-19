class Solution {
    static int dgNum, answer;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        dgNum = dungeons.length;
        visited = new boolean[dgNum];
        explore(k, 0, dungeons);
        return answer;
    }

    private void explore(int now, int visitCnt, int[][] dungeons) {
        for (int i = 0; i < dgNum; i++) {
            if(!visited[i] && dungeons[i][0] <= now){
                visited[i] = true;
                explore(now - dungeons[i][1], visitCnt + 1, dungeons);
                visited[i] = false;
            }
        }
        //가능한 모든 던전에 대한 탐색을 마친 경우, 최댓값 갱신
        answer = Math.max(answer, visitCnt);
    }
}