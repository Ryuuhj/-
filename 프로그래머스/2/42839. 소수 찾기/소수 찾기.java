import java.util.*;

class Solution {
    boolean[] isPrime = new boolean[10000001];
    boolean[] used;
    Set<Integer> set = new HashSet<>();
    int length, max = 0;
    char[] nums;
    
    public int solution(String numbers) {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i=2; i <=Math.sqrt(10000000);i++){
            if(isPrime[i]){
                for(int j=i*2; j<10000001; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        length = numbers.length();
        
        nums = numbers.toCharArray();
        used = new boolean[length];
        
        for(int i = 1; i <= length; i++){
            max = i;
            getCnt(0, new StringBuilder());
        }
        return set.size();
    }
    private void getCnt(int len, StringBuilder sb){
        if(max == len){
            int tmp = Integer.parseInt(sb.toString());
            if(isPrime[tmp]) 
                set.add(tmp);
            return;
        }
        for(int i=0; i<length; i++){
            if(!used[i]){
                used[i] = true;
                sb.append(nums[i]);
                getCnt(len+1, sb);
                sb.deleteCharAt(len);
                used[i] = false;
            }
        }
    }
}