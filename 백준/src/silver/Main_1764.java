package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1764 {
    static String name;
    static Set<String> nlSet = new HashSet<>();
    static List<String> nsList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        while (N-- > 0) {
            nlSet.add(br.readLine());
        }
        while (M-- > 0) {
            name = br.readLine();
            if(nlSet.contains(name)) {
                nsList.add(name);
            }
        }
        Collections.sort(nsList);
        sb.append(nsList.size()).append("\n");
        for(String name : nsList){
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }
}
