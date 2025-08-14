import java.util.ArrayList;
import java.util.List;

public class FindModeInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        FindModeInBST finder = new FindModeInBST();
        List<Integer> result = finder.findMode(root);

        System.out.print("Modes: ");
        for (int mode : result) {
            System.out.print(mode + " ");
        }
    }

    public List<Integer> findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        TreeNode current = root;
        TreeNode prev = null;
        int count = 0;
        int maxCount = 0;

        while (current != null) {
            if (current.left == null) {
                if (prev != null && prev.val == current.val) {
                    count++;
                } else {
                    count = 1;
                }

                if (count > maxCount) {
                    maxCount = count;
                    modes.clear();
                    modes.add(current.val);
                } else if (count == maxCount) {
                    modes.add(current.val);
                }

                prev = current;
                current = current.right;
            } else {
                TreeNode pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;

                    if (prev != null && prev.val == current.val) {
                        count++;
                    } else {
                        count = 1;
                    }

                    if (count > maxCount) {
                        maxCount = count;
                        modes.clear();
                        modes.add(current.val);
                    } else if (count == maxCount) {
                        modes.add(current.val);
                    }

                    prev = current;
                    current = current.right;
                }
            }
        }

        return modes;
    }
}