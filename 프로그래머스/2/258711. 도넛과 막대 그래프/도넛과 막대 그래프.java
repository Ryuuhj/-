class Solution {
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int[][] node = new int[1000001][2]; //0 - in, 1 - out
        for(int[] edge : edges){
            node[edge[0]][1]++;
            node[edge[1]][0]++;
        }
        //그래프 탐색
        for(int i = 0; i < node.length; i++){
            if(node[i][0] == 0 && node[i][1] == 0) 
                continue;
            if (node[i][0] == 0 && node[i][1] >= 2){
                answer[0] = i;
            } else if (node[i][1] == 2){ // out 2개
                answer[3]++;
            } else if (node[i][1] == 0) { //막대모양 그래프 = out 0개 존재
                answer[2]++;
            }
        }
        //도넛 -> 전체 - (막대 + 8자)
        answer[1] = node[answer[0]][1] - (answer[2] + answer[3]);
        
        return answer;
    }
}