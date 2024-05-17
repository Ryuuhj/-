import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, maxScore = 0; //이닝 수, 픽스된 선수 숫자
	static int[] seq = new int[9];//선발 순서
	static boolean[] checked = new boolean[9], base = new boolean[4]; //사용된 선수
	static int[][] pResult;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		seq[3] = 0; //4번째 타자로 1번 선수
		checked[0] = true;
		
		//선수 점수 기록
		pResult = new int[N][9];
		for (int i = 0; i < N; i++) {
			pResult[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		setPlayer(0);
		System.out.println(maxScore);
	}
	
	private static void setPlayer(int idx) {
		if(idx == 9) {
			maxScore = Math.max(maxScore, playGame());
			return;
		}
		if(idx == 3) {
			setPlayer(idx+1);
			return;
		}
		for (int i = 0; i < 9; i++) {
			if(!checked[i]) {
				seq[idx] = i;
				checked[i] = true;
				setPlayer(idx + 1);
				checked[i] = false;
			}
		}
	}
	private static int playGame() {
		int score = 0;
		int p = 0; //seq[p] 선수부터 시작
		
		for(int n = 0; n < N; n++) { //n번째 이닝에 대해 게임 진행
			Arrays.fill(base, false);; //야구 루 현황 (0 = 홈런, i루)
			int out = 0;
			
			while(out < 3) {
				//게임 진행
				int pNum = seq[p];
				int result = pResult[n][pNum];
				if(result == 0) {
					out++;
				} else {
					score += getScore(pNum, result);
				}
				p = (p + 1) % 9;
			}
		}
		return score;
	}
	private static int getScore(int pNum, int point) {
		int c = 0;
		base[0] = true;
		
		if(point != 4) {
			for(int i = 3; i >= 4 - point; i--) {
				if(base[i]) {
					c++;
					base[i] = false;
				}
			}
			for (int i = 3 - point; i >= 0; i--) {
				base[i+point] = base[i];
				base[i] = false;
			}
		} else { //홈런의 경우
			for(boolean e : base) {
				if(e) c++;
			}
			Arrays.fill(base, false);
		}
		return c;
	}
	
}