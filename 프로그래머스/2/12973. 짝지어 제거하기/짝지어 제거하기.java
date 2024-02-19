import java.util.*;
class Solution {
    
    public int solution(String s) {  
       //스택 활용
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.empty() && stack.peek() == c){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.size() == 0 ? 1 : 0;
    }
}