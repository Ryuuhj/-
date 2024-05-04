import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N;
    static int[] weight, order; //order -> 추 꺼낼 순서 그 자체
    static int answer = 0;
    static boolean[] used;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            answer = 0;
            weight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            order = new int[N];
            used = new boolean[N];
            setOrder(0);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void setOrder(int idx) {
        if(idx == N){ //N개의 순서 다 나눠짐 -> 왼/오 분리해 구할차례
            divide(0, 0, 0);
            return;
        }
        for (int i = 0; i < N; i++) {
            if(used[i]) continue;
            used[i] = true;
            order[idx] = weight[i];
            setOrder(idx + 1);
            used[i] = false;
        }
    }

    private static void divide(int idx, int left, int right) {
        if(left < right)
            return;
        if(idx == N){
            answer++;
            return;
        }
        divide(idx + 1, left + order[idx], right);
        divide(idx + 1, left, right + order[idx]);
    }
}