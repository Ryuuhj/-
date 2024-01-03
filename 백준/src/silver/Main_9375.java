package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_9375 {
    static int TC, n;
    static String[] clothe;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            Map<String, Integer> map = new HashMap<>();
            n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                clothe = br.readLine().split(" ");
                if(map.containsKey(clothe[1])) {
                    map.put(clothe[1], map.get(clothe[1]) + 1);
                    continue;
                }
                map.put(clothe[1], 2); //안 입는 경우 + 하고 시작
            }
            sb.append(getSum(map)).append("\n");
        }
        System.out.print(sb);
    }

    private static int getSum(Map<String, Integer> map) {
        int sum = 1;
        for (int cnt : map.values()) {
            sum *= cnt;
        }
        return sum - 1;
    }
}
