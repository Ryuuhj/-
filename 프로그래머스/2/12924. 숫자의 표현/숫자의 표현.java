class Solution {
    public int solution(int n) {
        int answer = 1;
        for(int i = 1; i <= n/2; i++){
            //System.out.println("i>>"+i);
            answer += getCnt(i, 0, n);
        }
        return answer;
    }
    private int getCnt(int now, int acc, int n){
        if(acc == n) {//총 합 == n >> 가능한 경우의 수, 횟수 카운팅
            return 1;
        }
        if(acc > n) //n을 초과하면 불가능한 경우, 종료 및 카운팅 X
            return 0;
        return getCnt(now+1, acc+now, n);
    }
}