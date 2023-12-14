import java.util.*;
class Solution {
    static ArrayList<Integer> list = new ArrayList<>();
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        for (String cmd : operations) {
            getResult(cmd.split(" "));
        }
        if(!list.isEmpty()){
            Collections.sort(list);
            answer[1] = list.get(0);
            answer[0] = list.get(list.size() - 1);
        }
        return answer;
    }

    private void getResult(String[] cmd) {
        if (cmd[0].equals("I")) {
            list.add(Integer.parseInt(cmd[1]));
        } else {
            if(list.isEmpty()) return;
            Collections.sort(list);
            if(cmd[1].equals("1")){
                list.remove(list.size() - 1);
            }else {
                list.remove(0);
            }
        }
    }
}