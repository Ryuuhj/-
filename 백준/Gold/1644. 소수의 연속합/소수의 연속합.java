import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];
        boolean[] isPrime = new boolean[N + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        if(N == 1){
            System.out.println(0);
            System.exit(0);
        }
        
        //소수 판별
        for (int i = 2; i*i <= N; i++) {
            if(isPrime[i]){
                for (int j = 2 * i; j <= N; j += i) {
                    if(isPrime[j])
                        isPrime[j] = false;
                    //System.out.printf("j = %d, isprime = %b\n", j, isPrime[j]);
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if(isPrime[i])
                primes.add(i);
        }

        //Arrays.fill(nums, 1);
        int len = primes.size();
        for (int i = 0; i < len; i++) {
            int sum = primes.get(i);
            nums[sum]++;
            for (int j = i+1; j < len; j++) {
                sum += primes.get(j);
                if(sum > N) break;
                nums[sum]++;
            }
        }
        System.out.println(nums[N]);
    }
}