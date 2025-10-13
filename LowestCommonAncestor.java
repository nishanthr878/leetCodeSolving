public class LowestCommonAncestor {
    /*
     * @param root: The root of the binary search tree.
     * @param p: A node in the binary search tree
     * @param q: A node in the binary search tree
     * @return: The lowest common ancestor of the two nodes
     *
     * Algorithm:
     * Start at the root and continuously traverse down until one of these three conditions is met:
     * 1. if p < current_node and q < current_node → Move Left
     * 2. if p > current_node and q > current_node → Move Right
     * 3. If p and q are on opposite sides, or if one of them is the current_node → The current node is the LCA!
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while(current != null) {

            if(p.val > current.val && q.val > current.val) {
                current = current.right;
            }

            else if (p.val < current.val && q.val < current.val) {
                current = current.left;
            }

            else {
                return current;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LowestCommonAncestor solution = new LowestCommonAncestor();

        // Test case 1: Basic test case
        TreeNode root1 = new TreeNode(6);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(4);
        root1.left.right.left = new TreeNode(3);
        root1.left.right.right = new TreeNode(5);
        root1.right.left = new TreeNode(7);
        root1.right.right = new TreeNode(9);

        TreeNode p1 = root1.left; // Node with value 2
        TreeNode q1 = root1.right; // Node with value 8

        System.out.println(solution.lowestCommonAncestor(root1, p1, q1).val); // Expected output: 6

        // Test case 2: One node is the ancestor of the other
        TreeNode p2 = root1.left; // Node with value 2
        TreeNode q2 = root1.left.right; // Node with value 4

        System.out.println(solution.lowestCommonAncestor(root1, p2, q2).val); // Expected output: 2

        // Test case 3: Both nodes are on the same side
        TreeNode p3 = root1.left.right.left; // Node with value 3
        TreeNode q3 = root1.left.right.right; // Node with value 5

        System.out.println(solution.lowestCommonAncestor(root1, p3, q3).val); // Expected output: 4

        // Test case 4: Nodes are the same
        TreeNode p4 = root1.right; // Node with value 8
        TreeNode q4 = root1.right; // Node with value 8

        System.out.println(solution.lowestCommonAncestor(root1, p4, q4).val); // Expected output: 8

        // Test case 5: Larger tree
        TreeNode root5 = new TreeNode(20);
        root5.left = new TreeNode(10);
        root5.right = new TreeNode(30);
        root5.left.left = new TreeNode(5);
        root5.left.right = new TreeNode(15);
        root5.right.left = new TreeNode(25);
        root5.right.right = new TreeNode(35);
        TreeNode p5 = root5.left.left; // Node with value 5
        TreeNode q5 = root5.left.right; // Node with value 15
        System.out.println(solution.lowestCommonAncestor(root5, p5, q5).val); // Expected output: 10
    }
}
