package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1916 {
    //다익스트라
    final static int INF = 1000000001;
    static StringTokenizer st;
    static int N, M;
    static int[] minCost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        minCost = new int[N + 1];
        Arrays.fill(minCost, INF);
        //비용 할당
        int[][] edges = new int[N + 1][N + 1];
        int s, e, cost;
        for (int i = 1; i <= N; i++) {
            Arrays.fill(edges[i], INF);
            edges[i][i] = 0;
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            edges[s][e] = Math.min(edges[s][e], cost);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(search(edges, start, end));
    }

    private static int search(int[][] edges, int start, int end) {
        PriorityQueue<City> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        minCost[start] = 0;
        queue.add(new City(start, 0));

        while (!queue.isEmpty()) {
            City now = queue.poll();
            int startIdx = now.end;
            if(visited[startIdx]) continue;
            visited[startIdx] = true;

            for (int i = 1; i <= N; i++) {
                if(i == startIdx) continue;
                if (edges[startIdx][i] != INF && minCost[i] > minCost[startIdx] + edges[startIdx][i]) {
                    minCost[i] = minCost[startIdx] + edges[startIdx][i];
                    queue.add(new City(i, minCost[i]));
                }
            }
        }

        return minCost[end];

    }
    static class City implements Comparable<City>{
        int end;
        int cost;

        City(int e, int c) {
            this.end = e;
            this.cost = c;
        }

        @Override
        public int compareTo(City city) {
            return this.cost > city.cost ? 1 : -1;
        }
    }
}
