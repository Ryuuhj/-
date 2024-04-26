import java.util.*;
class Solution {
    static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = makeMap(rows, columns);
        for(int i=0; i<queries.length; i++){
            answer[i] = spinMap(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }
        return answer;
    }
    
    private int spinMap(int sr, int sc, int er, int ec){
        int nowR = sr, nowC = sc;
        int min = 20000, dir = 0;
        int pre = map[sr][sc];
        while(true){
            int nextR = nowR + d[dir][0];
            int nextC = nowC + d[dir][1];
            if(nextR < sr || nextR > er || nextC < sc || nextC > ec) {
                dir = (dir+1)%4;
                continue;
            }
            min = Math.min(min, pre);
            int tmp = map[nextR][nextC];
            map[nextR][nextC] = pre;
            pre = tmp;
            nowR = nextR; 
            nowC = nextC;
            if(nowR == sr && nowC == sc)
                break;
        }
        return min;
    }
    private int[][] makeMap(int rows, int columns){
        int[][] map = new int[rows+1][columns+1];
        int k = 1;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j] = k++;
            }
        }
        return map;
    }
}