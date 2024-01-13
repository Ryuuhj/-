package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11725 {
    static int N;
    static StringTokenizer st;
    static Node root = new Node(1);
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            insertNode(root, n1, n2);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < parent.length; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void insertNode(Node root, int n1, int n2) {
        if (root.value == n1 || root.value == n2) {
            int p = 0; int c = 0;
            if (root.value == n1) {
                p = n1; c = n2;
            } else {
                p = n2; c = n1;
            }
            root.setChilds(new Node(c));
            parent[c] = p;
        } else {
            for (Node child : root.childs) {
                insertNode(child, n1, n2);
            }
        }
    }

    private static class Node {
        int value;
        ArrayList<Node> childs;

        Node(int value) {
            this.value = value;
            this.childs = new ArrayList<>();
        }

        public void setChilds(Node node) {
            this.childs.add(node);
        }
    }
}
