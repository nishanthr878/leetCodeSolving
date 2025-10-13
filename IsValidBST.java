public class IsValidBST {
    /*
     * @param root: The root of the binary tree.
     * @return: True if the binary tree is BST, or false
     * isValidBST_Helper(node, min_bound, max_bound):
     * Base Case: If node is null, it's a valid empty BST. Return true.
     * Validation Check: Check if node.val violates the current bounds.
     *  If node.val <= min_bound OR node.val >= max_bound, return false.
     *  (Remember, the comparison must be strict—hence the non-inclusive boundaries).
     * Recursive Step (Left): Recursively check the left child.
     *  Call isValidBST_Helper(node.left, min_bound, node.val).
     *  The max_bound is tightened to node.val.
     * Recursive Step (Right): Recursively check the right child.
     *  Call isValidBST_Helper(node.right, node.val, max_bound).
     *  The min_bound is tightened to node.val.
     */
    public boolean isValidBST(TreeNode root) {
        long minBound = Long.MIN_VALUE;
        long maxBound = Long.MAX_VALUE;
        return isValidBST_Helper(root, minBound, maxBound);
    }

    private boolean isValidBST_Helper(TreeNode node, long minBound, long maxBound) {
        if(node == null) {
            return true;
        }

        if (node.val <= minBound || node.val >= maxBound) {
            return false;
        }

        return isValidBST_Helper(node.left, minBound, node.val) && isValidBST_Helper(node.right, node.val, maxBound);
    }


    public static void main(String[] args) {
        IsValidBST solution = new IsValidBST();

        // Test case 1: Valid BST
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println(solution.isValidBST(root1)); // Expected output: true

        // Test case 2: Invalid BST
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println(solution.isValidBST(root2)); // Expected output: false

        // Test case 3: Single node (valid BST)
        TreeNode root3 = new TreeNode(1);
        System.out.println(solution.isValidBST(root3)); // Expected output: true

        // Test case 4: Empty tree (valid BST)
        System.out.println(solution.isValidBST(null)); // Expected output: true

        // Test case 5: Larger valid BST
        TreeNode root4 = new TreeNode(10);
        root4.left = new TreeNode(5);
        root4.right = new TreeNode(15);
        root4.right.left = new TreeNode(12);
        root4.right.right = new TreeNode(20);
        System.out.println(solution.isValidBST(root4)); // Expected output: true
    }
}
