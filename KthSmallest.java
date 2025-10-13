

public class KthSmallest {
    private int count = 0;
    private int result = -1;
    private int kTarget;

    public int kthSmallest(TreeNode root, int k) {
        kTarget = k;
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode node) {
        if(node == null || count >= kTarget) {
            return;
        }
        inOrder(node.left);
        count++;

        if(count == kTarget) {
            result = node.val;
            return;
        }

        if(count < kTarget) {
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        KthSmallest solution = new KthSmallest();
        int k = 1;
        int kthSmallest = solution.kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element is: " + kthSmallest);
    }
}
