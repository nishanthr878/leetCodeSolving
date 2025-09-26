public class IsSameTree {
    /*
      *@param p: TreeNode
      *@param q: TreeNode
      *@return: boolean
      * Base Case 1: If both p and q are null (end of a branch).
      * Base Case 2: If only one is null (structural difference).
      * Base Case 3: If values are different (value mismatch).
      * Recursive Step: If none of the above, check subtrees recursively using AND.
     */
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q== null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        IsSameTree solution = new IsSameTree();
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(solution.isSameTree(p, q)); // Output: true

        TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(solution.isSameTree(p2, q2)); // Output: false

        TreeNode p3 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q3 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println(solution.isSameTree(p3, q3)); // Output: false
    }
}
