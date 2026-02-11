package src;

import java.util.ArrayList;
import java.util.List;

public class Problem230 {
    // Definition for a binary tree node.

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

        TreeNode root = new TreeNode(4);
        TreeNode rootLeft = new TreeNode(3);
        TreeNode rootRight = new TreeNode(5);
        TreeNode rootLeftLeft = new TreeNode(2);

        root.left = rootLeft;
        root.right = rootRight;

        root.left.left = rootLeftLeft;

        System.out.println(obj.kthSmallest(root, 3));
    }
}
