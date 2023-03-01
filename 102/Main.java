import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Main main = new Main();
        List<List<Integer>> ans = main.levelOrder(root);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        List<Integer> levelNodes = new ArrayList<Integer>();
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        map.put(root, 0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null)
                continue;
            int nodeLevel = map.get(node);
            if (nodeLevel != level) {
                level = nodeLevel;
                res.add(new ArrayList<Integer>(levelNodes));
                levelNodes = new ArrayList<Integer>();
            }
            levelNodes.add(node.val);
            queue.add(node.left);
            queue.add(node.right);
            map.put(node.left, nodeLevel + 1);
            map.put(node.right, nodeLevel + 1);
        }
        res.add(levelNodes);
        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<Integer>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            res.add(levelNodes);
        }
        return res;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<Integer>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(node==null)
                    continue;
                levelNodes.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if(levelNodes.size()!=0)
                res.add(levelNodes);
        }
        return res;
    }
}