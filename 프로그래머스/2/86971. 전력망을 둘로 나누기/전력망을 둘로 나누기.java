import java.util.*;
class Solution {
    static ArrayList<Integer>[] graph;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visit;
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        for (int[] wire : wires) {
            //각 wires 끊는 경우 생각
            visit = new boolean[n + 1];
            answer = Math.min(answer, splitPG(n, wire[0], wire[1]));
        }
        return answer;
    }

    private int splitPG(int n, int n1, int n2) {
        Queue<Integer> queue = new LinkedList<>();
        visit[n1] = true;
        queue.add(n1);
        int cnt = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for(int next : graph[now]){
                if(!visit[next] && next != n2){
                    visit[next] = true;
                    queue.add(next);
                    cnt++;
                }
            }
        }
        return Math.abs(n - (2 * cnt));
    }

}