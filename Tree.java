public class Tree {
    int val;
    Tree right;
    Tree left;

    public Tree(int val, Tree left, Tree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void traverse(Tree root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        traverse(root.right);
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        Tree left = new Tree(4, null, null);
        Tree right = new Tree(6, null, null);
        Tree root = new Tree(10, left, right);
        root.traverse(root);
}
}
