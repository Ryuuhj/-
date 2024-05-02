package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244 {
    static boolean[] switches;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        switches = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = st.nextToken().equals("1"); //1이면 true(켜짐)
        }
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            chageSwitch(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        //스위치는 20개 단위로 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(switches[i])
                sb.append("1 ");
            else
                sb.append("0 ");
            if(i % 20 == 0)
                sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void chageSwitch(String sex, int idx) {
        if(sex.equals("1")){ //남자인 경우
            for (int i = 1; i <= n; i++) {
                if(i % idx == 0) //배수면 상태 반대로
                    switches[i] = !switches[i];
            }
            return;
        }
        //여자인 경우 - 대칭으로 상태 같은 애들만 반대로
        switches[idx] = !switches[idx];
        for (int i = 1; i <= n; i++) {
            int l = idx - i;
            int r = idx + i;
            if(l < 1 || r > n || (switches[l] != switches[r])) break;
            //상태 동일하면 반대로
            switches[l] = switches[r] = !switches[l];
        }
    }
}
