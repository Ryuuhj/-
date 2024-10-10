import java.util.Scanner;

public class Main {
	//피사노 주기 : k = 6, 피사노 주기 P는 항상 15*10^(5) = 1500000
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		int len = 1500000;
		
		int[] fibo = new int[len];
		fibo[0] = 0; fibo[1] = 1; 
		for (int i = 2; i < len; i++) {
			fibo[i] = (fibo[i-1]+ fibo[i-2]) % 1000000;
		}
		
		System.out.println(fibo[(int)(n % 1500000)]);
		
	}
}
