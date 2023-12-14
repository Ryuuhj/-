import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        //주어진 프로세스 요구시간 기준 오름차순 정렬할 큐
        PriorityQueue<Process> list = new PriorityQueue<>(new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                if (o1.sTime == o2.sTime) return o1.rTime - o2.rTime;
                return o1.sTime - o2.sTime;
            }
        });
        //요구 시간 된 프로세스들 대기시킬 큐(소요 시간 기준 내림차순)
        PriorityQueue<Process> waitQ = new PriorityQueue<>(new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                if (o1.rTime == o2.rTime) return o1.sTime - o2.sTime;
                return o1.rTime - o2.rTime;
            }
        });
        
        for (int i = 0; i < jobs.length; i++) {
            list.add(new Process(jobs[i][0], jobs[i][1]));
        }
        
        int answer = 0;
        
        for (int now = 0; now < Integer.MAX_VALUE; now++) { //시간 자동 흐름
            //현재 시간(now) 에 맞춰 가능한 프로세스가 있다면 대기큐에 넣기
            setWaitQ(list, waitQ, now);
            while (!waitQ.isEmpty()){
                Process p = waitQ.poll();
                now += p.rTime; //프로세스 실행 후 완료 시간으로 갱신
                answer += (now - p.sTime); //종료 - 요청 시간 계산
                setWaitQ(list, waitQ, now); //실행 후 시간 기준으로 다시 프로세스 대기큐에 세팅
            }
            if(list.isEmpty() && waitQ.isEmpty()) break;
        }
        return answer / jobs.length;
    }
    private void setWaitQ(PriorityQueue<Process> list, PriorityQueue<Process> waitQ, int i){
        while (!list.isEmpty() && list.peek().sTime <= i){
                waitQ.add(list.poll());
            }
    }

    private class Process {
        int sTime;
        int rTime;

        public Process(int s, int r) {
            this.sTime = s;
            this.rTime = r;
        }
    }
}