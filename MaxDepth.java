public class MaxDepth {
    /*
     * input: root of a binary tree
     * output: maximum depth of the binary tree
     * approach: recursive depth-first search (DFS)
     * time complexity: O(n) where n is the number of nodes in the tree
     * space complexity: O(h) where h is the height of the tree (due to recursion stack)
     *
     */
    public int maxDepth(TreeNode root){
        if(root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        MaxDepth solution = new MaxDepth();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int depth = solution.maxDepth(root);
        System.out.println("Max Depth: " + depth); // Output: Max Depth: 3
    }
}
