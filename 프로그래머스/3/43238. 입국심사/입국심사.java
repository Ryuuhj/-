import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long front = 0, rear = (long) (times[times.length-1]) * n; //소요 시간 기준 - 0초 ~ 최대 시간
        
        while(front <= rear){
            long mid = (front + rear) / 2;
            long cnt = getCnt(times, mid);
            if(n <= cnt){
                answer = mid;
                rear = mid - 1;
            } else {
                front = mid + 1;
            }
        }
        
        return answer;
    }
    private long getCnt(int[] times, long total){
        long cnt = 0;
        for(int t : times){
            cnt += (long) total/t;
        }
        return cnt;
    }
}