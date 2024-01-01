package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main_18870 {
    static Map<Integer, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> sorted = new ArrayList<>();
        for (int n : input) {
            sorted.add(n);
        }
        Collections.sort(sorted);

        map.put(sorted.get(0), 0);
        int cnt = 1;
        for (int i = 1; i < sorted.size(); i++) {
            if (!map.containsKey(sorted.get(i))) {
                map.put(sorted.get(i), cnt);
                cnt++;
            }
        }
        for (int n : input) {
            sb.append(map.get(n)).append(" ");
        }
        System.out.print(sb);
    }
}
