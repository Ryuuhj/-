package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1327 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String nums = br.readLine().replaceAll(" ", "");

        char[] str = nums.toCharArray();
        Arrays.sort(str);
        StringBuilder sb = new StringBuilder();
        for (char s : str) {
            sb.append(s);
        }
        //기준
        String sorted = sb.toString();
        System.out.println(bfs(sorted, nums, N, K));
    }

    private static int bfs(String sorted, String str, int N, int K) {
        Map<String, Integer> visit = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        visit.put(str, 0);
        queue.add(str);
        while (!queue.isEmpty()) {
            String now = queue.poll();
            int cnt = visit.get(now);
            if(now.equals(sorted))
                return cnt;


            for (int i = 0; i <= N-K; i++) {
                String reversed = getReverse(now, i, i+K);
                if(!visit.containsKey(reversed)){
                    visit.put(reversed, cnt + 1);
                    queue.add(reversed);
                }
            }
        }
        return -1;
    }

    private static String getReverse(String str, int start, int end) {
        StringBuilder entire = new StringBuilder(str);
        StringBuilder part = new StringBuilder(str.substring(start, end));
        return entire.replace(start, end, part.reverse().toString()).toString();
    }
}
