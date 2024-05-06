package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_20436 {
    static Map<Character, Pos> lefts, rights;
    static int totalTime = 0, distance;
    static Pos sL, sR;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //키보드 초기 조건 세팅
        setKeyboard();
        //왼쪽, 오른쪽 시작 위치
        char l = st.nextToken().charAt(0);
        char r = st.nextToken().charAt(0);
        sL = lefts.containsKey(l) ? lefts.get(l) : rights.get(l);
        sR = rights.containsKey(r) ? rights.get(r) : lefts.get(r);

        String input = br.readLine(); //출력 문자열
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if (lefts.containsKey(c)) { //왼쪽 자판인 경우
                Pos now = lefts.get(c);
                distance = Math.abs(sL.x - now.x) + Math.abs(sL.y - now.y);
                sL = now;
            } else { //왼쪽의 경우
                Pos now = rights.get(c);
                distance = Math.abs(sR.x - now.x) + Math.abs(sR.y - now.y);
                sR = now;
            }
            totalTime += (distance + 1); //누르는 시간 포함
        }
        System.out.println(totalTime);
    }
    private static void setKeyboard() {
        char[][] leftAlpha = {{'q', 'w', 'e', 'r', 't'}, {'a', 's', 'd', 'f', 'g'}, {'z', 'x', 'c', 'v'}};
        char[][] rightAlpha = {{'y', 'u', 'i', 'o', 'p'}, {'h', 'j', 'k', 'l'}, {'b', 'n', 'm'}};
        lefts = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                lefts.put(leftAlpha[i][j], new Pos(i, j));
                if(i == 2 && j == 3)
                    break;
            }
        }
        rights = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5 - i; j++) {
                int y = i == 2 ? 4 + j : 5 + j;
                rights.put(rightAlpha[i][j], new Pos(i, y));
            }
        }
    }
    private static class Pos{
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
