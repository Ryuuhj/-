package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_7662 {
    static int T, k, n;
    static String[] cmd;
    static PriorityQueue<Integer> pq, rPq;
    static Map<Integer, Integer> exist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            k = Integer.parseInt(br.readLine());
            pq = new PriorityQueue<>();
            rPq = new PriorityQueue<>(Collections.reverseOrder());
            exist = new HashMap<>();
            while (k-- > 0) {
                cmd = br.readLine().split(" ");
                switch (cmd[0]) {
                    case "I":
                        n = Integer.parseInt(cmd[1]);
                        pq.add(n);
                        rPq.add(n);
                        //map에서 통합 관리
                        if (exist.containsKey(n))
                            exist.put(n, exist.get(n) + 1);
                        else
                            exist.put(n, 1);
                        break;
                    default:
                        if (!pq.isEmpty() && cmd[1].equals("-1")) //최솟값 삭제
                            delete(pq);
                        else if (!rPq.isEmpty() && cmd[1].equals("1")) //최댓값 삭제
                            delete(rPq);
                        break;
                }
            }
            if(exist.isEmpty()) //큐 안이 사실상 빈 경우
                sb.append("EMPTY\n");
            else{
                List<Integer> nums = new ArrayList<>(exist.keySet());
                Collections.sort(nums);
                sb.append(nums.get(nums.size() - 1)).append(" ").append(nums.get(0)).append("\n");
            }
        }
        System.out.println(sb);
    }
    private static void delete(PriorityQueue<Integer> pq) {
        while (!pq.isEmpty()) {
            int min = pq.poll();
            if (exist.containsKey(min)) {
                int cnt = exist.get(min) - 1;
                if (cnt == 0) exist.remove(min);
                else exist.replace(min, exist.get(min) - 1);
            } else continue;
            break;
        }
    }
}
