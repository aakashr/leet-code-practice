package src;

import java.util.ArrayList;
import java.util.List;

public class Problem230 {
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        Problem230.TreeNode left;
        Problem230.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, Problem230.TreeNode left, Problem230.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<Integer> elements = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {

        dfs(root, k);

        return elements.get(k-1);
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        dfs(root.left, k);
        elements.add(root.val);
        if (elements.size() == k) {
            return;
        }
        dfs(root.right  , k);
    }

    public static void main(String[] args) {
        Problem230 obj = new Problem230();

        Problem230.TreeNode root = new Problem230.TreeNode(4);
        Problem230.TreeNode rootLeft = new Problem230.TreeNode(3);
        Problem230.TreeNode rootRight = new Problem230.TreeNode(5);
        Problem230.TreeNode rootLeftLeft = new Problem230.TreeNode(2);

        root.left = rootLeft;
        root.right = rootRight;

        root.left.left = rootLeftLeft;

        System.out.println(obj.kthSmallest(root, 3));
    }
}
