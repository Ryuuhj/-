import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    final static int INF = Integer.MAX_VALUE;
    static int N, M, u, v, w, X, Y, Z;
    static ArrayList<Edge>[] graph;
    static ArrayList<Edge>[] reGraph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reGraph = new ArrayList[N + 1];
        int[] minDist = new int[N + 1];
        int[] reMinDist = new int[N + 1];
        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
            reGraph[i] = new ArrayList<>();
            minDist[i] = INF;
            reMinDist[i] = INF;
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
            reGraph[v].add(new Edge(u, w));
        }
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken()); Y = Integer.parseInt(st.nextToken()); Z = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        minDist[X] = 0;
        pq.add(new Edge(X, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if(now.cost > minDist[now.idx]) continue;

            for(Edge next : graph[now.idx]){
                if(minDist[next.idx] < now.cost + next.cost) continue;
                minDist[next.idx] = now.cost + next.cost;
                if(next.idx == Y) continue;
                pq.add(new Edge(next.idx, minDist[next.idx]));
            }
        }

        //Z -> X
        pq.clear();
        reMinDist[Z] = 0;
        pq.add(new Edge(Z, 0));
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if(now.cost > reMinDist[now.idx]) continue;

            for(Edge next : reGraph[now.idx]){
                if(reMinDist[next.idx] < now.cost + next.cost) continue;
                reMinDist[next.idx] = now.cost + next.cost;
                if(next.idx == Y) continue;
                pq.add(new Edge(next.idx, reMinDist[next.idx]));
            }
        }

        //1. X-Y-Z

        System.out.print((minDist[Y] == INF || reMinDist[Y] == INF ? -1 : minDist[Y] + reMinDist[Y]) + " ");
        //2. Y 안거치고
        System.out.println(minDist[Z] == INF ? -1 : minDist[Z]);

    }
    static class Edge {
        int idx, cost;
        Edge(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
}
