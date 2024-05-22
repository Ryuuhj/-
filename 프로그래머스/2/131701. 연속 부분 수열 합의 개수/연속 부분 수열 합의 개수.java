import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static int N;
    static Set<Integer> set;
    public int solution(int[] elements) {
        N = elements.length;
        set = Arrays.stream(elements).boxed().collect(Collectors.toSet());
        for(int i = 2; i <= N; i++){
            getCnt(i, elements);
        }
        return set.size();
    }
    private static void getCnt(int cnt, int[] elements){
        for(int i = 0; i < N; i++){
            int sum = 0;
            for(int j = 0; j < cnt; j++){
                sum += elements[(i+j)%N];
            }
            set.add(sum);
        }
    }
    
}