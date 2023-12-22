package silver;

import java.util.*;

public class Main_1389 {
    static int N, M, n1, n2;
    static int[][] kbNum;
    static ArrayList<Integer>[] edges;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        edges = new ArrayList[N + 1];
        kbNum = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        while (M-- > 0) {
            n1 = sc.nextInt(); n2 = sc.nextInt();
            edges[n1].add(n2);
            edges[n2].add(n1);
        }
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }
        int kbMin = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int tmp = Arrays.stream(kbNum[i]).sum();
            if(kbMin > tmp){
                answer = i;
                kbMin = tmp;
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < edges[now].size(); i++) {
                int next = edges[now].get(i);
                if(!visited[next]){
                    queue.add(next);
                    kbNum[start][next] = kbNum[start][now] + 1;
                    visited[next] = true;
                }
            }
        }
    }

}
