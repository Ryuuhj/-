import java.util.*;
class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] num = {4, 1, 2}; // 0=4, 1=1, 2=2로 변경
        while(n > 0){
            int mod = n % 3;
            n = n / 3;
            if(mod == 0)
                n-= 1;
            sb.insert(0, num[mod]);
        }
        
        return sb.toString();
    }
}