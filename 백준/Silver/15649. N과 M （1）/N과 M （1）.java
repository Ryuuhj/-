import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M;
    static ArrayList<Integer> arr = new ArrayList<>();
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 1; i <= N ; i++) {
            arr.add(i);
            getMax(1);
            arr.remove(0);
        }
    }

    private static void getMax(int cnt) {
        if (cnt == M) {
            print(arr);
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!arr.contains(i)) {
                arr.add(i);
                getMax(cnt + 1);
                arr.remove(cnt);
            }
        }
    }

    private static void print(ArrayList<Integer> arr) {
        ans = new StringBuilder();
        for (int n : arr) {
            ans.append(n).append(" ");
        }
        System.out.println(ans);
    }
}
