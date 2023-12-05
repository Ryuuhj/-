import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int front = 0, back = people.length-1;
        while(front <= back){
            if(front == back){
                answer++; break;
            }
            if(people[front] + people[back] <= limit)
                front++;
            back--; answer++;
        }
        return answer;
    }
}