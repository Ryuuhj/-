import java.util.*;
class Solution {
    int[][] move = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] field = new int[101][101];
        for(int[] points : rectangle){
            drawEdge(field, points[0]*2, points[1]*2, points[2]*2, points[3]*2);
        }

        return getShortcut(field, new Pos(characterX*2, characterY*2, 1), new Pos(itemX*2, itemY*2, 0));
    }
    private int getShortcut(int[][] field, Pos character, Pos item){
        Queue<Pos> queue = new LinkedList<>();
        boolean[][] visit = new boolean[101][101];
        queue.add(character);
        while(!queue.isEmpty()){
            Pos now = queue.poll();
            if(now.x == item.x && now.y == item.y){
                //System.out.println("x "+now.x+" y "+now.y + " distance "+(now.distance/2));
                return now.distance/2;
            }
            for(int[] d : move){
                int nx = now.x + d[0];
                int ny = now.y + d[1];
                if(nx < 0 || nx > 100 || ny < 0 || ny > 100 || visit[nx][ny] || field[nx][ny] != 1) continue;
                visit[nx][ny] = true;
                //System.out.println("x "+nx+" y "+ny + " distance "+(now.distance+1));
                queue.add(new Pos(nx, ny, now.distance+1));
            }
        }
        return -1;
    }
    private void drawEdge(int[][] field, int startX, int startY, int endX, int endY){
        for(int i = startX; i <= endX; i++){
            for(int j = startY; j <= endY; j++){
                if(field[i][j] == 0)
                    field[i][j] = 1;
            }
        }
        
        for(int i = startX+1; i < endX; i++){
            for(int j = startY + 1; j < endY; j++){
                field[i][j] = 2;
            }
        }   
    }
    private class Pos {
        int x; int y; int distance;
        Pos(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}