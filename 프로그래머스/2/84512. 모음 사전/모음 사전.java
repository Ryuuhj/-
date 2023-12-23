class Solution {
    static int answer = -1;
    static String target;
    static boolean find = false;
    static String[] vowel = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        target = word;
        dfs("", 0);
        return answer;
    }

    private void dfs(String word, int length) {
        if(find || length > 5) return;
        answer++;
        if(word.equals(target)) {
            find = true;
            return;
        }
        for (int i = 0; i < 5 ; i++) {
            dfs(word + vowel[i], length + 1);
        }
    }
}