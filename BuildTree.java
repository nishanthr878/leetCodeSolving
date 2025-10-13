import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private int preIndex = 0;
    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;

        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(0, inorder.length -1);
    }

    /**
     * Recursive helper function to build the tree.
     * @param inStart The start index of the current inorder segment.
     * @param inEnd The end index of the current inorder segment.
     * @return The root of the constructed subtree.
     */
    private TreeNode build(int inStart, int inEnd) {
        if(inStart > inEnd) {
            return null;
        }

        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);

        int rootInIndex = inorderMap.get(rootValue);

        root.left = build(inStart, rootInIndex -1);
        root.right = build(rootInIndex +1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        BuildTree builder = new BuildTree();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode root = builder.buildTree(preorder, inorder);

        // Function to print the tree in order (for verification)
        printInOrder(root);

    }
    public static void printInOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }
}
