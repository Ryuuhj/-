package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/*
 R(순서 반대로) D(하나 꺼내서 출력) - Deque 사용
 */
public class Main_5430 {
    static int T;
    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String cmd = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();
            if(N == 0) {
                if(!cmd.contains("D")) //DDR인 경우 에러 처리
                    sb.append("[]\n");
                else
                    sb.append("error\n");
                continue;
            }
            setDeque(N, input.substring(1, input.length() - 1).split(","));
            sb.append(execute(cmd)).append("\n");
        }
        System.out.println(sb);
    }

    private static String execute(String cmd) {
        StringBuilder ans = new StringBuilder("[");
        boolean dir = true;
        for (int i = 0; i < cmd.length(); i++) {
            if(cmd.charAt(i) == 'R')
                dir = !dir;
            else {
                if(deque.isEmpty())
                    return "error";
                if(dir)
                    deque.pollFirst();
                else
                    deque.pollLast();
            }
        }
        while (!deque.isEmpty()) {
            if(dir)
                ans.append(deque.pollFirst());
            else ans.append(deque.pollLast());
            if(!deque.isEmpty())
                ans.append(",");
        }
        ans.append("]");
        return ans.toString();
    }

    private static void setDeque(int N, String[] arr) {
        deque = new ArrayDeque<>();
        for (String s : arr) {
            deque.addLast(Integer.parseInt(s));
        }
    }
}