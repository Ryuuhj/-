package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/*add x : S에 x 추가 (x가 이미 있다면 무시)
remove x : S에 x가 있는 경우에만 제거
check x : S에 x가 있으면 1, 없으면 0 출력
toggle x: S에 x가 있으면 x 제거, 없으면 x 추가
all : S를 {1, 2, ... , 20}로 바꿈
empty : S를 공집합으로 바꿈
*/
public class Main_11723 {
    static int M;
    static String[] cmd;
    static List<String> all = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20");
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        while (M-- > 0) {
            cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "add":
                    set.add(cmd[1]);
                    break;
                case "remove":
                    set.remove(cmd[1]);
                    break;
                case "check":
                    if(set.contains(cmd[1]))
                        sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "toggle":
                    if(set.contains(cmd[1]))
                        set.remove(cmd[1]);
                    else set.add(cmd[1]);
                    break;
                case "all":
                    set = new HashSet<>(all);
                    break;
                case "empty":
                    set = new HashSet<>();
                    break;
            }
        }
        System.out.println(sb);
    }
}
