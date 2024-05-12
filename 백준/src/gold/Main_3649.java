package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3649 {
    static String input = null;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            int x = Integer.parseInt(input) * 10000000;
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                sb.append("danger").append("\n");
                continue;
            }
            int[] lego = new int[N];
            for (int i = 0; i < N; i++) {
                lego[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(lego);

            String answer = "danger";
            int left = 0, right = N - 1;
            while (left < right) {
                if (lego[left] + lego[right] < x) {
                    left++;
                } else if (lego[left] + lego[right] > x)
                    right--;
                else {
                    answer = "yes " + lego[left] + " " + lego[right];
                    break;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
