import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, D, maxKillCnt = 0;
    static ArrayList<Pos> enemies = new ArrayList<>();
    static Pos[] archers = new Pos[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); D = Integer.parseInt(st.nextToken());

        //적 위치 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if(st.nextToken().equals("1"))
                    enemies.add(new Pos(i, j));
            }
        }
        //궁수 조합으로 위치 지정

        combi(0, 0);

        System.out.println(maxKillCnt);

    }

    private static void combi(int depth, int start){
        if(depth == 3){
            //궁수 위치 세팅됨 -> 시뮬 시작
            simulation(enemies);
            return;
        }

        for (int i = start; i < M; i++) {
            archers[depth] = new Pos(N, i);
            combi(depth + 1, i + 1);
        }
    }

    private static void simulation(ArrayList<Pos> enemies) {
        List<Pos> cEnemy = new ArrayList<>();
        for (Pos p : enemies){
            cEnemy.add(new Pos(p.x, p.y));
        }
        boolean[][] checked = new boolean[N][M];
        int killCnt = 0;
        
        //적군 죽이기
        while (!cEnemy.isEmpty()) {
            //궁수 3명을 순회하며 죽일 적군 좌표에 boolean-> true 체크

            for (Pos archer : archers) {
                int x = -1, y = -1;
                int minDistance = D;
                int minY = M;
                
                for (Pos e : cEnemy) {
                    //거리가 D 이하이고, minDist보다 가깝거나
                    int d = Math.abs(archer.x - e.x) + Math.abs(archer.y - e.y);
                    
                    if((minDistance > d || (minDistance == d && e.y < minY))){
                        x = e.x;
                        y = e.y;
                        minY = e.y;
                        minDistance = d;
                    }
                }
                //checked에 저장
                
                if(x != -1 && y != -1)
                    checked[x][y] = true;
            }
            //궁수에 대한 순회가 끝나면 -> cEnemy 배열 돌면서 한칸 전진하고, true인 애들은 삭제해줌
            for (int i = cEnemy.size()-1; i >= 0; i--) {
                Pos e = cEnemy.get(i);
                if(checked[e.x][e.y]){
                    ++killCnt;
                    cEnemy.remove(i);
                    checked[e.x][e.y] = false;
                    continue;
                }
                //살아 남았으면 전진, 아니면 삭제
                if(e.x + 1 >= N){
                    cEnemy.remove(i);
                }else {
                    cEnemy.get(i).x++;
                }
            }
            
        }
        maxKillCnt = Math.max(maxKillCnt, killCnt);

    }

    private static class Pos {
        int x, y;

        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
