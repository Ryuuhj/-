import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long answer = 0;
		
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		HashMap<Integer, Integer> accSum = new HashMap<>();
		int sum = 0, key = 0;
		for (int i = 0; i < N; i++) {
			sum += A[i];
			//sum - x = K, x = sum - K 있는지 확인
			key = sum - K;
            
			if(accSum.containsKey(key))
				answer += accSum.get(key);
			
			if(sum == K)
				answer++;
			accSum.put(sum, accSum.getOrDefault(sum, 0) + 1);
			
		}
		System.out.println(answer);
	}

}
