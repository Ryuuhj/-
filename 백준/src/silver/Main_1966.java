package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1966 {
    static PriorityQueue<Integer> pq;
    static Queue<Document> queue;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            queue = new LinkedList<>();
            pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(st.nextToken());
                queue.add(new Document(i, p));
                pq.add(p);
            }
            int order = 1;
            while (!(queue.isEmpty() || pq.isEmpty())) {
                Document doc = queue.poll();
                //제일 높은 중요도가 아닌 경우
                if(doc.priority < pq.peek()){
                    queue.add(doc);
                    continue;
                }
                //제일 높은 중요도 -> 바로 인쇄
                pq.poll();
                if(doc.idx == M)
                    break;
                order++;
            }
            sb.append(order).append("\n");
        }
        System.out.println(sb);
    }
    private static class Document {
        int idx; int priority;

        Document(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}
