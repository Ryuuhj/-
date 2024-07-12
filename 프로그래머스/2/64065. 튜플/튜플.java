import java.util.*;
import java.util.stream.Collectors;

//길이가 짧은 튜플부터 정렬한 뒤, 앞에서부터 기존에 없는 원소를 추가해줌
class Solution {
    public int[] solution(String s) {
        String[] input = s.substring(1, s.length()-1).split("},");
        
        for(int i = 0; i < input.length; i++){
            input[i] = input[i].replaceAll("\\{|\\}", "");
        }
        
        //길이가 짧은 튜플부터 정렬
        Arrays.sort(input, new Comparator<String>(){
            @Override
            public int compare (String o1, String o2){
                return o1.length() - o2.length();
            }
        });
        
        Set<Integer> elements = new HashSet<>();
        int[] answer = new int[input.length];
        
        for(int i = 0; i<input.length; i++){
            Set<Integer> tmp = Arrays.stream(input[i].split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());
            tmp.removeAll(elements);
            answer[i] = tmp.iterator().next();
            elements.add(answer[i]);
        }

        return answer;
    }
}