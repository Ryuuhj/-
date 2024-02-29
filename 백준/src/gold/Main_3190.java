package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_3190 {
    static int[][] map;
    static Map<Integer, Character> cmd = new HashMap<>();
    static int N;
    static StringTokenizer st;
    static int[][] move = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        int K = Integer.parseInt(br.readLine());
        //사과 놓기
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 4;
        }
        int L = Integer.parseInt(br.readLine());
        while (L-- > 0) {
            st = new StringTokenizer(br.readLine());
            cmd.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }
        int answer = startGame(N, 1, 1);
        System.out.println(answer);
  }

    private static int startGame(int n, int x, int y) {
        Queue<Pos> snake = new LinkedList<>();
        int headX = x, headY = y, dir = 0;
        snake.add(new Pos(x, y));
        int time;
        for (time = 0; time < 15000; time++) { //0초부터 시작, 1초부터 움직임
            if(headX < 1 || headX > N || headY < 1 || headY > N)
                break;
            snake.add(new Pos(headX, headY));
            //사과 있는지 검사 -> 없으면 꼬리 한칸 이동
            if(map[headX][headY] == 0){
                Pos tail = snake.poll();
                map[tail.x][tail.y] = 0; //뱀 흔적 지움
            }
            //사과 있는 경우는 꼬리 변동 X
            if(map[headX][headY] == 1)//이미 몸이 있는 경우
                break;

            map[headX][headY] = 1; //머리 옮김
            //명령 있으면 방향 전환
            if(cmd.containsKey(time)){
                if(cmd.get(time) == 'D') //오른쪽이면 -1
                    dir = (dir + 4 - 1) % 4;
                else
                    dir = (dir + 1) % 4;
            }
            //방향대로 한칸 이동
            headX += move[dir][0];
            headY += move[dir][1];
        }
        return time;
    }

    private static class Pos{
        int x; int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
