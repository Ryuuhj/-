import java.util.*;
class Solution {
    static Map<String, Set<String>> maps = new HashMap<>();
    static int min = Integer.MAX_VALUE;
    static Set<String> visit = new HashSet<>();
    public int solution(String begin, String target, String[] words) {
                maps.put(begin, new HashSet<>());
        for (String word : words) {
            maps.put(word, new HashSet<>());
        }
        setMaps(-1, begin, words);
        for (int i = 0; i < words.length; i++) {
            setMaps(i, words[i], words);
        }
        visit.add(begin);
        dfs(begin, target , 0);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private static void setMaps(int idx, String word, String[] words) {

        for (int j = idx + 1; j < words.length; j++) {
            int cnt = 0;
            for (int i = 0; i < word.length(); i++) {
                if(word.charAt(i) == words[j].charAt(i))
                    cnt++;
            }
            if (cnt == word.length() - 1) {
                maps.get(word).add(words[j]);
                maps.get(words[j]).add(word);
            }
        }
    }

    private static void dfs(String now, String target, int cnt) {
        if(now.equals(target)){
            min = Math.min(min, cnt);
            return;
        }
        for(String s : maps.get(now)){
            if(!visit.contains(s)) {
                visit.add(s);
                dfs(s, target, cnt + 1);
                visit.remove(s);
            }
        }
    }
}