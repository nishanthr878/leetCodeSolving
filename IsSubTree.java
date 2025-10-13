public class IsSubTree {
    /*
     * @param root: the root of the tree
     * @param subRoot: the root of the subtree
     * @return: true if there is a subtree of root with the same structure and node
     *         values of subRoot and false otherwise
     *
     * The Comparison Function: isSubtreeMatch(R,S). (This is done!)
     * The Traversal: DFS on the root tree.
     */
    public boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) {
            return true;
        }
        if(root == null && subRoot != null) {
            return false;
        }
        if(isSubTreeMatch(root, subRoot)) {
            return true;
        }
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    private boolean isSubTreeMatch(TreeNode R, TreeNode S) {
        if(R == null && S == null) {
            return true;
        }
        if(R == null || S == null) {
            return false;
        }

        return ((R.val == S.val) && isSubTreeMatch(R.left, S.left) && isSubTreeMatch(R.right, S.right));
    }


    public static void main(String[] args) {
        IsSubTree solution = new IsSubTree();

        // Test case 1: Basic test case
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(0);

        TreeNode subRoot1 = new TreeNode(4);
        subRoot1.left = new TreeNode(1);
        subRoot1.right = new TreeNode(2);

        System.out.println(solution.isSubTree(root1, subRoot1)); // Expected output: true

        // Test case 2: Subtree not present
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(2);

        TreeNode subRoot2 = new TreeNode(4);
        subRoot2.left = new TreeNode(1);
        subRoot2.right = new TreeNode(3);

        System.out.println(solution.isSubTree(root2, subRoot2)); // Expected output: false

        // Test case 3: Both trees are null
        System.out.println(solution.isSubTree(null, null)); // Expected output: true

        // Test case 4: Subtree is null
        TreeNode root4 = new TreeNode(1);
        System.out.println(solution.isSubTree(root4, null)); // Expected output: true

        // Test case 5: Main tree is null but subtree is not
        TreeNode subRoot5 = new TreeNode(1);
        System.out.println(solution.isSubTree(null, subRoot5)); // Expected output: false
    }
}
