import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
		public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int goodCnt = 0;
		Set<Integer> goodNum = new HashSet<>();
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			if(goodNum.contains(arr[i])) {
				goodCnt++;
				continue;
			}
			for (int j = 0; j < N; j++) {
				int idx = Arrays.binarySearch(arr, arr[i] - arr[j]);
				if(idx < 0 || i == idx || j == idx || i == j) //없는 경우
					continue;
				goodCnt++;
				goodNum.add(arr[i]);
				break;
			}
		}
		
		System.out.println(goodCnt);
	}

}