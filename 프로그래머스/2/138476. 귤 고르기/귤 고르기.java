import java.util.*;

class Solution {
    final static int length = 10000000;
    public int solution(int k, int[] tangerine) {
        int[] count = new int[length+1];
        PriorityQueue<Tangerine> pq = new PriorityQueue<>();
        
        for(int t : tangerine) count[t]++;
        
        
        for(int i = 1; i <= length; i++){
            if(count[i] > 0)
                pq.add(new Tangerine(i, count[i]));
        }
        
        int answer = 0;
        int sum = 0;
        
        while(sum < k && !pq.isEmpty()){
            sum += pq.poll().cnt;
            answer++;
        }
        
        return answer;
    }
    
    static class Tangerine implements Comparable<Tangerine>{
        int size, cnt;
        
        Tangerine(int s, int c){
            this.size = s;
            this.cnt = c;
        }
        
        @Override
        public int compareTo(Tangerine o){
            return o.cnt - this.cnt;
        }
    }
}