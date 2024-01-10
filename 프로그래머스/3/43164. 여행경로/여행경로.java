import java.util.*;
class Solution {
    static boolean[] used;
    static String[] answer = {};
    static List<String> maxRoute = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].compareTo(o2[0]) < 0) return -1;
                else if(o1[0].compareTo(o2[0]) > 0) return 1;
                if(o1[0].equals(o2[0])){
                    return o1[1].compareTo(o2[1]);
                }
                return 0;
            }
        });
        maxRoute.add("ICN");
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                used[i] = true;
                maxRoute.add(tickets[i][1]);
                dfs(tickets[i][1], tickets);
                used[i] = false;
                maxRoute.remove(tickets[i][1]);
            }
        }
        return answer;
    }
    
    public void dfs(String now, String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(now) && !used[i]) {
                used[i] = true;
                maxRoute.add(tickets[i][1]);
                dfs(tickets[i][1], tickets);
                used[i] = false;
                maxRoute.remove(maxRoute.size()-1);
            }
        }
        if (answer.length < maxRoute.size()) {
            answer = maxRoute.toArray(new String[0]);
        }
    }
}