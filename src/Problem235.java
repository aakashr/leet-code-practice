package src;

public class Problem235 {
   public static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args){
        Problem235 obj = new Problem235();

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

        System.out.println(obj.lowestCommonAncestor(root, p, q).val);

        // Test Case 2: p is root and q is child.
//        TreeNode root2 = new TreeNode(2);
//        TreeNode p = new TreeNode(2);
//        TreeNode q = new TreeNode(1);
//        root2.left = q;
//
//        System.out.println(obj.lowestCommonAncestor(root2, p, q).val);
    }
}