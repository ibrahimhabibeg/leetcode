class Main {
  public static void main(String[] args) {

  }

  public boolean isSymmetric(TreeNode root) {
    return isSymmetricUtil(root.left, root.right);
  }

  public boolean isSymmetricUtil(TreeNode l, TreeNode r) {
    return l == null && r == null
        || (l != null && r != null && l.val == r.val && isSymmetricUtil(l.right, r.left)
            && isSymmetricUtil(l.left, r.right));
  }
}