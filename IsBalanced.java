public class IsBalanced {
    /*
     * Algorithm to determine if a binary tree is height-balanced.
     * A binary tree is height-balanced if for every node, the height difference
     * between its left and right subtrees is at most 1.
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * Space Complexity: O(h), where h is the height of the tree (due to recursion stack).
     * @param root The root of the binary tree.
     * @return True if the tree is height-balanced, false otherwise.
     */
    public boolean isBalanced(TreeNode root){
        if(height(root) == -1){
            return false;
        }
        return true;
    }
    private int height(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        IsBalanced solution = new IsBalanced();

        // Example 1: Balanced tree
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        System.out.println(solution.isBalanced(root1)); // Output: true

        // Example 2: Unbalanced tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);
        System.out.println(solution.isBalanced(root2)); // Output: false
    }
}
