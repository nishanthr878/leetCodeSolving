public class InvertingBinaryTree {
    /*
    * Start at the root.
    * Swap its left and right children.
    * Then, re-apply this entire process to the new left child.
    * And re-apply this entire process to the new right child.
    * Stop when you reach a node that is "null."
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        InvertingBinaryTree it = new InvertingBinaryTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode invertedRoot = it.invertTree(root);
        // The inverted tree should now have the structure:
        //      4
        //     / \
        //    7   2
        //   / \ / \
        //  9  6 3  1
        System.out.println(invertedRoot.val); // Output: 4
        System.out.println(invertedRoot.left.val); // Output: 7
        System.out.println(invertedRoot.right.val); // Output: 2
        System.out.println(invertedRoot.left.left.val); // Output: 9
        System.out.println(invertedRoot.left.right.val); // Output: 6
        System.out.println(invertedRoot.right.left.val); // Output: 3
        System.out.println(invertedRoot.right.right.val); // Output: 1
    }
}
