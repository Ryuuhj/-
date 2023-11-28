package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504_2 {
    static String input;
    static int ans, val;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        Stack<Character> stack = new Stack<>();
        ans = 0; val = 1;
        for (int i = 0; i < input.length(); i++) {
            char op = input.charAt(i);
            if(op == '('){
                stack.push(op);
                val *= 2;
            } else if (op == '['){
                stack.push(op);
                val *= 3;
            } else if (op == ')') {
                if(stack.isEmpty() || stack.peek() != '('){
                    ans = 0;
                    break;
                }else if(input.charAt(i-1) == '('){
                    ans += val;
                }
                stack.pop();
                val /= 2;
            } else if (op == ']'){
                if(stack.isEmpty() || stack.peek() != '[') {
                    ans = 0;
                    break;
                }
                else if (input.charAt(i-1) == '[') {
                    ans += val;
                }
                stack.pop();
                val /= 3;
            }
        }
        if(!stack.isEmpty()) System.out.println(0);
        else System.out.println(ans);
    }
}
