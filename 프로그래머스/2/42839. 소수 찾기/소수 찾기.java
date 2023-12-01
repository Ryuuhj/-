import java.util.*;

class Solution {
    static boolean[] used, isPrime;
    static Set<Integer> caseNum = new HashSet<>();
    static int len, n;
    static char[] number;
    
    public int solution(String numbers) {
        getPrime(10000000);
        used = new boolean[numbers.length()];
        number = numbers.toCharArray();
        for(int i=1; i <=number.length; i++){
            len = i;
            getNum("");
        }
        return caseNum.size();
    }
    private void getNum(String now){
        if(now.length() == len){
            n = Integer.parseInt(now);
            if(isPrime[n]) caseNum.add(n);
            return;
        }
        for(int i=0; i < number.length; i++){
            if(!used[i]){
                used[i] = true;
                getNum(now+number[i]);
                used[i] = false;
            }
        }
    }
    
    private void getPrime(int max){
        isPrime = new boolean[max];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(max-1); i++) {
            if(isPrime[i]) {
                for (int j = i * 2; j <= max-1; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}