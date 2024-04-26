import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int front = 0, rear = people.length - 1;
        while(front <= rear){
            if(people[front] + people[rear] <= limit)
                front++;
            rear--;
            answer++;
        }
        
        return answer;
    }
}