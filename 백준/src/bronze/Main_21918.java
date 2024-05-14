package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_21918 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] lightBulbs = new boolean[N + 1]; //false Off, true On
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (st.nextToken().equals("0")) {
                lightBulbs[i] = false;
            } else {
                lightBulbs[i] = true;
            }
        }
        while (M-- > 0) {
            conductCmd(lightBulbs, Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if(lightBulbs[i])
                sb.append("1");
            else
                sb.append("0");
            sb.append(" ");
        }
        System.out.print(sb);
    }

    private static void conductCmd(boolean[] lightBulbs, int[] cmd) {
        if (cmd[0] == 1) {
            lightBulbs[cmd[1]] = cmd[2] == 1;
        } else {
            for (int i = cmd[1]; i <= cmd[2]; i++) {
                if(cmd[0] == 2)
                    lightBulbs[i] = !lightBulbs[i];
                else if(cmd[0] == 3)
                    lightBulbs[i] = false;
                else
                    lightBulbs[i] = true;
            }
        }
    }
}
