import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Process> list = new PriorityQueue<>(new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                if (o1.sTime == o2.sTime) return o1.rTime - o2.rTime;
                return o1.sTime - o2.sTime;
            }
        });
        PriorityQueue<Process> waitQ = new PriorityQueue<>(new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                if (o1.rTime == o2.rTime) return o1.sTime - o2.sTime;
                return o1.rTime - o2.rTime;
            }
        });
        for (int i = 0; i < jobs.length; i++) {
            list.add(new Process(i, jobs[i][0], jobs[i][1]));
        }
        int now = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            while (!list.isEmpty() && list.peek().sTime <= i){
                waitQ.add(list.poll());
            }
            while (!waitQ.isEmpty() && waitQ.peek().sTime <= i){
                Process p = waitQ.poll();
                i += p.rTime;
                answer += (i - p.sTime);
                while (!list.isEmpty() && list.peek().sTime <= i){
                    waitQ.add(list.poll());
                }
            }
            if(list.isEmpty() && waitQ.isEmpty()) break;
        }
        return answer / jobs.length;
    }

    private class Process {
        int idx;
        int sTime;
        int rTime;

        public Process(int i, int s, int r) {
            this.idx = i;
            this.sTime = s;
            this.rTime = r;
        }
    }
}