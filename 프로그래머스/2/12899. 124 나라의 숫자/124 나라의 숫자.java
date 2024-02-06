import java.util.*;
class Solution {
    static int mod;
    public String solution(int n) {
        StringBuilder ans = new StringBuilder();
        String[] number = {"4", "1", "2"};
        
        while(n > 0) {
            mod = n % 3;
            n /= 3;
            if(mod == 0)
                n--;
            
            ans.insert(0, number[mod]); //나머지 뒷자리부터 채워나감
        }
        return ans.toString();
    }
}