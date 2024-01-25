package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1655 {
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i <= N; i++) {
            num = Integer.parseInt(br.readLine());
            if(left.isEmpty())
                left.add(num);
            else if (right.isEmpty()) {
                right.add(num);
                if (left.peek() > right.peek()) {
                    left.add(right.poll());
                    right.add(left.poll());
                }
            }
            else if (num > right.peek())
                right.add(num);
            else
                left.add(num);
            //총 짝수개면서 균형 안 맞는 경우
            if (i % 2 == 0 && left.size() != right.size()) {
                if (left.size() < right.size())
                    left.add(right.poll());
                else right.add(left.poll());
            }
            //총 홀수개면서 오른쪽에 붙은 경우
            if (i % 2 == 1) {
                while (left.size() <= right.size())
                    left.add(right.poll());
            }
            sb.append(left.peek()).append("\n");
        }
        System.out.print(sb);
    }
}
