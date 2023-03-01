import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> s = new Stack<TreeNode>();
    TreeNode node;

    public BSTIterator(TreeNode root) {
        s.add(root);
        node = root.left;
    }

    public int next() {
        while(true){
            if(node!=null){
                s.add(node);
                node = node.left;
            }else{
                TreeNode x = s.pop();
                node = x.right;
                return x.val;
            }
        }
    }

    public boolean hasNext() {
        return !s.isEmpty() || node!=null;
    }
}
