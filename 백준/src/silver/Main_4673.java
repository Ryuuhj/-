package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_4673 {
    final static int limit = 10000;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] selfNumber = new boolean[limit + 1];
        Arrays.fill(selfNumber, true);
        for (int i = 1; i <= limit; i++) {
            int dn = getD(i);
            if (dn <= limit)
                selfNumber[dn] = false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= limit; i++) {
            if(selfNumber[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static int getD(int n) {
        int sum = n;
        String str = String.valueOf(n);
        for (int i = 0; i < str.length(); i++) {
            sum += (str.charAt(i) - '0');
        }
        return sum;
    }
}
