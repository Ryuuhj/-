package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main_7662_2 {
    static int T, k;
    static String cmd;
    static TreeMap<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            k = Integer.parseInt(br.readLine());
            map = new TreeMap<>();
            while (k-- > 0) {
                cmd = br.readLine();
                if(cmd.equals("D -1")){ //최솟값
                    if(!map.isEmpty()) {
                        if (map.firstEntry().getValue() == 1)
                            map.remove(map.firstKey());
                        else map.put(map.firstKey(), map.firstEntry().getValue() - 1);
                    }
                } else if (cmd.equals("D 1")) {
                    if(!map.isEmpty()) {
                        if (map.lastEntry().getValue() == 1)
                            map.remove(map.lastKey());
                        else map.put(map.lastKey(), map.lastEntry().getValue() - 1);
                    }
                }else {
                    int n = Integer.parseInt(cmd.substring(2));
                    map.put(n, map.getOrDefault(n, 0) + 1); //없을 경우 1, 있을 경우 +1
                }
            }
            if(map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }
        System.out.println(sb);
    }
}
