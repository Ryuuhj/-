import java.util.*;
class Solution {
   
    public int solution(int N, int number) {
        int answer = -1;
        Set<Integer>[] dp = new Set[9];
        int tmp = N;
        for (int i = 1; i < 9; i++) {
            dp[i] = new HashSet<>();
            if(tmp == number){
                answer = i;
                break;
            }
            dp[i].add(tmp);
            tmp = tmp * 10 + N;
        }
        if(answer == -1) {
            for (int i = 2; i < 9; i++) {
                if (getUseCnt(i, number, dp)) {
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }

    private boolean getUseCnt(int num, int number, Set<Integer>[] dp) {
        for (int n1 = 1; n1 < num ; n1++) {
            int n2 = num - n1;
            if(n1 == n2) {
                for (int i : dp[n1]) {
                    for (int j : dp[n2]) {
                        dp[num].add(i + j);
                        dp[num].add(i * j);
                        dp[num].add(i - j);
                        if(j != 0)
                            dp[num].add(i / j);
                        if(dp[num].contains(number)) return true;
                    }
                }
            }else {
                for (int i : dp[n1]) {
                    for (int j : dp[n2]) {
                        dp[num].add(i + j);
                        dp[num].add(i * j);
                        dp[num].add(i - j);
                        dp[num].add(j - i);
                        if(j != 0)
                            dp[num].add(i / j);
                        if(i != 0)
                            dp[num].add(j / i);
                        if(dp[num].contains(number)) return true;
                    }
                }
            }
        }
        return false;
    }
}