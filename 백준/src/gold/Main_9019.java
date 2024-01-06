package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_9019 {
    static int start, target;
    static boolean[] visit;
    static String[] command = {"D", "S", "L", "R"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());
            visit = new boolean[10000];
            sb.append(bfs(start)).append("\n");
        }
        System.out.print(sb);
    }

    private static String bfs(int start) {
        Queue<Register> queue = new LinkedList<>();
        queue.add(new Register(start, ""));
        visit[start] = true;
        while (!queue.isEmpty()) {
            Register now = queue.poll();
            if (now.number == target)
                return now.cmd;
            for (String c : command) {
                int next = calculate(now, c);
                //next에 이르기까지 명령어 최소여야 함
                if(!visit[next]){
                    queue.add(new Register(next, now.cmd + c));
                    visit[next] = true;
                }
            }
        }
        return "Error!";
    }

    private static int calculate(Register now, String c) {
        int number = 0, rest;
        switch (c) {
            case "D":
                number = now.number * 2 % 10000;
                break;
            case "S":
                number = now.number == 0 ? 9999 : now.number - 1;
                break;
            case "L":
                int first = now.number / 1000;
                rest = now.number % 1000;
                number = rest * 10 + first;
                break;
            case "R":
                int last = now.number % 10;
                rest = now.number / 10;
                number = last * 1000 + rest;
                break;
        }
        return number;
    }

    private static class Register{
        int number;
        String cmd;

        Register(int number, String cmd) {
            this.number = number;
            this.cmd = cmd;
        }
    }
}
