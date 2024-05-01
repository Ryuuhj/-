import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main_14891 {
    static char[][] gearNums = new char[4][8];
    static Deque<Integer>[] gears = new Deque[4];
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            gearNums[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < 4; i++) {
            gears[i] = IntStream.range(0, 8).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        }
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken()) - 1;
            int spinDir = Integer.parseInt(st.nextToken());
            visited = new boolean[4];
            spinGear(now, spinDir);
        }
        //k번 회전 후 12시 방향 극 확인
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            ans += (gearNums[i][gears[i].peekFirst()] - '0') * Math.pow(2, i);
        }
        System.out.println(ans);
    }

    private static void spinGear(int now, int spinDir) {
        visited[now] = true;
        //양 옆 톱니 극 같은지 확인
        int left = now - 1;
        int right = now + 1;
        if(left >= 0 && !visited[left]){ //왼쪽 톱니(방문하지 않음)
            //now의 6번째 오는 극, left의 2번째 오는 극 같은지 확인
            int nowIdx = (gears[now].peekFirst() + 6) % 8;
            int leftIdx = (gears[left].peekFirst() + 2) % 8;
            if(gearNums[left][leftIdx] != gearNums[now][nowIdx]){
                spinGear(left, -1 * spinDir);
            }
        }
        if(right < 4 && !visited[right]){
            //now의 2번째 오는 극, right의 6번째 오는 극 같은지 확인
            int nowIdx = (gears[now].peekFirst() + 2) % 8;
            int rightIdx = (gears[right].peekFirst() + 6) % 8;
            if(gearNums[right][rightIdx] != gearNums[now][nowIdx]){
                spinGear(right, -1 * spinDir);
            }
        }
        //now의 기어 회전
        if (spinDir == 1) { //시계 방향
            gears[now].addFirst(gears[now].pollLast());
        } else {
            gears[now].addLast(gears[now].pollFirst());
        }
    }
}
