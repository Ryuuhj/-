import java.util.*;
//같은 토핑 개수를 할당받도록 자를 수 있는 방법의 수 => 완탐
class Solution {
    static int[] ob = new int[10001];
    static int[] yb = new int[10001];
    static int oCnt = 0, yCnt = 0, answer = 0;
    public int solution(int[] topping) {
        
        for(int t : topping){
            ob[t]++;
            if(ob[t] == 1)
                oCnt++;
        }
        for(int i = 0; i<topping.length; i++){
            int now = topping[i];
            
            if(yb[now] == 0)
                yCnt++;
            yb[now]++;
            ob[now]--;
            
            //형 토핑 갱신
            if(ob[now] == 0)
                oCnt--;
            if(yCnt == oCnt)
                answer++;
        }
        
        return answer;
    }
    
    //재귀함수로 인한 스택 오버플로우 - 런타임에러
//     void distribute(int idx, int[] tp){
//         if(idx >= tp.length)
//             return;
        
//         if(oCnt == yCnt){
//             answer++;
//         }
//         //동생개수, 형 개수 갱신 -> 같은지 검사 후 answer+1
//         if(yb[tp[idx]] == 0)
//             yCnt++;
        
//         yb[tp[idx]]++;
//         ob[tp[idx]]--;
        
//         if(ob[tp[idx]] == 0)
//             oCnt--;
        
//         distribute(idx+1, tp);
//     }
}