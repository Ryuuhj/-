import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //초밥 개수
		int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속 먹는 개수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		int[] sushi = new int[N];
		int[] selected = new int[d+1];
		
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0, maxCnt = 0;
		for (int i = 0; i < k; i++) {
			if(selected[sushi[i]] == 0)
				++cnt;
			selected[sushi[i]]++;
		}
		maxCnt = selected[c] == 0 ? cnt + 1 : cnt;
		
		for (int i = 0, size = N-k; i < size; i++) {
			//앞 종류 삭제
			selected[sushi[i]]--;
			if(selected[sushi[i]] == 0)
				--cnt;
			//뒷 종류 추가
			if(selected[sushi[i+k]] == 0)
				++cnt;
			selected[sushi[i+k]]++;
			maxCnt = Math.max(maxCnt, selected[c] == 0 ? cnt + 1 : cnt);
		}
		
		int last = N-k;
		for (int i = 0; i < k; i++) {
			//앞 종류 삭제
			selected[sushi[last+i]]--;
			if(selected[sushi[last+i]] == 0)
				--cnt;
			//뒷 종류 추가
			if(selected[sushi[i]] == 0)
				++cnt;
			selected[sushi[i]]++;
			maxCnt = Math.max(maxCnt, selected[c] == 0 ? cnt + 1 : cnt);
		}
		
		System.out.println(maxCnt);
	}

}
