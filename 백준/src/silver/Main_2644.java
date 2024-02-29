package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2644 {
    static int N;
    static boolean[][] relationship;
    static int[] nr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        relationship = new boolean[N + 1][N + 1];
        nr = new int[N + 1];
        int M = Integer.parseInt(br.readLine());
        while (M--> 0){
            int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            relationship[p[0]][p[1]] = true;
            relationship[p[1]][p[0]] = true;
        }

        System.out.println(bfs(target[0], target[1]));
    }

    private static int bfs(int t1, int t2) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(t1);
        while (!queue.isEmpty()) {
            int p = queue.poll();
            for (int i = 1; i <= N; i++) {
                if(relationship[p][i]){
                    if(i == t2)
                        return nr[p] + 1;
                    if(nr[i] == 0){
                        nr[i] = nr[p] + 1;
                        queue.add(i);
                    }
                }
            }
        }
        return -1;
    }
}
