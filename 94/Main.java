import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        inorderTraversal(root, ans);
        return ans;
    }

    private void inorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        inorderTraversal(root.left, ans);
        ans.add(root.val);
        inorderTraversal(root.right, ans);
    }
}