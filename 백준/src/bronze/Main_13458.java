package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13458 {
    //답이 int 범위를 넘을 수 있음에 주의!!
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            A[i] -= B;
            cnt++;
            if(A[i] > 0)
                cnt += (A[i] % C == 0 ? A[i] / C : A[i] / C + 1);
        }
        System.out.println(cnt);
    }
}
