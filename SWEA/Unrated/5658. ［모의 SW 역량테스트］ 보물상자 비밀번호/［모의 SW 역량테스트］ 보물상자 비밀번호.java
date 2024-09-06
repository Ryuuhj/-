import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	static int N, K, unit;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			String input = br.readLine();
			input += input; 
			
			TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
			
			unit = N/4;
			//N/4번 밀어야 함
			for (int s = 0; s < unit; s++) {
				for (int i = 0; i < 4; i++) { // s, s+unit*1, s+unit*2 ...
					treeSet.add(Integer.parseInt(input.substring(s + unit*i, s + unit*(i+1)), 16));
				}
			}
			
			for (int i = 0; i < K-1; i++) {
				treeSet.pollFirst();
			}
			sb.append("#").append(tc).append(" ").append(treeSet.pollFirst()).append("\n");
		}
		System.out.println(sb);
	}
}