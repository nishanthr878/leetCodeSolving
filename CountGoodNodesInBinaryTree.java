public class CountGoodNodesInBinaryTree {
    /*
     * Base Case: If node is null, what should the function return?
     * Good Node Check: (You already solved this!) If node.val ≥ max_val_path, add 1 to our count.
     * Update: Calculate the new_max_val to pass down.
     * Recursive Calls: Call the function on the left and right children.
     * Return Value: What should the function return to ensure we correctly sum up all the good nodes across the entire tree?
     * (Hint: It involves the result of the recursive calls and the count from the current node.)
     */
    public int goodNodes(TreeNode root) {
        int maxVal = Integer.MIN_VALUE;
        return countGoodNodes(root, maxVal);
    }

    private int countGoodNodes(TreeNode root, int maxVal) {
        if(root == null) {
            return 0;
        }
        int count = 0;

        if(root.val >= maxVal) {
            count++;
            maxVal = root.val;
        }
        count += countGoodNodes(root.left, maxVal);
        count += countGoodNodes(root.right, maxVal);
        return count;
    }

    public static void main(String[] args) {
        CountGoodNodesInBinaryTree solution = new CountGoodNodesInBinaryTree();

        // Example 1:
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.left = new TreeNode(3);
        root1.right.right = new TreeNode(5);
        System.out.println(solution.goodNodes(root1)); // Output: 4

        // Example 2:
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(2);
        System.out.println(solution.goodNodes(root2)); // Output: 3
    }
}
