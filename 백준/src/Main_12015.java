import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_12015 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> LIS = new ArrayList<>();
        int lastIdx = 0;
        LIS.add(A[0]);
        for (int i = 1; i < N; i++) {
            int num = A[i];
            if(LIS.get(lastIdx) < num){
                lastIdx++;
                LIS.add(num);
                continue;
            }
            //자리 바꿀 수 찾기 위해 이분탐색
            int low = 0, high = lastIdx + 1;
            while (low < high){
                int mid = (low + high) / 2;
                if (LIS.get(mid) < num) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            LIS.set(low, num); //대체
        }
        //길이 == 마지막 인덱스 +1
        System.out.println(LIS.size());
    }
}
