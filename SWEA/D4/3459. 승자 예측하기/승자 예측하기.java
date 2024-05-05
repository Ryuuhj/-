import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static long N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            N = Long.parseLong(br.readLine());
            sb.append(getAnswer()).append("\n");
            //System.out.println(name);
        }
        System.out.println(sb);
    }

    private static String getAnswer() {
        while (N > 3) {
            N = N / 2 + 1; //A가 이기기 위해
            N = N / 2 - 1; //B가 이기기 위해
        }
        if(N == 0 || N >= 2)
            return  "Alice";
        else
            return "Bob";
    }
}