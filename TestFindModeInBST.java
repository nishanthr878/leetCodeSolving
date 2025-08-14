import java.util.List;

public class TestFindModeInBST {
    public static void main(String[] args) {
        FindModeInBST finder = new FindModeInBST();

        // Test Case 1: Single-node BST with no duplicates
        TreeNode root1 = new TreeNode(1);
        List<Integer> result1 = finder.findMode(root1);
        System.out.println("Test Case 1: Single-node BST with no duplicates");
        System.out.println("Expected Output: [1]");
        System.out.println("Actual Output: " + result1);
        System.out.println();

        // Test Case 2: BST with duplicates
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        List<Integer> result2 = finder.findMode(root2);
        System.out.println("Test Case 2: BST with duplicates");
        System.out.println("Expected Output: [2]");
        System.out.println("Actual Output: " + result2);
        System.out.println();

        // Test Case 3: BST with multiple modes
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        root3.left.right = new TreeNode(3);
        List<Integer> result3 = finder.findMode(root3);
        System.out.println("Test Case 3: BST with multiple modes");
        System.out.println("Expected Output: [2, 3]");
        System.out.println("Actual Output: " + result3);
    }
}
