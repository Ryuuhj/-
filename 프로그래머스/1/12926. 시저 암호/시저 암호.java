/* 공백은 공백
65 + 3 -> 바로 출력
122 + 1 -> 97 (123 - 26)
*/
import java.util.*;
class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == ' '){
                sb.append(c);
                continue;
            }
            int val = (int)c + n;
            if ((Character.isLowerCase(c) && val > 'z') || Character.isUpperCase(c) && val > 'Z')
                val -= 26;
           
            sb.append((char)val);
        }
        return sb.toString();
    }
}