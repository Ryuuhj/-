import java.util.*;
class Solution {
    static ArrayList<Integer>[] line;
    static int[] maxEdge;
    static boolean[] visited;
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        line = new ArrayList[n+1];
        maxEdge = new int[n+1];
        visited = new boolean[n+1];
        for(int i=1; i <= n; i++){
            line[i] = new ArrayList<>();
        }
        for(int i=0; i < edge.length; i++){
            line[edge[i][0]].add(edge[i][1]);
            line[edge[i][1]].add(edge[i][0]);
        }
        //maxEdge[1] = 0;
        bfs(1);
        int max = Arrays.stream(maxEdge).max().getAsInt();
        for(int cnt : maxEdge){
            if(cnt == max) answer++;
        }
        return answer;
    }
    public static void bfs(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[node] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int next : line[now]){
                if(!visited[next]){
                    queue.add(next);
                    maxEdge[next] = maxEdge[now] + 1;
                    visited[next] = true;
                }
            }
        }
    }
}