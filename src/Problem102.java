package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) { q.add(root); }
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i=0;i<size;i++) {
                TreeNode pop = q.remove();
                temp.add(pop.val);
                if (pop.left != null) { q.add(pop.left); }
                if (pop.right != null) { q.add(pop.right); }
            }
            res.add(temp);
        }
        return res;
    }



    public static void main(String[] args){
        Problem102 obj = new Problem102();

        // Test Case 1:
        TreeNode root = new TreeNode(6);
        TreeNode one = new TreeNode(2);
        TreeNode two = new TreeNode(8);
        TreeNode three = new TreeNode(0);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(7);
        TreeNode six = new TreeNode(9);
        TreeNode seven = new TreeNode(3);
        TreeNode eight = new TreeNode(5);

        root.left = one;
        root.right = two;

        root.left.left = three;
        root.left.right = four;

        root.right.left = five;
        root.right.right = six;

        root.left.right.left = seven;
        root.left.right.right = eight;

        TreeNode p = new TreeNode(0);
        TreeNode q = new TreeNode(5);

        System.out.println(obj.levelOrder(root));

        // Test Case 2: p is root and q is child.
//        TreeNode root2 = new TreeNode(2);
//        TreeNode p = new TreeNode(2);
//        TreeNode q = new TreeNode(1);
//        root2.left = q;
//
//        System.out.println(obj.lowestCommonAncestor(root2, p, q).val);
    }
}
