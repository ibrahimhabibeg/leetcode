import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<TreeNode> ans = main.generateTrees(1);
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int l, int r) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (r < l)
            ans.add(null);
        for (int i = l; i <= r; i++) {
            List<TreeNode> leftSubTrees = generateTrees(l, i - 1);
            List<TreeNode> rightSubtrees = generateTrees(i + 1, r);
            for (int j = 0; j < leftSubTrees.size(); j++)
                for (int k = 0; k < rightSubtrees.size(); k++)
                    ans.add(new TreeNode(i, leftSubTrees.get(j), rightSubtrees.get(k)));
        }
        return ans;
    }
}