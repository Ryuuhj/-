import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static String[] alphabet;
	static StringBuilder sb = new StringBuilder();
	static Set<String> vowels = new HashSet<String>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		vowels.add("a"); vowels.add("e"); vowels.add("i"); vowels.add("o"); vowels.add("u");
		
		alphabet = br.readLine().split(" ");
		Arrays.sort(alphabet);
		
		dfs(0, 0, 0, "");
		
		
		
	}
	private static void dfs(int idx, int v, int c, String pw) {
		if(pw.length() == L && v >= 1 && c >= 2) {
			System.out.println(pw);
			return;
		}
		if(idx >= C) {
			return;
		}
		for (int i = idx; i < C; i++) {
			String a = alphabet[i];
			if(vowels.contains(a)) {
				dfs(i+1, v+1, c, pw+a);
			}else {
				dfs(i+1, v, c+1, pw+a);
			}
		}
	}

}
