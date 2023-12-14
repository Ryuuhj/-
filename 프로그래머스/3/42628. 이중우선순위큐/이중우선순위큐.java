import java.util.*;
class Solution {
    static PriorityQueue<Integer> minQ = new PriorityQueue<>();
    static PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        for (String cmd : operations) {
            calculate(cmd);
        }
        if (!minQ.isEmpty() && !maxQ.isEmpty()) {
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }
        return answer;
    }

    private void calculate(String cmd) {
        switch (cmd) {
            case "D 1":
                if(!maxQ.isEmpty()) 
                    minQ.remove(maxQ.poll());
                break;
            case "D -1":
                if(!minQ.isEmpty())
                    maxQ.remove(minQ.poll());
                break;
            default:
                int tmp = Integer.parseInt(cmd.substring(2));
                maxQ.offer(tmp);
                minQ.offer(tmp);
        }
    }
}