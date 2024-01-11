package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1753 {
    //시작점에서 다른 모든정점으로 최단 경로를 구하는 프로그램 (각 노드까지의 최단 거리 한 줄에 하나씩 출력)
    //u - w -> v
    static int V, E, u, v, w;
    static ArrayList<Edge>[] graph;
    static int[] answer;

    private static class Edge implements Comparable<Edge> {
        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.weight > o.weight) return 1;
            return -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V + 1];
        answer = new int[V + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }
        dijkstra (start);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if(answer[i] == Integer.MAX_VALUE)
                sb.append("INF\n");
            else
                sb.append(answer[i]+"\n");
        }
        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        answer[start] = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if(now.weight > answer[now.node]) continue; //최소 안되면 탐색 금지

            for (Edge next : graph[now.node]) {
                if(answer[next.node] > now.weight + next.weight) {//최솟값이면 갱신
                    answer[next.node] = now.weight + next.weight;
                    pq.add(new Edge(next.node, answer[next.node]));
                }
            }
        }
    }
}
