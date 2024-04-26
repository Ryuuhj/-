import java.util.*;

class Solution {
    static String target;
    static int ans = -1;
    static String[] arr = {"A", "E", "I", "O", "U"};
    static boolean flag = false;
    public int solution(String word) {
        target = word;
        search("", 0);
        return ans;
    }
    private void search(String tmp, int length){
        if(flag || length > 5) 
            return;
        ans++;
        if(tmp.equals(target)){
            flag = true;
            return;
        }
        for(int i = 0; i < 5; i++){
            search(tmp+arr[i], length+1);
        }
    }
}