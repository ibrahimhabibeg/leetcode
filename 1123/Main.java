import java.util.HashMap;

class Main {
    public static void main(String[] args) {

    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        HashMap<TreeNode, Integer> depthMap = new HashMap<TreeNode, Integer>();
        depthMap.put(null, -1);
        getTreeDepth(root, depthMap);
        while (depthMap.get(root.left) != depthMap.get(root.right)) {
            if (depthMap.get(root.left) > depthMap.get(root.right))
                root = root.left;
            else
                root = root.right;
        }
        return root;
    }

    private int getTreeDepth(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null)
            return -1;
        int treeDepth = 1 + Math.max(getTreeDepth(root.left, map), getTreeDepth(root.right, map));
        map.put(root, treeDepth);
        return treeDepth;
    }
}