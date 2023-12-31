package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11724 {
    /*
    연결 요소 -> 간선으로 연결된 노드들의 집합 단위
    */
    static int N, M, n1, n2;
    static ArrayList<Integer>[] edge;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edge = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            edge[i] = new ArrayList<>();
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            edge[n1].add(n2);
            edge[n2].add(n1);
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if(!visit[i]){
                queue.add(i);
                answer++;
                visit[i] = true;
                while (!queue.isEmpty()){
                    int now = queue.poll();
                    for(int next : edge[now]){
                        if (!visit[next]) {
                            queue.add(next);
                            visit[next] = true;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
