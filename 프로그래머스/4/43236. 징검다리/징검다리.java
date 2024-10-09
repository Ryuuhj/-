import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        
        int left = 1, right = distance, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if(countRemovedRocks(mid, distance, rocks) <= n){
                answer = mid;
                left = mid + 1;
            }else
                right = mid - 1;
        }
        
        return answer;
    }

    private int countRemovedRocks(int mid, int distance, int[] rocks) {
        int p = 0; //처음에 바위가 아닌 시작점 0 부터 시작해야 하므로 p를 인덱스가 아닌 값으로 설정해야 함
        int cnt = 0;

        for (int i = 0; i < rocks.length; i++) {
            if(rocks[i] - p < mid) // 제거
                ++cnt;
            else 
                p = rocks[i];
        }
        if(distance - p < mid) ++cnt;
        
        return cnt;
    }
}