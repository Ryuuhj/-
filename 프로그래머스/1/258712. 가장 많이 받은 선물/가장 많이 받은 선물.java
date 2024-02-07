import java.util.*;
class Solution {
    static String[] n;
    static Map<String, Integer> idx = new HashMap<>();
    public int solution(String[] friends, String[] gifts) {
        int len = friends.length;
        
        for(int i=0; i < len; i++){
            idx.put(friends[i], i);
        }
        
        int[][] give = new int[len][len];
        int[][] take = new int[len][len];
        
        for(String s : gifts){
            n = s.split(" "); //0(준사람) 1(받은 사람)
            int g = idx.get(n[0]);
            int t = idx.get(n[1]);
            give[g][t]++;
            take[t][g]++;
        }
        int[] nextM = new int[len];
        for(int i = 0; i<len; i++){ //다음 달 선물 카운트
            for(int j = i; j < len; j++){
                if(i == j) continue;
                countP(i, j, give, take, nextM);
            }
        }
        //최대 값
        return Arrays.stream(nextM).max().getAsInt();
    }
    
    private void countP (int a, int b, int[][] give, int[][] take, int[] nextM) {
        //선물 주고 받은 기록 없는 경우 || 주고 받은 수 동일한 경우
        if(give[a][b] - take[a][b] == 0){
            //선물 지수 계산
            int psA = Arrays.stream(give[a]).sum() - Arrays.stream(take[a]).sum();
            int psB = Arrays.stream(give[b]).sum() - Arrays.stream(take[b]).sum();
            if(psA > psB)
                nextM[a]++;
            else if(psA < psB)
                nextM[b]++;
            return;
        }
        //주고 받은 기록 있고 수 다른 경우
        int mg = give[a][b] > give[b][a] ? a : b;
        nextM[mg]++;
        return;
    }
}