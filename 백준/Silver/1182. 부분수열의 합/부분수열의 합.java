import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, S, cnt = 0;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		dfs(0, 0);
		
		System.out.println(cnt);
		
	}
	private static void dfs(int start, int sum) {
		if(start == N) 
			return;	
		
		for (int i = start; i < N; i++) {
			if(sum + arr[i] == S) 
				cnt++;
			dfs(i + 1, sum + arr[i]);
		}
	}

}
