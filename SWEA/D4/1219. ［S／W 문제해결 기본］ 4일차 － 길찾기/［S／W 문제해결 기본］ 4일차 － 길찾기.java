import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N;
    static int[][] edges;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 10;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append("#").append(st.nextToken()).append(" ");
            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            setEdges(st);
            sb.append(getAnswer()).append("\n");
        }
        System.out.println(sb);
    }

    private static void setEdges(StringTokenizer st) {
        edges = new int[100][2];
        for (int i = 0; i < N; i++) {
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if(edges[from][0] != 0)
                edges[from][1] = to;
            else
                edges[from][0] = to;
        }
    }

    private static int getAnswer() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[100]; //중복 방문 가능
        visited[0] = true;
        queue.add(0);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < 2; i++) {
                int next = edges[now][i];
                if (next != 0 && !visited[next]) {
                    if(next == 99)
                        return 1;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }
}