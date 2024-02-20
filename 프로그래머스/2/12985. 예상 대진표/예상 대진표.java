import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int max = (int) (Math.log(n)/Math.log(2));
        int ans;
        for(ans = 1; ans <= max; ans++){
            if(Math.abs(a-b) == 1 && (a / 2 != b / 2))
                break;
            a = reassign(a);
            b = reassign(b);
        }
        
        return ans;
    }
    private int reassign (int num){
        if(num % 2 == 0)
            return num/2;
        return num/2 + 1;
    }
}