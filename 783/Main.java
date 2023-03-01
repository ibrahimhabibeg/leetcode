class Main {
    public static void main(String[] args) {

    }

    public int minDiffInBST(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;
        int res = Math.min(minDiffInBST(root.left), minDiffInBST(root.right));
        if (root.right != null)
            res = Math.min(res, min(root.right) - root.val);
        if (root.left != null)
            res = Math.min(res, root.val - max(root.left));
        return res;
    }

    private int min(TreeNode root) {
        while (root.left != null)
            root = root.left;
        return root.val;
    }

    private int max(TreeNode root) {
        while (root.right != null)
            root = root.right;
        return root.val;
    }

    TreeNode prev;
    int res = Integer.MAX_VALUE;

    public int minDiffInBST2(TreeNode root) {
        if (root.left != null)
            res = Math.min(res, minDiffInBST2(root.left));
        if (prev != null)
            res = Math.min(root.val - prev.val, res);
        prev = root;
        if (root.right != null)
            res = Math.min(res, minDiffInBST2(root.right));
        return res;
    }
}
