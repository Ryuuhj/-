import java.util.*;
class Solution {
    static long cnt;
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = (long) times[times.length - 1] * n;
        
        while(left <= right){
            long mid = (left + right) / 2 ;
            cnt = getTotal(times, mid);
            if(cnt >= n){
                answer = mid;
                right = mid - 1;
            }else
                left = mid + 1;
        }
        return answer;
    }
    private static long getTotal(int[] times, long total){
        long cnt = 0;
        for(int time : times){
            cnt += total / (long) time;
        }
        return cnt;
    }
}