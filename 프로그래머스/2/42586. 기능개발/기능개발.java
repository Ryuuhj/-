import java.util.*;
class Solution {
    // 5 10 1 1 20 1 -> 달성하는데 걸리는 날짜 계산
    //List를 순회하며 front >= back인 경우 스택에 넣음 / front < back인 경우 스택 size를 출력, clear한 뒤 다시 시작
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] compDay = new int[speeds.length];
        for(int i = 0; i <speeds.length; i++){
            compDay[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);

        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(compDay[0]);
        for (int i = 1; i < speeds.length; i++) {
            if(!deque.isEmpty() && deque.peekFirst() < compDay[i]){
                answer.add(deque.size());
                deque.clear();
                deque.addLast(compDay[i]);
                continue;
            }
            deque.addLast(compDay[i]);
        }
        if(!deque.isEmpty()) answer.add(deque.size());
        return answer.stream().mapToInt(i -> i).toArray();
    }
}