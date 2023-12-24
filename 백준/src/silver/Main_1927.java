package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1927 {
    static int N, num;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    //0 -> 가장 작은 값 poll , 그 외 -> 배열에 추가
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            calculate(Integer.parseInt(br.readLine()), sb);
        }
        System.out.print(sb);
    }

    private static void calculate(int x, StringBuilder sb) {
        if(x == 0){
            try {
                num = pq.poll();
            }catch (NullPointerException e){
                num = 0;
            }finally {
                sb.append(num).append("\n");
            }
            return;
        }
        pq.add(x);
    }
}
