class Main {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        else if (root.right == null)
            return isValidBST(root.left) && root.val > maxValBST(root.left);
        else if (root.left == null)
            return isValidBST(root.right) && root.val < minValBST(root.right);
        else
            return isValidBST(root.left) && root.val > maxValBST(root.left) && isValidBST(root.right)
                    && root.val < minValBST(root.right);
    }

    public int maxValBST(TreeNode root) {
        TreeNode x = root;
        TreeNode p = null;
        while (x != null) {
            p = x;
            x = x.right;
        }
        return p.val;
    }

    public int minValBST(TreeNode root) {
        TreeNode x = root;
        TreeNode p = null;
        while (x != null) {
            p = x;
            x = x.left;
        }
        return p.val;
    }
}