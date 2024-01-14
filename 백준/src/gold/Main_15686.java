package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15686 {
    //치킨 집에서 시작 -> BFS 탐사로 최솟값 갱신
    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] distance;
    static int[] chickenM;
    static List<Pos> chickenRest = new ArrayList<>();
    static List<Pos> house = new ArrayList<>();

    private static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chickenM = new int[M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if(line[j].equals("1"))
                    house.add(new Pos(i, j));
                else if(line[j].equals("2"))
                    chickenRest.add(new Pos(i, j));
            }
        }
        distance = new int[house.size()][chickenRest.size()]; //row=집번호, col=치킨집 번호
        //각 집 <-> 치킨집 사이 거리 저장
        for (int i = 0; i < distance.length; i++) {
            Pos nh = house.get(i);
            for (int j = 0; j < chickenRest.size(); j++) {
                Pos cr = chickenRest.get(j);
                distance[i][j] = Math.abs(nh.x - cr.x) + Math.abs(nh.y - cr.y);
            }
        }
        searchMin(0, 0);
        System.out.println(answer);
    }

    private static void searchMin(int cIdx, int cnt) {
        if (cnt == M){
            int tmp = getDistSum();
            answer = Math.min(answer, tmp);
            return;
        }
        for (int i = cIdx; i < chickenRest.size(); i++) {
            chickenM[cnt] = i;
            searchMin(i+1, cnt + 1);
        }
    }

    private static int getDistSum() {//각 집마다 M개 후보 치킨집 중 최소 거리 계산해 더함
        int sum = 0;
        for (int i = 0; i < house.size(); i++) {
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < chickenM.length; j++) {
                tmp = Math.min(tmp, distance[i][chickenM[j]]);
            }
            sum += tmp;
        }
        return sum;
    }
}
