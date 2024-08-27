import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	static HashSet<String> set;
	static String input;
	static int len;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		len = input.length();
		
		set = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			dfs(""+input.charAt(i), i, i, 1);
		}
		
		System.out.println(set.size());

	}
	private static void dfs(String acc , int left, int right, int cnt) { //과정이 똑같으면 같은 것이므로 마지막에 set에 추가해주고 같다면 탈
		if(cnt == len) {
			set.add(acc);
			return;
		}
		if(left > 0)
			dfs(acc+input.charAt(left-1)+acc , left-1, right, cnt+1);
		if(right < len-1)
			dfs(acc+acc+input.charAt(right+1), left, right+1, cnt+1);
	
	}

}
