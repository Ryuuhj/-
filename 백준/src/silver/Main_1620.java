package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620 {
    static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] pokemon = new String[N + 1];
        Map<String, Integer> pokemonR = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            pokemon[i] = br.readLine();
            pokemonR.put(pokemon[i], i);
        }
        while (M-- > 0) {
            input = br.readLine();
            if('A' <= input.charAt(0) && 'z' >= input.charAt(0)){
                sb.append(pokemonR.get(input)).append("\n");
                continue;
            }
            sb.append(pokemon[Integer.parseInt(input)]).append("\n");
        }
        System.out.println(sb);
    }
}
