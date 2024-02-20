import java.util.*;
class Solution {
    public int solution(int[] arr) {
        return getLcm(arr);
    }
    private int getLcm (int[] arr){
        //수가 1개인 경우 리턴
        if(arr.length == 1) 
            return arr[0];
        //2개의 수 최소 공배수 먼저 구하기
        int gcd = getGCD(arr[0], arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;
        for(int i = 2; i< arr.length; i++){
            gcd = getGCD(lcm, arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }
        return lcm;
    }
    private int getGCD (int a, int b){
        if(a % b == 0)
            return b;
        return getGCD(b, a % b);
    }
}