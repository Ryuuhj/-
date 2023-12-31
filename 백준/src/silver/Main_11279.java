package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_11279 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            calculate(Integer.parseInt(br.readLine()), sb);
        }
        System.out.print(sb);
    }

    private static void calculate(int x, StringBuilder answer) {
        switch (x) {
            case 0:
                if(pq.isEmpty())
                    answer.append(0).append("\n");
                else
                    answer.append(pq.poll()).append("\n");
                break;
            default:
                pq.add(x);
        }
    }
}
