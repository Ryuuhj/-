import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        if(arr.length == 0) return answer;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(dq.peekLast() != arr[i]) dq.addLast(arr[i]);
        }
        int idx = 0;
        answer = new int[dq.size()];
        while (!dq.isEmpty()) {
            answer[idx] = dq.pollFirst();
            idx++;
        }
        return answer;
    }
}