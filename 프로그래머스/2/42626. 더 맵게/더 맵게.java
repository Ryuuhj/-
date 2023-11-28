import java.util.*;
class Solution {
    static int answer = 0;
    static int a, b;
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> sv = new PriorityQueue<>();
        for(int n : scoville){
            sv.add(n);
        }
        while(sv.size() >= 2 && sv.peek() < K){
            answer++;
            a = sv.poll();
            b = sv.poll();
            sv.add(a+b*2);
        }
        if(sv.peek() < K){
            answer = -1;
        }
        return answer;
    }
}