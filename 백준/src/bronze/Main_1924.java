package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1924 {
    final static String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    final static int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        if(x > 1) {
            for (int i = 0; i < x - 1; i++) {
                sum += months[i];
            }
        }
        System.out.println(days[sum % 7]);
    }
}
