package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17951 {
    static int left, right, mid;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;
        left = 0;
        right = Arrays.stream(scores).sum();
        while (left <= right) {
            mid = (left + right) / 2;
            int groupSum = 0, groups = 0;
            for (int i = 0; i < N; i++) {
                groupSum += scores[i];
                if (groupSum >= mid) {
                    groups++;
                    groupSum = 0;
                }
            }
            //만들어진 그룹 개수가 K보다 큰 경우 -> 기준 최소(mid)가 너무 작음
            if(groups >= K){
                left = mid + 1;
                answer = mid;
            }else //그룹 개수가 K보다 작은 경우 -> 기준이 너무 큼
                right = mid - 1;
        }
        System.out.println(answer);
    }
}
