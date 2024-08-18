import java.util.Scanner;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // 중복 순열 시작
        for (int start : new int[]{2, 3, 5, 7}) {
            findPrime(1, start);
        }
    }

    private static void findPrime(int depth, int number) {
        if(depth == N){
            System.out.println(number);
            return;
        }
        int tmp = number * 10;
        for (int i = 1; i <= 9; i++) {
            if(isPrime(tmp+i))
                findPrime(depth+1, tmp+i);
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}