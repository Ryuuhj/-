package Level1;

import java.util.ArrayDeque;
import java.util.Deque;

public class 같은숫자는싫어 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        for(int n : solution(arr)){
            System.out.println(n);
        }
    }
    public static int[] solution(int[] arr) {
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
