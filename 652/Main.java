import java.util.*;

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(4, null, new TreeNode(2))));
        Main main = new Main();
        System.out.println(main.findDuplicateSubtrees(root));
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        helper(root, new HashMap<String, Boolean>(), res);
        return res;
    }

    private String helper(TreeNode root, HashMap<String, Boolean> map, List<TreeNode> res) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append("^");
        sb.append(helper(root.left, map, res));
        sb.append("^");
        sb.append(helper(root.right, map, res));
        String rootPrint = sb.toString();
        if (!map.containsKey(rootPrint)) {
            map.put(rootPrint, false);
        } else if (map.get(rootPrint) == false) {
            res.add(root);
            map.put(rootPrint, true);
        }
        return rootPrint;
    }
}