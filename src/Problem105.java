package src;

import java.util.Arrays;

public class Problem105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        int rootIdx = 0;
        while (rootIdx<preorder.length && inorder[rootIdx] != preorder[0]) {
            rootIdx++;
        }

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIdx+1),
                Arrays.copyOfRange(inorder, 0, rootIdx));
        root.right = buildTree(Arrays.copyOfRange(preorder,rootIdx+1, preorder.length),
                Arrays.copyOfRange(inorder, rootIdx+1, inorder.length));

        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        System.out.println(root.val);
        dfs(root.right);
    }

    public static void main(String[] args){
        Problem105 obj = new Problem105();

        int[] preorder = {5,3,1,2,4,6,7};
        int[] inorder = {1,2,3,4,5,6,7};

        obj.dfs(obj.buildTree(preorder, inorder));
    }
}
