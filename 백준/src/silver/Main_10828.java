package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10828 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String[] cmd = br.readLine().split(" ");
            boolean flag = true;
            switch (cmd[0]) {
                case "push":
                    stack.push(Integer.parseInt(cmd[1]));
                    flag = false;
                    break;
                case "pop":
                    if(stack.empty())
                        sb.append(-1);
                    else sb.append(stack.pop());
                    break;
                case "size":
                    sb.append(stack.size());
                    break;
                case "empty":
                    if(stack.empty())
                        sb.append(1);
                    else sb.append(0);
                    break;
                case "top":
                    if(stack.empty())
                        sb.append(-1);
                    else sb.append(stack.peek());
                    break;
            }
            if(flag) sb.append("\n");
        }
        System.out.println(sb);
    }
}
