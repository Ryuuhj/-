import java.util.*;
class Solution {
    //List-> 일치하는거 remove한 다음 뒤에 넣음
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0){
            return cities.length * 5;
        }
        List<String> cache = new ArrayList<>();
        Set<String> set = new HashSet<>();
        // for(int i = 0; i < cacheSize; i++){
        //     String city = cities[i].toUpperCase();
        //     cache.add(city);
        //     set.add(city);
        // }
        
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toUpperCase();
            if(set.contains(city)){
                cache.remove(city);
                cache.add(city);
                ++answer;
                continue;
            }
            
            answer += 5;
            if(set.size() < cacheSize){
                cache.add(city);
                set.add(city);
                continue;
            }
            set.remove(cache.remove(0));
            cache.add(city);
            set.add(city);
        }
        return answer;
    }
}