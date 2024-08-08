import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	/*
	 * N으로 이뤄진 순열을 `사전순`으로 출력하는 문제
	 */
	static int N;
	static int[] arr;
	static boolean[] used;
	static int[] answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = IntStream.range(1, N+1).toArray();
		answer = new int[N];
		
		//1. for문으로 풀기 -> N이 가변적이여서 불가능
		//2. flag로 풀기
		used = new boolean[N+1];
		permutation_flag(0);
	}
	
	private static void permutation_flag(int depth) {
		if(depth == N) {
			//N개 다 채운 경우
			for(int n : answer) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			//순열 뽑기 전에 중복 검사 해주기
			if(used[arr[i]]) continue;
			//사용하지 않은 숫자에 대해서
			used[arr[i]] = true;
			answer[depth] = arr[i];
			permutation_flag(depth+1);
			used[arr[i]] = false;
			
		}
	}

}
