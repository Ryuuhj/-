class Solution {
    public int solution(int n) {
        int answer = 0;
        int nCnt = get1Cnt(n);
        
        while(true){
            int cnt = get1Cnt(++n);
            if(cnt == nCnt){
                answer = n;
                break;
            }
        }
        return answer;
    }
    private int get1Cnt(int n){
        String s = Integer.toBinaryString(n);
        char[] arr = s.toCharArray();
        int cnt = 0;
        for(char c : arr){
            if(c == '1')
                cnt++;
        }
        return cnt;
    }
}