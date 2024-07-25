import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Set<Integer> set = new HashSet<>();
		for(int n : cards)
			set.add(n);

		int[] score = new int[1000001];

		for (int i = 0; i < N; i++) {
			//i번째 수에 대해 i의 모든 배수들에 대해 작업 수행 -> 배수가 카드에 있는 경우 상대방은 -1, 자신은 +1
			for (int j = cards[i] * 2; j < 1000001; j += cards[i]) {
				if(set.contains(j)){
					++score[cards[i]];
					--score[j];
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(score[cards[i]]).append(" ");
		}

		System.out.println(sb);


	}
}

