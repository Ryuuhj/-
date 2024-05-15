import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			String input = br.readLine();
			int[] mem = new int[input.length()];
			for (int i = 0; i < mem.length; i++) {
				if(input.charAt(i) == '1' && mem[i] % 2 != 1)
					fixBit(mem, i);
				else if(input.charAt(i) == '0' && mem[i]%2 != 0)
					fixBit(mem, i);
			}
			sb.append(Arrays.stream(mem).max().getAsInt()).append("\n");
		}
		System.out.println(sb);
	}

	private static void fixBit(int[] mem, int start) {
		for (int i = start; i < mem.length; i++) {
			mem[i]++;
		}
	}
}