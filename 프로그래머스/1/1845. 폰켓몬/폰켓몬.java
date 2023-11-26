import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            if(set.contains(n)) continue;
            set.add(n);
        }
        if(N/2 >= set.size()) answer = set.size();
        else answer = N/2;
        return answer;
    }
}