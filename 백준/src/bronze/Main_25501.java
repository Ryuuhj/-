package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_25501 {
    static int isPalindrome, callCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            callCnt = 1;
            isPalindrome = isPalindrome(br.readLine());
            sb.append(isPalindrome).append(" ").append(callCnt).append("\n");
        }
        System.out.println(sb);
    }
    private static int recursion(String str, int l, int r){
        if(l >= r) return 1;
        else if(str.charAt(l) != str.charAt(r)) return 0;
        else {
            callCnt++;
            return recursion(str, l + 1, r - 1);
        }
    }
    private static int isPalindrome(String str){
        return recursion(str, 0, str.length() - 1);
    }
}
