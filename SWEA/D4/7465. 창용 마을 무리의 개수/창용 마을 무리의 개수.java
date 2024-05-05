import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            Edge[] edges = new Edge[M];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            sb.append(getAnswer(edges)).append("\n");
        }
        System.out.println(sb);
    }

    private static int getAnswer(Edge[] edges) {
        int cnt = 0;
        parent = IntStream.range(0, N + 1).toArray(); // 1 ~ N 까지
        for (int i = 0; i < M; i++) {
            Edge edge = edges[i];
            if(find(edge.from) != find(edge.to))
                union(edge.from, edge.to);
        }
        //그룹 수 카운팅
        for (int i = 1; i <= N; i++) {
            if (parent[i] == i) {
                cnt++;
            }
        }
        return cnt;
    }

    private static int find(int x) {
        if(parent[x] == x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA < rootB)
            parent[rootB] = rootA;
        else
            parent[rootA] = rootB;
    }
    private static class Edge {
        int from;
        int to;

        Edge(int f, int t) {
            this.from = f;
            this.to = t;
        }
    }
}