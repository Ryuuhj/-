import java.util.*;
class Solution {
    //카테고리 이름도 달라짐
    //독립사건은 걍 곱함
    //한 카테고리 아이템이 2개인 경우 0, 1, 2 -> 3가지 경우 존재
    //예제의 2 , 1 의 경우 -> 3*2 -1 = 5가지
    //3의 경우 4 - 1 = 3
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(String[] c : clothes){
            if(map.containsKey(c[1])){
                map.put(c[1], map.get(c[1])+1);
                continue;
            }
            map.put(c[1], 2); //안 입는 경우 +1한 값
        }
        for(int cnt : map.values()){
            answer *= cnt;
        }
        return answer-1;
    }
}