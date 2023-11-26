package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504 {
    static int[] operator;
    static char[] input;
    static int tmp, ans;
    //( = 0, ) = -2 , [ = -1, ] = -3
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        operator = new int[input.length];
        for (int i = 0; i < operator.length; i++) {
            switch (input[i]) {
                case '(': operator[i] = 0; break;
                case ')': operator[i] = -2; break;
                case '[': operator[i] = -1; break;
                default: operator[i] = -3; break;
            }
        }
        tmp = 1;
        ans = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(operator[0]);
        for (int i = 1; i < operator.length; i++) {
            int op = operator[i];
            if(op == -1 || op == 0) {
                if(tmp > 1) {
                    stack.push(tmp);
                    tmp = 1;
                }
                stack.push(op);
            }else {
                if(!stack.isEmpty() && stack.peek() > 0){
                    while (stack.peek() > 0){
                        tmp += stack.pop();
                        if(stack.isEmpty()) break;
                    }
                }
                if (stack.isEmpty() || stack.peek() + op == -3) {
                    ans = 0;
                    break;
                } else if (stack.peek() - 2 == op) {
                    stack.pop();
                    tmp *= (-op);
                }
            }
        }
        if((ans == -1 && tmp != 1)){
            ans = tmp;
            while (!stack.isEmpty()){
                if(stack.peek() <= 0){
                    ans = 0; break;
                }
                ans += stack.pop();
            }
        }else ans = 0;
        System.out.println(ans);
    }
}
