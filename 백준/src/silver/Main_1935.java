package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main_1935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();
        Map<Character, Double> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        char k = 'A';
        char[] input = br.readLine().toCharArray();
        while (N-- > 0) {
            map.put(k, Double.parseDouble(br.readLine()));
            k += 1;
        }

        for (char e : input) {
            if(e >= 'A' && e <= 'Z')
                stack.push(map.get(e));
            else{
                double n1 = stack.pop();
                double n2 = stack.pop();
                stack.push(calculate(n1, n2, e));
            }
        }
        System.out.printf("%.2f\n", stack.pop());
    }

    private static Double calculate(double n1, double n2, char op) {
        switch (op) {
            case '+':
                return n1 + n2;
            case '-':
                return n2 - n1;
            case '*':
                return n1 * n2;
            case '/':
                return n2 / n1;
        }
        return n2;
    }
}
