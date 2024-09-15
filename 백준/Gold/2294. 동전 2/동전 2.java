import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k + 1];
        Arrays.fill(dp, -1);
        Set<Integer> input = new HashSet<>();
        while (n-- > 0) {
            input.add(Integer.parseInt(br.readLine()));
        }
        n = input.size();
        List<Integer> coins = new ArrayList<>(input);
        Collections.sort(coins);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int c = coins.get(i);
            for (int j = c; j < k+1; j++) {
                if(dp[j-c] != -1) {
                    if(dp[j] == -1) dp[j] = dp[j - c] + 1;
                    else dp[j] = Math.min((dp[j]), dp[j - c] + 1);
                }
            }
        }
        System.out.println(dp[k]);
    }
}