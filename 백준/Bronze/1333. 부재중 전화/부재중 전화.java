import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 0 1 2 3 4 / 5 6 7 8 9 / 10 11 12 13 14 / 15 16 17 18 19 / 20
	 */
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int time = 0;
		int stop = 0;
		int cnt = 0;
		
		while(true) {
			if(cnt < N && time == stop) {
				time += L;
				stop+=(L+5);
				//System.out.println(stop);
				cnt++;
			}
			
			if(time % D == 0)
				break;
			time++;
		}
		
		System.out.println(time);
	}

}
