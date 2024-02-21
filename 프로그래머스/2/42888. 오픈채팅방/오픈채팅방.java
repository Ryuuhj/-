import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String[]> elList = new ArrayList<>();
        for(String r : record){
            String[] tmp = r.split(" ");
            if(tmp[0].equals("Enter")){
                map.put(tmp[1], tmp[2]);
                elList.add(tmp);
            }else if(tmp[0].equals("Leave")){
                elList.add(tmp);
            }else{
                map.put(tmp[1], tmp[2]);
            }
        }
        
        String[] answer = new String[elList.size()];
        for(int i = 0; i < elList.size(); i++){
            String[] rc = elList.get(i);
            StringBuilder sb = new StringBuilder(map.get(rc[1]));
            if(rc[0].equals("Enter"))
                sb.append("님이 들어왔습니다.");
            else if(rc[0].equals("Leave"))
                sb.append("님이 나갔습니다.");
            answer[i] = sb.toString();
        }
        return answer;
    }
}