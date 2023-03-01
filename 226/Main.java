class Main {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode newRight = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = newRight;
        return root;
    }
}