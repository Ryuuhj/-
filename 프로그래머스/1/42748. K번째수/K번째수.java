import java.util.*;

class Solution {
    static int s, e, k;
    static int[] tmpArr;
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length;i++){
            s = commands[i][0];
            e = commands[i][1];
            k = commands[i][2];
            tmpArr = Arrays.copyOfRange(array, s-1, e);
            Arrays.sort(tmpArr);
            answer[i] = tmpArr[k-1];
        }
        return answer;
    }
}