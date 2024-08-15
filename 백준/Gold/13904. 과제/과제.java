import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int accPoints = 0;
        boolean[] checked = new boolean[1001];

        PriorityQueue<Task> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        while (!pq.isEmpty()) {
            Task task = pq.poll();
            for (int i = task.remainDays - 1; i >= 0; i--) {
                if(checked[i]) continue;
                checked[i] = true;
                accPoints += task.points;
                break;
            }
        }

        System.out.println(accPoints);

    }

    private static class Task implements Comparable<Task>{
        int remainDays, points;

        Task(int remainDays, int points){
            this.remainDays = remainDays;
            this.points = points;
        }
        @Override
        public int compareTo(Task o) {
            if(this.points == o.points)
                return this.remainDays - o.remainDays;
            return o.points - this.points;
        }
    }
}