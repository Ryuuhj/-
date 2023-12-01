import java.util.*;
class Solution {
    static int lMax, rMax;
    public int solution(int[][] sizes) {
        lMax = 0; rMax = 0;
        for(int i=0; i<sizes.length; i++){
            Arrays.sort(sizes[i]);
        }
        for(int i=0; i<sizes.length; i++){
            lMax = Math.max(lMax, sizes[i][0]);
            rMax = Math.max(rMax, sizes[i][1]);
        }
        return lMax * rMax;
    }
}