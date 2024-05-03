package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654 {
    static int N, M;
    static int[] arr;
    static boolean[] used;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        used = new boolean[N];
        StringBuilder sb = new StringBuilder();

        printArr(0, sb);

    }

    private static void printArr(int cnt, StringBuilder sb) {
        if(cnt == M) {
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(used[i]) continue;
            used[i] = true;
            printArr(cnt + 1, new StringBuilder(sb).append(arr[i] + " "));
            used[i] = false;
        }
    }
}
