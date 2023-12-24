package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1931 {
    static int s, e, answer = 0, lastEnd = 0;
    static StringTokenizer st;
    static List<Meeting> schedule;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        schedule = new ArrayList<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            schedule.add(new Meeting(s, e));
        }
        Collections.sort(schedule);
        for (Meeting s : schedule) {
            if(lastEnd <= s.start){
                answer++;
                lastEnd = s.end;
            }
        }
        System.out.println(answer);
    }

    static class Meeting implements Comparable<Meeting> {
        int start; int end;
        Meeting(int s, int e){
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end < o.end) return -1;
            else if(this.end == o.end){
                if(this.start < o.start) return -1;
                else return 1;
            }
            return 1;
        }
    }

}
