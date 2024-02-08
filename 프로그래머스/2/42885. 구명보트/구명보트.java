import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int front = 0; int rear = people.length-1;
        Arrays.sort(people);
        while(front <= rear){
            answer++;
            
            if(front == rear)
                break;
        
            if(people[front] + people[rear] <= limit)
                front++;  
            rear--;
        }
        return answer;
    }
}