import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] arr = new String[numbers.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                StringBuilder n1 = new StringBuilder(o1);
                StringBuilder n2 = new StringBuilder(o2);
                n1.append(o2); n2.append(o1);
                if(Integer.parseInt(n1.toString()) > Integer.parseInt(n2.toString())) return -1;
                else if(Integer.parseInt(n1.toString()) < Integer.parseInt(n2.toString())) return 1;
                return 0;
            }
        });
        if(arr[0].equals("0")) return "0";
        for(String n : arr){
            answer.append(n);
        }
        return answer.toString();
    }
}