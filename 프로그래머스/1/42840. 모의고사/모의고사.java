import java.util.*;

class Solution {
    static int[] num1 = {1, 2, 3, 4, 5};
    static int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    public int[] solution(int[] answers) {
        int[] corCnt = {0, 0, 0};
        for(int i=0;i < answers.length; i++){
            if(num1[i%5] == answers[i]) corCnt[0]++;
            if(num2[i%8] == answers[i]) corCnt[1]++;
            if(num3[i%10]== answers[i]) corCnt[2]++;
        }
        int max = Arrays.stream(corCnt).max().getAsInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i < corCnt.length; i++){
            if(corCnt[i] == max) arr.add(i+1);
        }
        
        return arr.stream().mapToInt(i -> i).toArray();
    }
}