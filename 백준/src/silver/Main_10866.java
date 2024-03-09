package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_10866 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(cmd[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(cmd[1]));
                    break;
                case "pop_front":
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst());
                    break;
                case "pop_back":
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast());
                    break;
                case "size":
                    sb.append(deque.size());
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst());
                    break;
                case "back":
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast());
            }
            if(cmd.length == 1)
                sb.append("\n");
        }
        System.out.println(sb);
    }
}
