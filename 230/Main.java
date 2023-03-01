import java.util.Stack;

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1),
                                null),
                        new TreeNode(4)),
                new TreeNode(6));
        Main main = new Main();
        System.out.println(main.kthSmallest(root, 6));
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode x = min(root, s);
        for (int i = 1; i < k; i++)
            x = successor(x, s);
        return x.val;
    }

    private TreeNode successor(TreeNode x, Stack<TreeNode> s) {
        if (x.right != null) {
            s.add(x);
            return min(x.right, s);
        }
        TreeNode y = s.pop();
        while (y.right == x) {
            x = y;
            y = s.pop();
        }
        return y;
    }

    private TreeNode min(TreeNode x, Stack<TreeNode> s) {
        while (x.left != null) {
            s.add(x);
            x = x.left;
        }
        return x;
    }
}