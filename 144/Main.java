import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        preorderTraversalUtil(root, ans);
        return ans;
    }

    public void preorderTraversalUtil(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        ans.add(root.val);
        preorderTraversalUtil(root.left, ans);
        preorderTraversalUtil(root.right, ans);
    }
}