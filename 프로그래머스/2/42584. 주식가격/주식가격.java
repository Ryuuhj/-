import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1; i < N; i++){
            if(stack.empty()){
                stack.push(i);
                continue;
            }
            int idx = stack.peek();
            if(prices[idx] > prices[i]){
                while(!stack.empty() && prices[stack.peek()] > prices[i]){
                    idx = stack.pop();
                    answer[idx] = i - idx;
                }
            }
            stack.push(i);
        }
        N--;
        while(!stack.empty()){
            int idx = stack.pop();
            answer[idx] = N - idx;
        }
        
        return answer;
    }
}