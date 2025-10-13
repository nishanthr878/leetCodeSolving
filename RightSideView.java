import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    /*
     * @param root: the root of the binary tree
     * @return: return a list of integers
     * Initialize: Create an empty Result List (our ArrayList) and a Queue.
     * If the root is not null, add it to the Queue.
     * Iterate: While the Queue is not empty:
     * a. Get the size (L) of the Queue. This L is the number of nodes on the current level.
     * b. Loop L times (from i=0 to i<L):
     * i. Dequeue the current node.
     * ii. If the current node has a left child, enqueue it.
     * iii. If the current node has a right child, enqueue it.
     * iv. Identify Rightmost: Check if this is the last node in the loop (i.e., if i=L−1).
     * v. If it is the last node, add its value to the Result List.
     */
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> LevelStage = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        LevelStage.offer(root);
        while (!LevelStage.isEmpty()) {
            int levelSize = LevelStage.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode currentNode = LevelStage.poll();

                if(currentNode.left != null) {
                    LevelStage.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    LevelStage.offer(currentNode.right);
                }

                if(i == levelSize - 1) {
                    result.add(currentNode.val);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RightSideView solution = new RightSideView();

        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> rightView = solution.rightSideView(root);
        System.out.println(rightView); // Output: [1, 3, 4]
    }
}
