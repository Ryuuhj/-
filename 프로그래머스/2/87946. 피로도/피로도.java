class Solution {
    static int rpMin = Integer.MAX_VALUE;
    static int dgNum, answer;
    static boolean[] visited;
    static boolean flag = false;
    static int[][] dg;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        dgNum = dungeons.length;
        visited = new boolean[dgNum];
        dg = dungeons.clone();
        for (int i = 0; i < dgNum; i++) {
            rpMin = Math.min(rpMin, dungeons[i][0]);
        }
        explore(k, 0);
        return answer;
    }
    
    private void explore(int now, int visitCnt) {
        if(now < 0 || flag) return;
        if(visitCnt == dgNum){
            answer = visitCnt;
            flag = true;
            return;
        }else if (now < rpMin){
            answer = Math.max(answer, visitCnt);
            return;
        }
        for (int i = 0; i < dgNum; i++) {
            if(!visited[i] && dg[i][0] <= now){
                visited[i] = true;
                explore(now - dg[i][1], visitCnt + 1);
                visited[i] = false;
            }
        }
    }
}