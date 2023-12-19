import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] citations) {
        List<Integer> list = Arrays.stream(citations).boxed().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < citations.length; i++) {
            if(list.get(i) < i+1) return i;
        }
        return citations.length;
    }
}