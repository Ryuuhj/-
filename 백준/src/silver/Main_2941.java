package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2941 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", "1");
        System.out.println(str.length());
    }
}
