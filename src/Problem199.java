package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        q.add(root);

        while (!q.isEmpty()) {
            res.add(q.peek().val);
            int length = q.size();
            for (int i=1; i <= length; i++) {
                TreeNode dequeue = q.remove();
                if (dequeue.right != null) q.add(dequeue.right);
                if (dequeue.left != null) q.add(dequeue.left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem199 obj = new Problem199();
        TreeNode root = new TreeNode(0);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        root.left = one;
        root.right = two;

        root.left.left = three;
        root.left.right = four;

        root.right.left = five;
        root.right.right = six;

        System.out.println(obj.rightSideView(root));
    }
}
