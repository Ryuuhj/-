import java.util.*;
class Solution {
    Map<Integer, Integer> enterTime = new HashMap<>();
    int[] accTime = new int[10000];
    Set<Integer> carNum = new HashSet<>();
    
    public int[] solution(int[] fees, String[] records) {
        setAccTime(records);
        
        int cnt = carNum.size();
        int[] answer = new int[cnt];
        Arrays.fill(answer, fees[1]);
        
        int idx = 0;
        //누적 값 기준 계산
        for(int i = 0; i < 10000; i++){
            if(accTime[i] != 0){
                double over = accTime[i] - fees[0];
                if(over > 0){ //초과시간 계산
                    answer[idx] += (Math.ceil(over/fees[2]) * fees[3]);
                }
                idx++;
            }
        }
        return answer;
    }
    private void setAccTime(String[] records){
        //누적 시간
        for(String record : records){
            calTime(record.split(" "));
        }
        //누적 끝난 후 남은 시간 계산
        int last = 23*60+59;
        for(int key : enterTime.keySet()){
            int etTime = enterTime.get(key);
            accTime[key] += (last - etTime);
        }
    }
    
    private void calTime(String[] record){
        int cn = Integer.parseInt(record[1]);
        int time = Integer.parseInt(record[0].substring(0,2)) * 60 + Integer.parseInt(record[0].substring(3));
        
        if(record[2].equals("IN")){
            enterTime.put(cn, time);
            carNum.add(cn);
            
        }else if(record[2].equals("OUT")){
            int etTime = enterTime.get(cn);
            enterTime.remove(cn);
            accTime[cn] += (time - etTime);
        }
    }
}