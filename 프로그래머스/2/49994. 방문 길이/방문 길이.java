import java.util.*;
class Solution {
    public int solution(String dirs) {
        Map<Character, int[]> dir = new HashMap<>(){{
            put('L', new int[]{0, -1});
            put('U', new int[]{-1, 0});
            put('D', new int[]{1, 0});
            put('R', new int[]{0, 1});
        }};
        Set<String> visit = new HashSet<>();
        char[] cmd = dirs.toCharArray();
        int x = 0; int y = 0;

        for(char c : cmd){
            int nx = x + dir.get(c)[0];
            int ny = y + dir.get(c)[1];
            if(nx < -5 || ny < -5 || nx > 5|| ny > 5) continue;
            StringBuilder tmp = new StringBuilder();
            tmp.append(x).append(y).append(nx).append(ny);
            visit.add(tmp.toString());
            //역방향도 고려
            tmp = new StringBuilder();
            tmp.append(nx).append(ny).append(x).append(y);
            visit.add(tmp.toString());
            x = nx; y = ny;
        }
        return visit.size()/2;
    }
}