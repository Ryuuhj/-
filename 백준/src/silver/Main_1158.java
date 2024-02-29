package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder("<");
        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        int cnt = 1;
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        while (queue.size() > 1){
            if(cnt == K){
                sb.append(queue.poll()).append(", ");
                cnt = 1;
                continue;
            }
            queue.add(queue.poll());
            cnt++;
        }
        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}
