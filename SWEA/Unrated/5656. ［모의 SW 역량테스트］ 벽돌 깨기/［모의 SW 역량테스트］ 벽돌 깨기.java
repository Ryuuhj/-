import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    static int[] orb; //구슬 쏘는 부분의 y좌표를 담은 배열
    static boolean[][] isRemoved;
    static int[][] map;
    static int N, W, H, minRemain;
    static Queue<Block> readyToBomb = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <=T; tc++) {
            init(new StringTokenizer(br.readLine()));

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            setOrb(0);
            sb.append("#").append(tc).append(" ").append(minRemain).append("\n");
        }
         System.out.println(sb);
    }

    private static void setOrb(int cnt) {
        if(cnt == N){
            //블록 깨기 시작
            breakBlocks(map);

            return;
        }
        for (int i = 0; i < W; i++) {
            orb[cnt] = i;
            setOrb(cnt+1);
        }
    }


    private static void breakBlocks(int[][] map) {
        int[][] copiedMap = new int[H][W];
        for (int i = 0; i < H; i++) {
            copiedMap[i] = map[i].clone();
        }

        for (int i = 0; i < N; i++) {
            int orbY = orb[i]; //구슬 시작 좌표
            readyToBomb.clear();
            isRemoved = new boolean[H][W];

            //처음 맞는 블록 좌표
            for(int x = 0; x < H; x++){
                if(copiedMap[x][orbY] != 0){
                    readyToBomb.add(new Block(x, orbY));
                    isRemoved[x][orbY] = true;
                    break;
                }
            }

            //블록 폭파 시작
            while (!readyToBomb.isEmpty()) {
                Block block = readyToBomb.poll();
                //상, 하, 좌, 우 탐색하며 값만큼 블록 없앰
                for (int dir = 0; dir < 4; dir++) {
                    // 만큼 탐색
                    int nx = block.x;
                    int ny = block.y;
                    for (int k = 1; k < copiedMap[block.x][block.y]; k++) {
                        nx += dx[dir];
                        ny += dy[dir];
                        if(nx < 0 || ny < 0 || nx >= H || ny >= W || isRemoved[nx][ny] || copiedMap[nx][ny] == 0) continue;

                        isRemoved[nx][ny] = true;
                        if(copiedMap[nx][ny] > 1)
                            readyToBomb.add(new Block(nx, ny));
                    }
                }
            }
            //블록 삭제, map 갱신
            deleteBlock(copiedMap);
        }
        //남은 블록 개수
        minRemain = Math.min(minRemain, countBlock(copiedMap));
    }

    private static int countBlock(int[][] map) {
        int cnt = 0;
        for (int[] arr : map) {
            for (int n : arr) {
                if(n != 0)
                    ++cnt;
            }
        }
        return cnt;
    }

    private static void deleteBlock(int[][] map) {
        //y축 기준으로 삭제된 블록 개수 카운팅
        int[] rCnt = new int[W];
        Stack<Integer> stack = new Stack<>();
        //boolean 배열 돌며 먼저 블록 삭제
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(isRemoved[i][j]) {
                    map[i][j] = 0;
                    rCnt[j]++;
                }
            }
        }
        //블록 끌어내리기
        //위에서부터 스택에 값을 담아주고, 밑에서부터 스택 값 빼주며 넣어줌
        for (int y = 0; y < W; y++) {
            if(rCnt[y] == 0) continue;
            //바로 쌓일 인덱스 측정
            for (int x = 0; x < H; x++) {
                if(map[x][y] != 0){
                    stack.push(map[x][y]); //해당 값 넣어줌
                    map[x][y] = 0;
                }
            }
            //스택 뽑으며 다시 고고
            for (int x = H-1; x >= 0; x--) {
                if(stack.isEmpty()) break;
                map[x][y] = stack.pop();
            }
        }

    }

    private static void init(StringTokenizer st) {
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        isRemoved = new boolean[H][W];
        orb = new int[N];
        minRemain = Integer.MAX_VALUE;
    }

    private static class Block{
        int x, y;

        Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}