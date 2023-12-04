import java.util.*;

class Solution {
    static int vertical = 0, horizon = 0;
    //특정 X까지 정방향으로 갔다가 -> 다시 거슬러서 0으로 돌아온 후 역으로 끝 A까지 가는 것
    //0에서 A 끝까지 역으로 먼저 간 후 -> 다시 X까지 정방향으로 가는 것 비교

    public static int solution(String name) {
        horizon = name.length() - 1;
        int endIdx = 0;
        for(int i = 0; i < name.length(); i++){
            vertical += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') { //A 시작하는 경우
                endIdx = i+1;
                while (endIdx < name.length() && name.charAt(endIdx) =='A') {
                    endIdx++;
                }
                //1번 선 정방향
                horizon = Math.min(horizon, i * 2 + (name.length() - endIdx));
                //2번 선 역방향
                horizon = Math.min(horizon, (name.length() - endIdx) * 2 + i);
            }
        }

        return vertical + horizon;
    }
}