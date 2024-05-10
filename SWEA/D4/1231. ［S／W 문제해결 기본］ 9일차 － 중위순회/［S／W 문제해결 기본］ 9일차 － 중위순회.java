import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {
    static String[] nodeValue;
    static Node[] tree;
    static StringBuilder ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int tc = Integer.parseInt(br.readLine());
        int tc = 10;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            nodeValue = new String[N + 1];
            tree = new Node[N + 1];
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                nodeValue[num] = st.nextToken();
                int left = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
                int right = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
                tree[num] = new Node(num, left, right);
            }
            ans = new StringBuilder();
            dfs(1);
            sb.append(ans.toString()).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int mid) {
        if(tree[mid].left != 0)
            dfs(tree[mid].left);

        ans.append(nodeValue[mid]);

        if(tree[mid].right != 0)
            dfs(tree[mid].right);
    }
    static private class Node {
        int mid;
        int left;
        int right;

        Node(int m, int l, int r) {
            this.mid = m;
            this.left = l;
            this.right = r;
        }
    }
}
