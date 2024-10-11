import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
	static ArrayList<Integer> startIdx = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String pattern = br.readLine();
		
		kmp(origin, pattern);
		
		StringBuilder sb = new StringBuilder();
		sb.append(startIdx.size()).append("\n");
		for(int idx : startIdx)
			sb.append(idx).append("\n");
		
		System.out.println(sb);
		
	}
	
	static int[] getPi(String pat) {
		int n = pat.length();
		int[] pi = new int[n];
		
		int j = 0;
		for (int i = 1; i < n; i++) {
			while(j > 0 && pat.charAt(i) != pat.charAt(j))
				j = pi[j-1];
			if(pat.charAt(i) == pat.charAt(j))
				pi[i] = ++j;
		}
		return pi;
	}
	static void kmp(String origin, String pattern) {
		int[] pi = getPi(pattern);
		int j = 0; 
		int pLen = pattern.length();
		
		for (int i = 0, end = origin.length(); i < end; i++) {
			while(j > 0 && origin.charAt(i) != pattern.charAt(j))
				j = pi[j-1];
			if(origin.charAt(i) == pattern.charAt(j)) {
				if(j == pLen - 1) { //패턴 일치하는 문자열 찾은 경우
					j = pi[j];
					startIdx.add(i - pLen + 2);
				}else {
					++j;
				}
			}
		}
	}
}
