package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_6549 {
    static int[] height;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.countTokens() != 1) {
            int n = Integer.parseInt(st.nextToken());
            height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(getArea(n)).append("\n");
            st = new StringTokenizer(br.readLine());
        }
        System.out.println(sb);
    }

    private static long getArea(int n) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        for (int i = 0; i < n; i++) {
            int nowHeight = height[i];
            while (!stack.isEmpty() && height[stack.peek()] >= nowHeight) { //height[i]보다 높이가 높거나 같은 모든 막대 꺼내 최대 넓이 계산 (기준점이 i가 됨)
                int top = stack.pop();

                //마지막 막대인 경우 = 모든 막대가 nowHeight 보다 크거나 같음 => 최대 너비 width = i (= 0 ~ i-1)로 계산
                //마지막 막대 아닌 경우 = height[top]보다 작은 막대가 있다는 것 => 최대 너비 width = i-1 ~ 작은막대 (작은막대는 포함 X)
                long width = stack.isEmpty() ? i : i - 1 - stack.peek();
                maxArea = Math.max(maxArea, height[top] * width);
            }
            stack.push(i); //이후 i번째 막대 넣음
        }
        //모두 끝난 후 스택에 남아있는 막대 처리 (마지막 막대 높이보다 작은 막대들)
        while (!stack.isEmpty()) {
            int top = stack.pop();
            long width = stack.isEmpty() ? n : n - 1 - stack.peek();
            maxArea = Math.max(maxArea, width * height[top]);
        }
        return maxArea;
    }
}
