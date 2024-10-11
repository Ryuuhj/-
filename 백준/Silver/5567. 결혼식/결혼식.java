import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        while (m--> 0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int[] checked = new int[n+1]; //3다리까지만 허용 (본인1, 친구 2, 친구의 친구 3)
        checked[1] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if(checked[cur] == 3) continue;
            for (int next : graph[cur]) {
                if(checked[next] == 0) {
                    checked[next] = checked[cur] + 1;
                    q.add(next);
                }
            }
        }
        int ans = 0;
        for (int i = 2; i < n+1; i++) {
            if(checked[i] != 0) ++ans;
        }
        System.out.println(ans);
    }
}