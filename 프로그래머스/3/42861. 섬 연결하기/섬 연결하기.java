import java.util.*;
class Solution {
    static ArrayList<Bridge>[] edges;
    static boolean[] visit;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        edges = new ArrayList[n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] cost : costs) {
            edges[cost[0]].add(new Bridge(cost[1], cost[2]));
            edges[cost[1]].add(new Bridge(cost[0], cost[2]));
        }
        answer = bfs(0);
        return answer;
    }

    private int bfs(int start) {
        PriorityQueue<Bridge> queue = new PriorityQueue<>();
        queue.add(new Bridge(start, 0));
        int cost = 0;
        while (!queue.isEmpty()) {
            Bridge now = queue.poll();
            if(!visit[now.node]) {
                visit[now.node] = true;
                cost += now.cost;
                for (Bridge next : edges[now.node]) {
                    if (!visit[next.node]) {
                        queue.add(next);
                    }
                }
            }
        }
        return cost;
    }

    private static class Bridge implements Comparable<Bridge> {
        int node; int cost;

        Bridge(int n, int cost) {
            this.node = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bridge o) {
            if(this.cost < o.cost) return -1;
            else if(this.cost > o.cost) return 1;
            return 0;
        }
    }
}