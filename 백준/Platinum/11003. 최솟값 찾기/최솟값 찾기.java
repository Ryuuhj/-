import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
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
        Deque<Num> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty()) {
                if(deque.peekLast().value < A[i])
                    break;
                deque.removeLast();
            }
            //맨 앞 수 체크
            if(!deque.isEmpty() && deque.peekFirst().index < (i-L+1))
                deque.removeFirst();
            
            deque.addLast(new Num(i, A[i]));
            sb.append(deque.peekFirst().value).append(" ");
        }
        System.out.println(sb);
    }

    static class Num {
        int index, value;
        Num(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
