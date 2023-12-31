import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                answer++;
                queue.add(i);
                visit[i] = true;
                while(!queue.isEmpty()){
                    int now = queue.poll();
                    for(int j = 0; j < n; j++){
                        if(!visit[j] && computers[now][j] == 1){
                            queue.add(j);
                            visit[j] = true;
                        }
                    }
                }
            }
        }
        return answer;
    }
}