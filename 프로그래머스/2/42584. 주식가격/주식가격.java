import java.util.*;
class Solution {
    static int idx;
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<prices.length; i++){
            while(!stack.empty() && (prices[stack.peek()] > prices[i])){
                idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        int lastIdx = prices.length - 1;
        while(!stack.empty()){
            idx = stack.pop();
            answer[idx] = lastIdx - idx;
        }
        return answer;
    }
}