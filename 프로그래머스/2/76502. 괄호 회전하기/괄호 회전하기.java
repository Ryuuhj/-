import java.util.*;

class Solution {
    static Map<Character, Character> map = new HashMap<>();
    public int solution(String s) {
        int answer = 0;
        map.put(')', '(');  map.put('}', '{');  map.put(']', '[');
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            if(isCorrect(sb.toString()))
                answer++;
        }
        return answer;
    }
    
    private boolean isCorrect(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty())
                    return false;
                if(stack.pop() != map.get(c))
                    return false;
            } else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}