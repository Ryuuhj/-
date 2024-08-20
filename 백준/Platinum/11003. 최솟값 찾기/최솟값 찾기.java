import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int[] A;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Num> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.offer(new Num(i, A[i]));
            //Di 구할 차례
            while (!pq.isEmpty()){
                if(pq.peek().index < (i-L+1))
                    pq.poll();
                else {
                    sb.append(pq.peek().value).append(" ");
                    break;
                }
            }
        }

        System.out.println(sb);
    }

    static class Num implements Comparable<Num> {
        int index, value;
        Num(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Num o) {
            return this.value == o.value ? this.index - o.index : this.value - o.value;
        }
    }
}
