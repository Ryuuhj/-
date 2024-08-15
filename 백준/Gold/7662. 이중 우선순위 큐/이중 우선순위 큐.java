import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int k, num;
    static String input;
    static PriorityQueue<Integer> ascQueue = new PriorityQueue<>();
    static PriorityQueue<Integer> descQueue = new PriorityQueue<>(Collections.reverseOrder());
    static Map<Integer, Integer> cnt = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            sb.append(executeInst()).append("\n");
        }

        System.out.println(sb);
    }

    private static String executeInst() throws Exception {
        ascQueue.clear();
        descQueue.clear();
        cnt.clear();

        k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            input = br.readLine();
            //추가
            if (input.charAt(0) == 'I') {
                num = Integer.parseInt(input.substring(2));
                ascQueue.add(num);
                descQueue.add(num);
                if (cnt.containsKey(num))
                    cnt.put(num, cnt.get(num) + 1);
                else
                    cnt.put(num, 1);
            }//삭제
            else {
                if (input.charAt(2) == '1')
                    pollingQueue(descQueue);
                else
                    pollingQueue(ascQueue);
            }
        }
        if (cnt.size() == 0)
            return "EMPTY";
        
        List<Integer> leftNumber = new ArrayList<>(cnt.keySet());
        Collections.sort(leftNumber);
        return leftNumber.get(leftNumber.size() - 1) + " " + leftNumber.get(0);
    }

    private static void pollingQueue(PriorityQueue<Integer> pq) {
        while (!pq.isEmpty()) {
            num = pq.poll();
            if (!cnt.containsKey(num))
                continue;

            if (cnt.get(num) == 1)
                cnt.remove(num);
            else
                cnt.put(num, cnt.get(num) - 1);

            break;
        }
    }
}
