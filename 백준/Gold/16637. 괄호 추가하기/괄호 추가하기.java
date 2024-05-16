import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, maxResult = Integer.MIN_VALUE;
	static char[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = br.readLine().toCharArray();
		if(N < 3) {
			System.out.println(arr[0]);
			return;
		}
		dfs(2, (int)arr[0] - '0');
		
		System.out.println(maxResult);
	}
	private static void dfs(int idx, int acc) {
		if(idx > N) {
			maxResult = Math.max(maxResult, acc);
			return;
		}
		//괄호 묶어서 계산
		if(idx + 2 < N) {
			int tmp = calculate((int)arr[idx]-'0', (int)arr[idx+2]-'0', arr[idx+1]);
			dfs(idx + 4, calculate(acc, tmp, arr[idx-1]));
		}
		//그냥 계산
		dfs(idx+2, calculate(acc, (int)arr[idx]-'0', arr[idx-1]));
	}
	private static int calculate(int n1, int n2, char op) {
		if(op == '+')
			return n1 + n2;
		else if(op == '-')
			return n1 - n2;
		else
			return n1 * n2;
	}
}
