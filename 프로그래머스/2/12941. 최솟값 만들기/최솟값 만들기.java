import java.util.*;
class Solution {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int last = B.length - 1;
        for(int i = 0; i <= last; i++){
            answer += A[i] * B[last - i];
        }

        return answer;
    }
}