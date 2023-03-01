class Main {
    public static void main(String[] args) {

    }

    public int maxAncestorDiff(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        } else if (root.left == null) {
            int maxDiffIncRoot = Math.max(Math.abs(root.val - smallestNodeInTree(root.right)),
                    Math.abs(root.val - largestNodeInTree(root.right)));
            return Math.max(maxDiffIncRoot, maxAncestorDiff(root.right));
        } else if (root.right == null) {
            int maxDiffIncRoot = Math.max(Math.abs(root.val - smallestNodeInTree(root.left)),
                    Math.abs(root.val - largestNodeInTree(root.left)));
            return Math.max(maxDiffIncRoot, maxAncestorDiff(root.left));
        } else {
            int maxDiffIncRootRight = Math.max(Math.abs(root.val - smallestNodeInTree(root.right)),
                    Math.abs(root.val - largestNodeInTree(root.right)));
            int maxR = Math.max(maxDiffIncRootRight, maxAncestorDiff(root.right));
            int maxDiffIncRootLeft = Math.max(Math.abs(root.val - smallestNodeInTree(root.left)),
                    Math.abs(root.val - largestNodeInTree(root.left)));
            int maxL = Math.max(maxDiffIncRootLeft, maxAncestorDiff(root.left));
            return Math.max(maxR, maxL);
        }
    }

    public int smallestNodeInTree(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;
        else
            return Math.min(root.val, Math.min(smallestNodeInTree(root.left), smallestNodeInTree(root.right)));
    }

    public int largestNodeInTree(TreeNode root) {
        if (root == null)
            return 0;
        else
            return Math.max(root.val, Math.max(largestNodeInTree(root.left), largestNodeInTree(root.right)));
    }

    public int maxAncestorDiffBetter(TreeNode root) {
       return maxDiffWithMaxMin(root, root.val, root.val);
    }
    public int maxDiffWithMaxMin(TreeNode root, int max, int min){
        if(root==null) return max-min;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        return Math.max(maxDiffWithMaxMin(root.left, max, min), maxDiffWithMaxMin(root.right, max, min));
    }
}