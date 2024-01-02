package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11286 {
    static int N, x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        //{원본 값, 절댓값}
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] < o2[1]) return -1;
                else if(o1[1] > o2[1]) return 1;
                else {
                    if(o1[0] < o2[0]) return -1;
                    else if(o1[0] > o2[0]) return 1;
                }
                return 0;
            }
        });
        while (N-- > 0) {
            x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(pq.isEmpty()) sb.append("0\n");
                else sb.append(pq.poll()[0]).append("\n");
                continue;
            }
            pq.add(new int[]{x, Math.abs(x)});
        }
        System.out.println(sb);
    }
}
