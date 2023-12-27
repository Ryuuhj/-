package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2805 {
    static int[] tree;
    static int N, M, mid;
    static long tmpSum, ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(tree);
        int left = 0;
        int right = tree[N - 1];
        while (left <= right) {
            mid = (left + right) / 2;
            tmpSum = getWood(mid);
            if(tmpSum < M)
                right = mid - 1;
            else {
                ans = mid;
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static long getWood(int mid) {
        long sum = 0;
        for (int t : tree) {
            if(t >= mid)
                sum += (t - mid);
        }
        return sum;
    }
}
