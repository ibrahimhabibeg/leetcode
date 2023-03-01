import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(root, targetSum, new ArrayList<Integer>(), res);
        return res;
    }

    private void backtrack(TreeNode node, int targetSum, List<Integer> list, List<List<Integer>> res) {
        if (node == null)
            return;
        list.add(node.val);
        targetSum -= node.val;
        if (node.left == null && node.right == null && targetSum == 0)
            res.add(new ArrayList<Integer>(list));
        backtrack(node.left, targetSum, list, res);
        backtrack(node.right, targetSum, list, res);
        targetSum += node.val;
        list.remove(list.size() - 1);
    }
}