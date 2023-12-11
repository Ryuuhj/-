import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Process> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            queue.add(new Process(i, priorities[i]));
        }
        while (!queue.isEmpty()) {
            Process p = queue.poll();
            if(pq.peek() == p.priority){
                pq.poll();
                answer++;
                if(p.idx == location) break;
                continue;
            }
            queue.add(p);
        }
        return answer;
    }
    private class Process implements Comparable<Process>{
        int idx;
        int priority;
        public Process(int idx, int pro){
            this.idx = idx;
            this.priority = pro;
        }
        
        @Override
        public int compareTo(Process o){
            return o.priority - this.priority;
        }
    }
}