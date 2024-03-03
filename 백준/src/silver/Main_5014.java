package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_5014 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt(), S = sc.nextInt(), G = sc.nextInt(),
                U = sc.nextInt(), D = sc.nextInt();
        if(S == G){
            System.out.println(0);
            return;
        }
        int answer = bfs(S, G, F, U, D);
        if(answer < 0)
            System.out.println("use the stairs");
        else
            System.out.println(answer);
    }

    private static int bfs(int start, int goal, int f, int up, int down) {
        Queue<Integer> queue = new LinkedList<>();
        int[] minCnt = new int[f + 1];
        boolean[] visited = new boolean[f + 1];
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            int nextUp = now + up;
            if (nextUp <= f && !visited[nextUp]) {
                minCnt[nextUp] = minCnt[now] + 1;
                if(nextUp == goal)
                    return minCnt[nextUp];
                queue.add(nextUp);
                visited[nextUp] = true;
            }
            int nextDown = now - down;
            if(nextDown > 0 && !visited[nextDown]){
                minCnt[nextDown] = minCnt[now] + 1;
                if(nextDown == goal)
                    return minCnt[nextDown];
                queue.add(nextDown);
                visited[nextDown] = true;
            }
        }
        return -1;
    }
}
