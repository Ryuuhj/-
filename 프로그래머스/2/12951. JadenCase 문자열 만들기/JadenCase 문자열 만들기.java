import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, " ", true);
        
        //어차피 공백도 그대로 붙여줘야하므로 단어 구분만 하면 됨
        while(st.hasMoreTokens()){
            String tmp = st.nextToken();
            if(tmp.startsWith(" ")){
                sb.append(tmp);
                continue;
            }
            if(Character.isDigit(tmp.charAt(0)))
                sb.append(tmp.charAt(0));
            else
                sb.append(Character.toUpperCase(tmp.charAt(0)));
            sb.append(tmp.substring(1).toLowerCase());
        }
        return sb.toString();
    }
}