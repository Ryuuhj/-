import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')'){
                if(stack.isEmpty() || stack.pop() != '('){
                    answer = false;
                    break;
                }
                continue;
            }
            stack.push(c);
        }
        answer = stack.isEmpty() && answer;
        return answer;
    }
}