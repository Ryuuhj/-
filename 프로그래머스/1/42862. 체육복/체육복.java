import java.util.*;

class Solution {
    static Set<Integer> clothes = new HashSet<>();
    static Set<Integer> out = new HashSet<>();
    static Set<Integer> tmpOut = new HashSet<>();
    public int solution(int n, int[] lost, int[] reserve) {
        for(int i : lost){
            out.add(i);
            tmpOut.add(i);
        }
        for(int k : reserve){
            if(out.contains(k)){
                out.remove(k);
                tmpOut.remove(k);
            }
            else
                clothes.add(k);
        }
        for(int k : out){
            if(clothes.contains(k-1)) {
                clothes.remove(k - 1);
                tmpOut.remove(k);
            }
            else if(clothes.contains(k+1)){
                clothes.remove(k+1);
                tmpOut.remove(k);
            }
        }
        return n - tmpOut.size();
    }
}