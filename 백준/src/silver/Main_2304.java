package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2304 {
    static int N, L, H, start, end, stand;
    static int[] blocks = new int[1001];
    static StringTokenizer st;
    static Stack<Integer> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        start = Integer.MAX_VALUE; end = 0;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken()); H = Integer.parseInt(st.nextToken());
            blocks[L] = H;
            start = Math.min(start, L);
            end = Math.max(end, L);
        }
        stack = new Stack<>();
        stand = blocks[start];
        for (int i = start + 1; i <= end; i++) {
            equalize(i);
        }
        stack.clear();
        stand = blocks[end];
        for (int i = end-1; i >= start; i--) {
            equalize(i);
        }
        int area = 0;
        for (int i = start; i <= end; i++) {
            area += blocks[i];
        }
        System.out.println(area);
    }

    private static void equalize(int idx) {
        if(blocks[idx] < stand)
            stack.push(idx);
        else {
            while (!stack.isEmpty()) {
                blocks[stack.pop()] = stand;
            }
            stand = blocks[idx];
        }
    }
}
