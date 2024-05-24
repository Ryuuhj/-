import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static Map<String, Integer> tmp = new HashMap<>();
    static int[] count = new int[10];
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
            
            if(!tmp.containsKey(want[i]))
                tmp.put(want[i], 0);
        }
        
        
        for(int i = 0; i < 10; i++){
           if(tmp.containsKey(discount[i]))
                tmp.replace(discount[i], tmp.get(discount[i]) + 1);
        }
        
        if(map.equals(tmp))
            answer++;
        
        
        int start = 0;
        for(int end = 10; end < discount.length; end++){
            start = end - 10;
            if(tmp.containsKey(discount[start]))
                tmp.replace(discount[start], tmp.get(discount[start]) - 1);
            if(tmp.containsKey(discount[end]))
                tmp.replace(discount[end], tmp.get(discount[end]) + 1);
           
            if(map.equals(tmp))
                answer++;
        }
        
        
        return answer;
    }
}