import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, answer, tmpMax;
    static List<String> words;
    static String tmp;
    static List<Character> chars, tmpChars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(K < 5){
            System.out.println(0);
            return;
        }
        words = new ArrayList<>();
        tmpChars = new ArrayList<>(); tmpChars.addAll(List.of('a', 'c', 'n', 'i', 't'));
        chars = new ArrayList<>();

        answer = 0; tmpMax = 0;

        for (int i = 0; i < N; i++) {
            tmp = br.readLine();
            if(tmp.length() == 8){
                answer++;
                continue;
            }
            words.add(tmp);
        }

        for (int i = 0; i < words.size(); i++) { //후보 글자 넣어주기
            for (char c : words.get(i).toCharArray()) {
                if(!tmpChars.contains(c) && !chars.contains(c)) {
                    chars.add(c);
                }
            }
        }
        if ((K - 5) >= chars.size()) {
            System.out.println(N);
            return;
        }
        explore(-1, 5);
        System.out.println(answer + tmpMax);
    }

    private static void explore(int i, int depth) {
        if(depth > K) return;
        if (depth == K) {
            tmpMax = Math.max(check(), tmpMax);
            return;
        }
        for (int j = i+1; j < chars.size(); j++) {
            tmpChars.add(chars.get(j));
            explore(j, depth + 1);
            tmpChars.remove(depth);
        }
    }

    private static int check() {
        int cnt = 0;
        loopMain:
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!tmpChars.contains(word.charAt(i))) {
                    continue loopMain;
                }
            }
            cnt++;
        }
        return cnt;
    }
}
