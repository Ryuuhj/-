import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        for(int i=0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                StringBuilder sb1 = new StringBuilder(s1);
                StringBuilder sb2 = new StringBuilder(s2);
                sb1.append(s2); sb2.append(s1);
                int n1 = Integer.parseInt(sb1.toString());
                int n2 = Integer.parseInt(sb2.toString());
                if(n1 > n2) return -1;
                else if(n1 < n2) return 1;
                return 0;
            }
        });
        if(str[0].equals("0"))
            return "0";
        
        StringBuilder answer = new StringBuilder();
        for(String s : str){
            answer.append(s);
        }
        return answer.toString();
    }
}