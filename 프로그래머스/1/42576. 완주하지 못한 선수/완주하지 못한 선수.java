import java.util.*;
class Solution {
    static Map<String, Integer> map = new HashMap<>();
    public String solution(String[] participant, String[] completion) {
        for (String name : participant) {
            if(map.containsKey(name)){
                map.replace(name, map.get(name)+1);
            }else{
                map.put(name, 1);
            }
        }
        for(String name : completion){
            if(map.get(name) >= 2){
                map.replace(name, map.get(name)-1);
            }else{
                map.remove(name);
            }
        }
        return map.keySet().iterator().next();
    }
}