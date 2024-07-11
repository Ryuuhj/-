/*
인덱스를 n으로 나눴을 때 몫, 나머지 중 큰 값 + 1
*/
class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right - left + 1);
        int[] answer = new int[len];
        long tmp = left;
        for(int i = 0; i < answer.length; i++){
            answer[i] = (int) Math.max(tmp / n, tmp%n) + 1;
            ++tmp;
        }
        return answer;
    }
}