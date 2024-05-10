import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static Map<Character, Integer> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 10;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            br.readLine();
            sb.append(getAnswer(br.readLine().toCharArray())).append("\n");
        }
        System.out.println(sb);
    }

    private static int getAnswer(char[] input) {
        map = new HashMap<>();
        map.put('(', 0); map.put('[', 0);
        map.put('{', 0); map.put('<', 0);
        for (char e : input) {
            switch (e) {
                case ')':
                    if(map.get('(') > 0)
                        map.replace('(', map.get('(') - 1);
                    else
                        return 0;
                    break;
                case ']':
                    if(map.get('[') > 0)
                        map.replace('[', map.get('[') - 1);
                    else
                        return 0;
                    break;
                case '}':
                    if(map.get('{') > 0)
                        map.replace('{', map.get('{') - 1);
                    else
                        return 0;
                    break;
                case '>':
                    if(map.get('<') > 0)
                        map.replace('<', map.get('<') - 1);
                    else
                        return 0;
                    break;
                default:
                    map.replace(e, map.get(e) + 1);
                    break;
            }
        }
        for(int k : map.values()){
            if(k != 0)
                return 0;
        }
        return 1;
    }
}