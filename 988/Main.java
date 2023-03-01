class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(0, new TreeNode(1), null), new TreeNode(1));
        Main main = new Main();
        System.out.println(main.smallestFromLeaf(root));
    }

    String res;

    public String smallestFromLeaf(TreeNode root) {
        DFS(root, new StringBuilder());
        return res;
    }

    private void DFS(TreeNode root, StringBuilder sb) {
        sb.insert(0, (char) ('a' + root.val));
        if (root.left != null && root.right != null) {
            DFS(root.left, sb);
            DFS(root.right, sb);
        } else if (root.left != null) {
            DFS(root.left, sb);
        } else if (root.right != null) {
            DFS(root.right, sb);
        } else if (res == null || sb.toString().compareTo(res) < 0) {
            res = sb.toString();
        }
        sb.deleteCharAt(0);
    }

}