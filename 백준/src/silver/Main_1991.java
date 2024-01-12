package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1991 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static Node root = new Node('A', null, null);
    private static class Node {
        char mid; Node left; Node right;

        Node(char mid, Node left, Node right) {
            this.mid = mid;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            char mid = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);
            setTree(root, mid, left, right);
        }
        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);
        System.out.print(sb);
    }

    //루트 - 왼쪽 - 오른쪽(있으면 출력) 없다면 왼쪽, 왼쪽 없으면 오른쪽 타고 내려감
    private static void preOrder(Node now) {
        if(now == null) return;
        sb.append(now.mid);
        preOrder(now.left);
        preOrder(now.right);
    }
    //왼쪽 - 루트 - 오른족
    private static void inOrder(Node now) {
        if(now == null) return;
        inOrder(now.left);
        sb.append(now.mid);
        inOrder(now.right);
    }
    //왼쪽 - 오른쪽 - 루트
    private static void postOrder(Node now) {
        if (now == null) return;
        postOrder(now.left);
        postOrder(now.right);
        sb.append(now.mid);
    }

    private static void setTree(Node now, char mid, char left, char right) {
        if (now.mid == mid) {
            now.left = left == '.' ? null : new Node(left, null, null);
            now.right = right == '.' ? null : new Node(right, null, null);
            return;
        }
        if(now.left != null)
            setTree(now.left, mid, left, right);
        if (now.right != null)
            setTree(now.right, mid, left, right);
    }
}
