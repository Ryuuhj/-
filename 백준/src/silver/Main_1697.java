package silver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697 {
    static int answer, now, target;
    static int[] time = new int[100001];
    static boolean[] visit = new boolean[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        now = sc.nextInt();
        target = sc.nextInt();
        if(now >= target)
            answer = Math.abs(now - target);
        else {
            chase(now);
            answer = time[target];
        }
        System.out.println(answer);
    }

    private static void chase(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == target) return;
            int cnt = time[now] + 1;
            if(now > 0 && !visit[now-1]){
                time[now - 1] = cnt;
                visit[now - 1] = true;
                queue.add(now - 1);
            }
            if(now < 100000 && !visit[now+1]){
                time[now + 1] = cnt;
                visit[now + 1] = true;
                queue.add(now + 1);
            }
            if(now <= 50000 && !visit[2*now]){
                time[2 * now] = cnt;
                visit[2 * now] = true;
                queue.add(2 * now);
            }
        }
    }
}
